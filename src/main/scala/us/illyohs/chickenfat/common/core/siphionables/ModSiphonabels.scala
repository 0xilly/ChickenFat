package us.illyohs.chickenfat.common.core.siphionables

import net.minecraft.entity.EntityCreature
import net.minecraft.entity.passive._

import net.minecraftforge.fml.common.registry.GameRegistry

import us.illyohs.chickenfat.api.render.IAdditionalRender
import us.illyohs.chickenfat.api.siphon.Siphonable
import us.illyohs.chickenfat.common.core.util.ModInfo._

object ModSiphonabels {

  /**
    * A super class for a siphon so I can create a case object instead of making individual classes
    * @param name
    * @param maxHunger
    * @param maxThirst
    * @param maxStamina
    * @param maxSpeed
    * @param creature
    */
  protected class SiphonSuper(name: String, maxHunger:Float, maxThirst:Float, maxStamina:Int, maxSpeed:Int,
                              creature: Class[_ <: EntityCreature], overrider :IAdditionalRender)
    extends Siphonable(maxHunger, maxThirst, maxStamina, maxSpeed, creature, overrider) {

    /*THIS IS A HORRIBLE SHORTCUT THAT SHOULD NEVER BE USED OUTSIDE THIS CODE BASE*/
    setRegistryName(ID, name)
  }

  //Passive
  case object SHEEP    extends SiphonSuper("sheep",    10, 10,  5, 10, classOf[EntitySheep],    null)
  case object COW      extends SiphonSuper("cow",      15, 20,  5, 25, classOf[EntityCow],      null)
  case object WOLF     extends SiphonSuper("wolf",     15, 20,  7, 37, classOf[EntityWolf],     null)
  case object HORSE    extends SiphonSuper("horse",    15, 20, 25, 30, classOf[EntityHorse],    null)
  case object PIG      extends SiphonSuper("pig",      20, 20,  7, 11, classOf[EntityPig],      null)
  case object CHICKEN  extends SiphonSuper("chicken",   5,  5,  6,  9, classOf[EntityChicken],  null)
  case object OCELOT   extends SiphonSuper("ozelot",   13, 12, 10, 38, classOf[EntityOcelot],   null)
  case object RABBIT   extends SiphonSuper("rabbit",   10, 10,  6, 35, classOf[EntityRabbit],   null)
  case object VILLAGER extends SiphonSuper("villager", 15, 20, 15, 27, classOf[EntityVillager], null)

  //Monsters


  private def regSiphons(siphons:Siphonable): Unit = GameRegistry.register(siphons)

  def init: Unit = {
    regSiphons(SHEEP)
    regSiphons(COW)
    regSiphons(WOLF)
    regSiphons(HORSE)
    regSiphons(PIG)
    regSiphons(CHICKEN)
    regSiphons(OCELOT)
    regSiphons(RABBIT)
    regSiphons(VILLAGER)
  }



}


