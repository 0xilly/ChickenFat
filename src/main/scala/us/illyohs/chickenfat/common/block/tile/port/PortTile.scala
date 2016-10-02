package us.illyohs.chickenfat.common.block.tile.port

import net.minecraft.tileentity.TileEntity
import net.minecraft.util.ITickable
import net.minecraft.util.math.BlockPos

import us.illyohs.chickenfat.common.block.tile.TileEquipment

class PortTile
  extends TileEntity with ITickable {

  override def update(): Unit = {

  }

  val _posArray:Array[BlockPos] = Array(
    pos.east(3).north(3).up(2),// North East
    pos.west(3).north(3).up(2),// North West
    pos.east(3).south(3).up(2),// South East
    pos.west(3).south(3).up(2) // South West
  )

  def isInValidLocation(posArray:Array[BlockPos]): Boolean = {
    for (i <- posArray) {
      if (!worldObj.getTileEntity(i).isInstanceOf[TileEquipment]) {
        false
      }
    }
    true
  }
}