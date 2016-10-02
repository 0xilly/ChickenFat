package us.illyohs.chickenfat.common.block.tile

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.{Entity, EntityLiving}
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntity
import net.minecraft.util.{EnumFacing, ITickable}

import us.illyohs.chickenfat.api.ChickenFatApi


class TileEquipment
  extends TileEntity
    with ITickable {

  private var attachedEntity:EntityLiving = null
  val facing:EnumFacing                   = EnumFacing.NORTH
  private var working: Boolean = false

  override def update(): Unit = {

  }

  def canEntityBeAttached(entity:Entity): Boolean = {
    val entReg = ChickenFatApi.SIPHONABEL.getValues

    if(!entReg.isInstanceOf[EntityPlayer]) {
      for (i <- 0 until entReg.size) {
        val ent = entReg.get(i).getEntity
        if (entity.getClass == ent) {
          true
        }
      }
      false
    } else {
      true
    }
  }


  override def writeToNBT(tag:NBTTagCompound): NBTTagCompound = {
    super.writeToNBT(tag)

    tag
  }

  override def readFromNBT(tag:NBTTagCompound): Unit = {
    super.readFromNBT(tag)
  }

  def addNewTagsToEntity(entity:Entity): Unit = {
//    entity
  }

  def attachEntity(entity:EntityLiving): Unit = {
    if (canEntityBeAttached(entity)) {
      this.attachedEntity = entity
    }
  }

  def getAttachedEntity: EntityLiving = this.attachedEntity

  def getEntityId: Int = getAttachedEntity.getEntityId

  def setWorking(work:Boolean): Unit = this.working = work

  def isWorking: Boolean = this.working
}
