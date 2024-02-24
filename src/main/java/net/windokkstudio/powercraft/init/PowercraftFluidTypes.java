
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.windokkstudio.powercraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import net.windokkstudio.powercraft.PowerCraft;
import net.windokkstudio.powercraft.fluids.types.OilFluidType;

public class PowercraftFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, PowerCraft.MODID);
	public static final RegistryObject<FluidType> OIL_TYPE = REGISTRY.register("oil", () -> new OilFluidType());
}
