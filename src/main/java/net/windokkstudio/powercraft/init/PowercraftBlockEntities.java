
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.windokkstudio.powercraft.init;

import net.windokkstudio.powercraft.PowerCraft;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.windokkstudio.powercraft.blocks.entity.OilPumpCollisionBlockEntity;

public class PowercraftBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PowerCraft.MODID);
	public static final RegistryObject<BlockEntityType<?>> OIL_PUMP_COLLISION_BLOCK_ENTITY = register("oil_pump_collision", PowercraftBlocks.OIL_PUMP_COLLISION, OilPumpCollisionBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
