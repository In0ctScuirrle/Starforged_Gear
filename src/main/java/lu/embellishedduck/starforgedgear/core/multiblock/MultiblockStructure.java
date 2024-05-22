package lu.embellishedduck.starforgedgear.core.multiblock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;

import java.util.List;

/*
Embellished Duck
@author Will Blanchard
 */
public class MultiblockStructure {

    //Instantiate Variables
    public String name;
    private int length;//x
    private int height;//y
    private int width;//z
    private int volume;

    public List<Block> componentBlocks;
    public List<BlockPos> componentBlockPositions;

    private MultiblockController multiblockController;

    //Constructor
    public MultiblockStructure() {}//Empty Constructor

    public MultiblockStructure(String name, int length, int height, int width, int volume, List<Block> componentBlocks, List<BlockPos> componentBlockPositions) {
        this.name = name;
        this.length = length;
        this.height = height;
        this.width = width;
        this.volume = volume;
        this.componentBlocks = componentBlocks;
        this.componentBlockPositions = componentBlockPositions;
    }//End of Constructor

    public MultiblockStructure(String name, int length, int height, int width, List<Block> componentBlocks, List<BlockPos> componentBlockPositions,
                               MultiblockController controller) {
        this.name = name;
        this.length = length;
        this.height = height;
        this.width = width;
        this.volume = length * width * height;
        this.componentBlocks = componentBlocks;
        this.componentBlockPositions = componentBlockPositions;
        this.multiblockController = controller;
    }//End of Constructor


    //Getters
    public String getName() {
        return name;
    }
    public int getLength() {
        return length;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public int getVolume() {
        return volume;
    }
    public List<Block> getComponentBlocks() {
        return componentBlocks;
    }
    public List<BlockPos> getComponentBlockPositions() {
        return componentBlockPositions;
    }
    public MultiblockController getMultiblockController() {
        return multiblockController;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public void setComponentBlocks(List<Block> componentBlocks) {
        this.componentBlocks = componentBlocks;
    }
    public void setComponentBlockPositions(List<BlockPos> componentBlockPositions) {
        this.componentBlockPositions = componentBlockPositions;
    }
    public void setMultiblockController(MultiblockController multiblockController) {
        this.multiblockController = multiblockController;
    }

}//End of Class
