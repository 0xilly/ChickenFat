package us.illyohs.chickenfat.common.compact

import java.util

import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}


object ModuleLoader {

  private val modules: util.List[Module] = new util.ArrayList[Module]()

  def preInit(e:FMLPreInitializationEvent): Unit =  {
    for (i <- 0 until modules.size) {
      val isLoaded = modules.get(i).isModLoaded
      if (isLoaded)  {
        modules.get(i).preInit(e)
      }
    }
  }

  def init(e:FMLInitializationEvent): Unit =  {
    for (i <- 0 until modules.size) {
      val isLoaded = modules.get(i).isModLoaded
      if (isLoaded)  {
        modules.get(i).init(e)
      }
    }
  }

  def preInit(e:FMLPostInitializationEvent): Unit =  {
    for (i <- 0 until modules.size) {
      val isLoaded = modules.get(i).isModLoaded
      if (isLoaded)  {
        modules.get(i).postInit(e)
      }
    }
  }
}
