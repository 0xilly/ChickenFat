package us.illyohs.chickenfat.common.core.handler

import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent

object PlayerHandler {

  @SubscribeEvent
  def playerInteract(e:RightClickBlock): Unit = {
    val block = e.getPos.east(3).north(3).up(2)
//    System.out.println(e.getWorld.getBlockState(block).getBlock.getLocalizedName)
  }
}
