package lu.embellishedduck.starforgedgear.datagen;

import lu.embellishedduck.starforgedgear.StarforgedGear;
import lu.embellishedduck.starforgedgear.util.NameUtility;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

/*
Embellished Duck
@author Will Blanchard
 */
public class ModItemModelProvider extends ItemModelProvider {

    //Constructor
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, StarforgedGear.MOD_ID, existingFileHelper);
    }//End of Constructor

    @Override
    protected void registerModels() {

    }//End of Method

    //Method to generate the model for a simple item
    public void simpleItem(Item item) {
        String name = NameUtility.getItemName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/" + name);
    }//End of Method
}//End of Class
