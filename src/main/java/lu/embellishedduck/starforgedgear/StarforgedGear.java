package lu.embellishedduck.starforgedgear;

import com.mojang.logging.LogUtils;
import lu.embellishedduck.starforgedgear.datagen.DataGeneration;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;


@Mod(StarforgedGear.MOD_ID)
public class StarforgedGear {

    public static final String MOD_ID = "starforged_gear";

    private static final Logger LOGGER = LogUtils.getLogger();

    //Constructor
    public StarforgedGear(IEventBus modEventBus) {

        modEventBus.addListener(this::commonSetup);

        //Register Classes

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(DataGeneration::gatherData);

    }//End of Constructor


    private void commonSetup(final FMLCommonSetupEvent event) {

    }//End of Constructor


    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }//End of Method


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }//End of Method


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }//End of Method
    }//End of Subclass
}//End of Class
