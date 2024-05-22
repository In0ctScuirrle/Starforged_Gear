package lu.embellishedduck.starforgedgear.core.multiblock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Embellished Duck
@author Will Blanchard
 */
public class MultiblockRegistry {

    //Instantiate Variables
    private static final MultiblockRegistry INSTANCE = new MultiblockRegistry();
    private final Map<String, MultiblockStructure> multiblocks = new HashMap<>();

    private MultiblockRegistry () {}//Private Constructor

    //Method to get the instance
    public static MultiblockRegistry getInstance() {
        return INSTANCE;
    }//End of Method

    //Method to register all multiblocks
    public void registerMultiblocks(List<MultiblockStructure> structureList) {
        for (MultiblockStructure structure : structureList) {
            multiblocks.put(structure.getName(), structure);
        }//End of For-Each loop
    }//End of Method

    public MultiblockStructure getMultiblock(String name) {
        return multiblocks.get(name);
    }//End of Method
}//End of Class
