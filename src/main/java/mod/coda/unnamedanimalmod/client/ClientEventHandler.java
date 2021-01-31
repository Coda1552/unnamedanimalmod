package mod.coda.unnamedanimalmod.client;

import mod.coda.unnamedanimalmod.UnnamedAnimalMod;
import mod.coda.unnamedanimalmod.client.renderer.*;
import mod.coda.unnamedanimalmod.init.UAMEntities;
import mod.coda.unnamedanimalmod.item.UAMSpawnEggItem;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UnnamedAnimalMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventHandler {

    @OnlyIn(Dist.CLIENT)
    public static void init() {
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.HONDURAN_WHITE_BAT.get(), HonduranWhiteBatRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.VINE_SNAKE.get(), VineSnakeRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.BLACK_DIAMOND_STINGRAY.get(), BlackDiamondStingrayRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.TOMATO_FROG.get(), TomatoFrogRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UAMEntities.SOUTHERN_RIGHT_WHALE.get(), SouthernRightWhaleRenderer::new);
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void itemColors(ColorHandlerEvent.Item event) {
        ItemColors handler = event.getItemColors();
        IItemColor eggColor = (stack, tintIndex) -> ((UAMSpawnEggItem) stack.getItem()).getColor(tintIndex);
        for (UAMSpawnEggItem e : UAMSpawnEggItem.UNADDED_EGGS) handler.register(eggColor, e);
    }
}
