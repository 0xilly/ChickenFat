package us.illyohs.chickenfat.common.block.tile

import net.minecraft.block.BlockSlab
import net.minecraft.block.state.IBlockState
import net.minecraft.init.Blocks
import net.minecraft.util.math.BlockPos

class TileHamsterWheel
  extends TileEquipment {

  def checkForValidStructure: Boolean = {
    val tilePos = getPos
    val stone   = Blocks.STONE_SLAB.getBlockState.getBaseState
      .withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.TOP)

    val getState = worldObj.getBlockState(tilePos)

    val isThereAPillar:Boolean = false
    val pillarArray:Array[BlockPos] = Array(pos.down(1), pos.down(2))
    val floorArray:Array[BlockPos]  = Array(pos.down(3),
      pos.down(3).east(1),
      pos.down(3).east(2),
      pos.down(3).west(1),
      pos.down(3).west(2),
      pos.down(3).north(1),
      pos.down(3).north(2),
      pos.down(3).north(2).east(1),
      pos.down(3).north(2).west(1),
      pos.down(3).south(2).east(1),
      pos.down(3).south(2).west(1),
      pos.down(3).south(1),
      pos.down(3).south(2)
    )

    //ioStuffs
    val northEast = pos.down(3).north(3).east(3)
    val northWest = pos.down(3).north(3).west(3)
    val southEast = pos.down(3).south(3).east(3)
    val southWest = pos.down(3).south(3).west(3)
    //ioSuffs

    if (areAllTheSameBlock(pillarArray, Blocks.STONE.getBlockState.getBaseState)) {

    }


    false
  }

  def areAllTheSameBlock(states:Array[BlockPos], iBlockState: IBlockState): Boolean = {
    for (i <- states) {
      if (worldObj.getBlockState(i) != iBlockState) {
        false
      }
    }
    true
  }
}
