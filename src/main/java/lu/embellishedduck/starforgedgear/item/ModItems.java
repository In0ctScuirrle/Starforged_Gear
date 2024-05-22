package lu.embellishedduck.starforgedgear.item;

import lu.embellishedduck.starforgedgear.StarforgedGear;
import net.neoforged.neoforge.registries.DeferredRegister;

/*
Embellished Duck
@author Will Blanchard
 */
public class ModItems {

    //Make Deferred Register
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(StarforgedGear.MOD_ID);

    //How to instantiate item in neoforge
    //public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(Item.Properties()));
}//End of Class
