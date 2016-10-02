package us.illyohs.chickenfat.common.core

import net.minecraftforge.fml.common.{Mod, SidedProxy}
import net.minecraftforge.fml.common.Mod.{EventHandler, Instance}
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}

import us.illyohs.chickenfat.common.CommonProxy
import us.illyohs.chickenfat.common.core.util.ModInfo._

@Mod(
  name = NAME,
  modid = ID,
  version = VERSION,
  modLanguage = "scala"
)
object HamsterWheels {

  @Instance(ID)
  var instance = this

  @SidedProxy(modId = ID, clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
  var proxy:CommonProxy = null

  @EventHandler
  def preInit(e:FMLPreInitializationEvent): Unit = {
    proxy.preInit(e)
  }

  @EventHandler
  def init(e:FMLInitializationEvent): Unit = {
    proxy.init(e)
  }

  @EventHandler
  def postInit(e:FMLPostInitializationEvent): Unit = {
    proxy.postInit(e)
  }
}
