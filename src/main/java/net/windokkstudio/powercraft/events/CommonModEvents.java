package net.windokkstudio.powercraft.events;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.windokkstudio.powercraft.PowerCraft;
import net.windokkstudio.powercraft.network.PacketHandler;

@Mod.EventBusSubscriber(modid = PowerCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {


    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            PacketHandler.register();
        });
    }
}