package lu.embellishedduck.starforgedgear.util;

import lu.embellishedduck.starforgedgear.StarforgedGear;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/*
Embellished Duck
@author Will Blanchard
 */
public class ModTags {

    public static class AllItemTags {

        //Instantiate Tags
        public static final TagKey<Item> HANDLE_WRAP_MATERIALS = ItemTags.create(newResourceLocation("handle_wrap_materials"));

        public static final TagKey<Item> MULTIBLOCK_TRIGGER = ItemTags.create(newResourceLocation("multiblock_trigger"));


        //Helper Method
        private static ResourceLocation newResourceLocation(String name) {
            return new ResourceLocation(StarforgedGear.MOD_ID, name);
        }//End of Method
    }//End of Subclass

    public static class AllBlockTags {

        //Instantiate Tags
        public static final TagKey<Block> MULTIBLOCK_COMPONENT = BlockTags.create(newResourceLocation("multiblock_component"));

        //Helper Method
        private static ResourceLocation newResourceLocation(String name) {
            return  new ResourceLocation(StarforgedGear.MOD_ID, name);
        }//End of Method
    }//End of Subclass
}//End of Class
