
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.windokkstudio.powercraft.init;

import net.windokkstudio.powercraft.PowerCraft;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.windokkstudio.powercraft.blocks.OilBlock;
import net.windokkstudio.powercraft.blocks.OilPumpBlock;
import net.windokkstudio.powercraft.blocks.OilPumpCollisionBlock;

public class PowercraftBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, PowerCraft.MODID);
	public static final RegistryObject<Block> OIL = REGISTRY.register("oil", () -> new OilBlock());
	public static final RegistryObject<Block> OIL_PUMP = REGISTRY.register("oil_pump", () -> new OilPumpBlock());
	public static final RegistryObject<Block> OIL_PUMP_COLLISION = REGISTRY.register("oil_pump_collision", () -> new OilPumpCollisionBlock());
}
