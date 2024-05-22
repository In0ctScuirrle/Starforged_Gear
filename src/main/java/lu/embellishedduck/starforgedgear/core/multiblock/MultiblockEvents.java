package lu.embellishedduck.starforgedgear.core.multiblock;

import lu.embellishedduck.starforgedgear.StarforgedGear;
import lu.embellishedduck.starforgedgear.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

/*
Embellished Duck
@author Will Blanchard
 */
@Mod.EventBusSubscriber(modid = StarforgedGear.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MultiblockEvents {

    //Method to get the position of a block when right-clicked by the player, will overload this method with the specific trigger items too
    @SubscribeEvent
    public static void getPositionOnRightClick(PlayerInteractEvent.RightClickBlock event) {
        Level world = event.getLevel();
        BlockPos blockPos = event.getPos();

        if(!world.isClientSide) {//Ensuring it's not on the client side

        }//End of If statement
    }//End of Method

    //Helper method to find out whether the block that is rightClicked
    private static boolean isMultiblockComponent(BlockState state) {
        return state.is(ModTags.AllBlockTags.MULTIBLOCK_COMPONENT);
    }//End of Helper Method
}//End of Class
