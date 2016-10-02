package us.illyohs.chickenfat.common.compact

import net.minecraftforge.fml.common.Loader
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}

abstract class Module(modID:String) {

  def isModLoaded: Boolean = Loader.isModLoaded(modID)

  def preInit(e:FMLPreInitializationEvent): Unit

  def init(e:FMLInitializationEvent): Unit

  def postInit(e:FMLPostInitializationEvent): Unit
}
