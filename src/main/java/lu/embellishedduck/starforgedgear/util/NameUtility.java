package lu.embellishedduck.starforgedgear.util;

import lu.embellishedduck.starforgedgear.StarforgedGear;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

/*
Embellished Duck
@author Will Blanchard
 */
public class NameUtility {

    public static String getItemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(StarforgedGear.MOD_ID + ":", "");
    }//End of Class
}//End of Class
