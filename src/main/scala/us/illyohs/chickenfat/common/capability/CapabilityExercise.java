package us.illyohs.chickenfat.common.capability;

import java.util.concurrent.Callable;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilityExercise
{
    @CapabilityInject(IExercise.class)
    public static Capability<IExercise> EXERCISE = null;

    public static void register()
    {
        CapabilityManager.INSTANCE.register(IExercise.class, new IStorage<IExercise>()
                {
                    @Override
                    public NBTBase writeNBT(Capability<IExercise> capability, IExercise instance, EnumFacing side)
                    {
                        NBTTagCompound tag = new NBTTagCompound();
                        tag.setInteger("maxhunger", instance.getMaxStamina());
                        return (NBTBase) tag;
                    }

                    @Override
                    public void readNBT(Capability<IExercise> capability, IExercise instance, EnumFacing side, NBTBase nbt)
                    {

                    }
                },
                new Callable<IExercise>()
                {
                    @Override
                    public IExercise call() throws Exception
                    {
                        return null;
                    }
                });
    }

}
