package us.illyohs.chickenfat.client.render

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
import net.minecraft.util.EnumFacing

import net.minecraftforge.fml.common.registry.GameRegistry

import us.illyohs.chickenfat.api.siphon.Siphonable
import us.illyohs.chickenfat.common.block.tile.TileAnimationTest

class RenderTestTile extends TileEntitySpecialRenderer[TileAnimationTest] {

  override def renderTileEntityAt(te: TileAnimationTest, x:Double, y:Double, z:Double, pTicks:Float, dStage:Int): Unit = {
    val reg = GameRegistry.findRegistry(classOf[Siphonable]).getValues

    for (i <- 0 until reg.size) {
      if (te.getAttachedEntity == reg.get(i).getEntity)
      reg.get(i).getOverrideRenderer.addRender(x, y, z, EnumFacing.DOWN, pTicks)
    }
  }
}
