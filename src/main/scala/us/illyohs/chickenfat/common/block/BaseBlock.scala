package us.illyohs.chickenfat.common.block

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs

import us.illyohs.chickenfat.common.core.util.ModInfo

class BaseBlock(name:String, material:Material)
  extends Block(material) {
  setRegistryName(name)
  setUnlocalizedName(ModInfo.ID + ":" + name)
  setCreativeTab(CreativeTabs.BREWING)
}
