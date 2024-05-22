package lu.embellishedduck.starforgedgear.util;

import lu.embellishedduck.starforgedgear.StarforgedGear;
import lu.embellishedduck.starforgedgear.core.multiblock.MultiblockRegistry;
import lu.embellishedduck.starforgedgear.core.multiblock.MultiblockStructure;
import lu.embellishedduck.starforgedgear.core.multiblock.MultiblockStructureLoader;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import java.io.IOException;
import java.util.List;

/*
Embellished Duck
@author Will Blanchard
 */
@Mod.EventBusSubscriber(modid = StarforgedGear.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class StartupEventListener {

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        //Run the MultiblockStructureLoader to load multiblock structures
        MultiblockStructureLoader multiblockStructureLoader = new MultiblockStructureLoader("data/" + StarforgedGear.MOD_ID + "/multiblocks");
        try {
            List<MultiblockStructure> structures = multiblockStructureLoader.loadStructures();
            //Register the loaded multiblocks with the Multiblock registry
            MultiblockRegistry.getInstance().registerMultiblocks(structures);
        } catch (IOException e){
            e.printStackTrace();
        }//End of Try-Catch statement
    }//End of Method
}//End of Class
