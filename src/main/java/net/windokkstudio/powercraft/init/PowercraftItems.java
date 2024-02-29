
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.windokkstudio.powercraft.init;


import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.windokkstudio.powercraft.PowerCraft;
import net.windokkstudio.powercraft.items.OilItem;
import net.windokkstudio.powercraft.items.OilPumpItem;

public class PowercraftItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, PowerCraft.MODID);

	public static final RegistryObject<Item> OIL_BUCKET = REGISTRY.register("oil_bucket", () -> new OilItem());

	public static final RegistryObject<Item> OIL_PUMP_ITEM = REGISTRY.register("oil_pump", () -> new OilPumpItem(PowercraftBlocks.OIL_PUMP.get(), new Item.Properties()));

	public static final RegistryObject<Item> OIL_PUMP_COLLISION_ITEM = block(PowercraftBlocks.OIL_PUMP_COLLISION);

	public static final RegistryObject<Item> SILVER_ORE = block(PowercraftBlocks.SILVER_ORE);
	public static final RegistryObject<Item> DEEPSLATE_SILVER_ORE = block(PowercraftBlocks.DEEPSLATE_SILVER_ORE);
	public static final RegistryObject<Item> LITHIUM_ORE = block(PowercraftBlocks.LITHIUM_ORE);

	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
