package lu.embellishedduck.starforgedgear.datagen;

import lu.embellishedduck.starforgedgear.StarforgedGear;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;


/*
Embellished Duck
@author Will Blanchard
 */
public class DataGeneration {

    //Method to run all instantiated data generators
    public static void gatherData(GatherDataEvent event) {
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput output = event.getGenerator().getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        //Add the data generators
        dataGenerator.addProvider(true, new ModEnLangProvider(output));
        dataGenerator.addProvider(true, new ModItemModelProvider(output, existingFileHelper));
    }//End of Method
}//End of Class
