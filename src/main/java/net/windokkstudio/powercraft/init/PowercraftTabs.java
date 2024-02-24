
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.windokkstudio.powercraft.init;


import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.windokkstudio.powercraft.PowerCraft;

public class PowercraftTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PowerCraft.MODID);
	/*public static final RegistryObject<CreativeModeTab> REGIMES = REGISTRY.register("regimes",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.regimes.regimes")).icon(() -> new ItemStack(RegimesItems.US_FLAG_TEST.get())).displayItems((parameters, tabData) -> {


			})

					.build());*/
}
