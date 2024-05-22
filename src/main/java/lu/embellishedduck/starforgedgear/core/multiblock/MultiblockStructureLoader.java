package lu.embellishedduck.starforgedgear.core.multiblock;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

/*
Embellished Duck
@author Will Blanchard
 */
public class MultiblockStructureLoader {

    //Instantiate Variables
    private final String DIRECTORY_PATH;
    private final String DONE_FILE_PATH;


    //Constructor
    public MultiblockStructureLoader(String DIRECTORY_PATH) {
        this.DIRECTORY_PATH = DIRECTORY_PATH;
        this.DONE_FILE_PATH = DIRECTORY_PATH + File.separator + "done.txt";
    }//End of Constructor



    //Method to load the structures ignoring ones that have already been loaded
    public List<MultiblockStructure> loadStructures() throws IOException {
        List<MultiblockStructure> multiblockStructures = new ArrayList<>();
        List<String> doneFiles = getDoneFiles();

        //Get list of JSON files in directory
        File directory = new File(DIRECTORY_PATH);
        File[] files = directory.listFiles(((dir, name) -> name.toLowerCase().endsWith(".json")));

        if (files != null) {
            for (File file : files) {
                if (!doneFiles.contains(file.getName())) {
                    //Load structures from json file
                    List<MultiblockStructure> fileStructures = loadStructuresFromFile(file.getAbsolutePath());
                    multiblockStructures.addAll(fileStructures);
                    //Mark file as done
                    markFilesAsDone(file.getName());
                }//End of If statement
            }//End of For loop
        }//End of If statement
        return multiblockStructures;
    }//End of Method


    //Method to get which files have been loaded
    private List<String> getDoneFiles() throws IOException {
        List<String> doneFiles = new ArrayList<>();
        File doneFile = new File(DONE_FILE_PATH);
        if(doneFile.exists()) {
            try(BufferedReader reader = new BufferedReader(new FileReader(doneFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    doneFiles.add(line);
                }//End of While loop
            }//End of Try statement
        }//End of If statement
        return doneFiles;
    }//End of Method


    //Method to "mark" a method as done
    private void markFilesAsDone(String fileName) throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(DONE_FILE_PATH, true))){
            writer.write(fileName);
            writer.newLine();
        }
    }


    //Method to load the structure from the actual file
    private List<MultiblockStructure> loadStructuresFromFile(String filePath) throws IOException {
        List<MultiblockStructure> structures = new ArrayList<>();

        //Read JSON file
        JsonElement element = JsonParser.parseReader(new FileReader(filePath));
        if(element.isJsonArray()) {
            JsonArray jsonArray = element.getAsJsonArray();
            for(JsonElement jsonElement : jsonArray) {
                if(jsonElement.isJsonObject()) {
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    String name = jsonObject.get("name").getAsString();
                    int length = jsonObject.get("length").getAsInt();
                    int height = jsonObject.get("height").getAsInt();
                    int width = jsonObject.get("width").getAsInt();
                    List<Block> componentBlocks = parseComponentBlocks(jsonObject.getAsJsonArray("componentBlocks"));
                    List<BlockPos> componentBlockPositions = parseComponentBlockPositions(jsonObject.getAsJsonArray("componentBlockPositions"));
                    MultiblockStructure structure = new MultiblockStructure(name, length, height, width, (length * height * width), componentBlocks, componentBlockPositions);
                    MultiblockController controller = new MultiblockController(structure);
                    structure.setMultiblockController(controller);
                    structures.add(structure);
                }//End of If-statement
            }//End of For-Each loop
        }//End of If-statement
        return structures;
    }//End of Method



    //Helper Method to parse component blocks
    private List<Block> parseComponentBlocks(JsonArray jsonArray) {
        List<Block> componentBlocks = new ArrayList<>();
        for(JsonElement element : jsonArray) {
            String blockName = element.getAsString();
            ResourceLocation blockID = new ResourceLocation(blockName);
            Block block = BuiltInRegistries.BLOCK.get(blockID);
            componentBlocks.add(block);
        }//End of For-Each loop
        return componentBlocks;
    }//End of Helper Method



    //Helper Method to parse component block positions
    private List<BlockPos> parseComponentBlockPositions(JsonArray jsonArray) {
        List<BlockPos> componentBlockPositions = new ArrayList<>();
        for(JsonElement element : jsonArray) {
            if(element.isJsonArray() && element.getAsJsonArray().size() >= 3) {
                int x = element.getAsJsonArray().get(0).getAsInt();
                int y = element.getAsJsonArray().get(1).getAsInt();
                int z = element.getAsJsonArray().get(2).getAsInt();
                componentBlockPositions.add(new BlockPos(x, y, z));
            }//End of If statement
        }//End of For-Each loop
        return componentBlockPositions;
    }//End of Helper Method


}//End of Class
