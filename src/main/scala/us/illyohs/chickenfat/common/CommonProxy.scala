package us.illyohs.chickenfat.common

import net.minecraft.util.ResourceLocation

import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import net.minecraftforge.fml.common.registry.{FMLControlledNamespacedRegistry, GameRegistry, RegistryBuilder}

import us.illyohs.chickenfat.api.consumable.Consumable
import us.illyohs.chickenfat.api.siphon.Siphonable
import us.illyohs.chickenfat.common.core.handler.PlayerHandler
import us.illyohs.chickenfat.common.core.siphionables.ModSiphonabels
import us.illyohs.chickenfat.common.core.util.{LogUtils, MathUtils, ModInfo}

class CommonProxy {

  final private val SIPHONABLE:ResourceLocation = new ResourceLocation(ModInfo.ID, "siphonable")
  final private val CONSUMABLE:ResourceLocation = new ResourceLocation(ModInfo.ID, "consumable")

  final private var iSiphonableRegistry:FMLControlledNamespacedRegistry[Siphonable] = _
  final private var iConsumableRegistry:FMLControlledNamespacedRegistry[Consumable] = _

  this.iSiphonableRegistry = new RegistryBuilder[Siphonable]
    .setName(SIPHONABLE)
    .setIDRange(0, Short.MaxValue)
    .setType(classOf[Siphonable])
    .create
    .asInstanceOf[FMLControlledNamespacedRegistry[Siphonable]]

  this.iConsumableRegistry = new RegistryBuilder[Consumable]
    .setName(CONSUMABLE)
    .setIDRange(0, Short.MaxValue)
    .setType(classOf[Consumable])
    .create
    .asInstanceOf[FMLControlledNamespacedRegistry[Consumable]]

  def preInit(e:FMLPreInitializationEvent): Unit = {
    ModSiphonabels.init
  }

  def init(e:FMLInitializationEvent): Unit = {
    val siphonReg = GameRegistry.findRegistry(classOf[Siphonable])
    for (i <- 0 until siphonReg.getValues.size()) {
      val siphon = siphonReg.getValues.get(i)
      val name   = siphon.getRegistryName
      val hunger = siphon.getMaxHunger
      val thirst = siphon.getMaxThirst
      val speed  = siphon.getMaxSpeed

      val logMessage = "Found Siphon: " + name + ", max hunger " + hunger + ", max thirst, " + thirst +
        ", max speed " + speed + " mph | " + MathUtils.significantMilesToKilometers(speed) + " kph"

      LogUtils.info(logMessage)
    }
  }

  def postInit(e:FMLPostInitializationEvent): Unit = {
    MinecraftForge.EVENT_BUS.register(PlayerHandler)
  }
}
