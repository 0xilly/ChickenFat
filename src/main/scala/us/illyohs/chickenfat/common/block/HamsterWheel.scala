package us.illyohs.chickenfat.common.block

import net.minecraft.block.ITileEntityProvider
import net.minecraft.block.material.Material
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World

import us.illyohs.chickenfat.common.block.tile.TileHamsterWheel

object HamsterWheel
  extends BaseBlock("hamsterwheel" ,Material.ROCK)
    with ITileEntityProvider {

  override def createNewTileEntity(worldIn: World, meta: Int): TileEntity = new TileHamsterWheel

}
