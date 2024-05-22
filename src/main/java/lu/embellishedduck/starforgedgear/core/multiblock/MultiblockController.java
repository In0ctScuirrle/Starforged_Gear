package lu.embellishedduck.starforgedgear.core.multiblock;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.List;

/*
Embellished Duck
@author Will Blanchard
 */
public class MultiblockController {

    //Instantiate Variables

    private MultiblockStructure multiblockStructure;

    //Constructor
    public MultiblockController(MultiblockStructure multiblockStructure) {
        this.multiblockStructure = multiblockStructure;
    }//End of Constructor


    //Method to inspect the structure if all the component blocks are in the correct positions, then it checks if the block at that position is the correct one for that position
    private boolean checkForAssembly(Level world, BlockPos clickedPos) {
        boolean allBlocksCorrect = true;
        boolean allPositionsCorrect = true;

        List<Block> missingBlocks = new ArrayList<>();

        //First the real central positions of the multiblock must be calculated
        int length = multiblockStructure.getLength();
        int height = multiblockStructure.getHeight();
        int width = multiblockStructure.getWidth();

        int xOffset = length / 2;
        int yOffset = height / 2;
        int zOffset = width / 2;

        int centerX = clickedPos.getX() - xOffset;
        int centerY = clickedPos.getY() - yOffset;
        int centerZ = clickedPos.getZ() - zOffset;

        BlockPos centerPos = new BlockPos(centerX, centerY, centerZ);

        //Logic which checks the area around the center block
        for(int x = centerX; x < centerX + length; x++) {
            for(int y = centerY; y < centerY + height; y++) {
                for(int z = centerZ; z < centerZ + width; z++) {
                    BlockPos pos = new BlockPos(x, y, z);
                    BlockState state = world.getBlockState(pos);
                    Block block = state.getBlock();

                    if(multiblockStructure.getComponentBlocks().contains(block)) {
                        int index = multiblockStructure.getComponentBlocks().indexOf(block);
                        BlockPos relativePos = multiblockStructure.getComponentBlockPositions().get(index);
                        BlockPos realPos = new BlockPos(centerPos.getX() + relativePos.getX(), centerPos.getY() + relativePos.getY(), centerPos.getZ() + relativePos.getZ());

                        if(!realPos.equals(pos)) {
                            allPositionsCorrect = false;
                        }//End of If statement
                    } else {
                        allBlocksCorrect = false;
                        missingBlocks.add(block);
                    }//End of If-Else statement
                }//End of For loop
            }//End of For loop

            if(!allBlocksCorrect && !allPositionsCorrect) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Some blocks are incorrect and in the wrong positions."));
            } else if (!allBlocksCorrect) {
                //Send a message to the player indicating which blocks are missing from the structure
                StringBuilder errorMessage = new StringBuilder("Some required blocks are missing: ");
                for(Block missingBlock : missingBlocks) {
                    errorMessage.append(missingBlock.getName()).append(".");
                }//End of For-Each loop
                errorMessage.deleteCharAt(errorMessage.length() -1);//Remove the trailing comma
                errorMessage.append(".");
                Minecraft.getInstance().player.sendSystemMessage(Component.literal(errorMessage.toString()));

            } else if (!allPositionsCorrect) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Some blocks are in the wrong spots"));
            } else {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal(multiblockStructure.getName() + " Assembled!"));
            }//End of If-Else-If-Else-If-Else
        }//End of For loop
        return allBlocksCorrect && allPositionsCorrect;
    }//End of Method
}//End of Class
