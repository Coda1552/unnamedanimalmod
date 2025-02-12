package teamdraco.unnamedanimalmod.client.renderer;

import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teamdraco.unnamedanimalmod.UAMModelLayers;
import teamdraco.unnamedanimalmod.UnnamedAnimalMod;
import teamdraco.unnamedanimalmod.client.model.MudskipperModel;
import teamdraco.unnamedanimalmod.common.entity.MudskipperEntity;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class MudskipperRenderer extends MobRenderer<MudskipperEntity, MudskipperModel<MudskipperEntity>> {
    public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
        hashMap.put(0, new ResourceLocation(UnnamedAnimalMod.MOD_ID, "textures/entity/mudskipper/mudskipper_1.png"));
        hashMap.put(1, new ResourceLocation(UnnamedAnimalMod.MOD_ID, "textures/entity/mudskipper/mudskipper_2.png"));
        hashMap.put(2, new ResourceLocation(UnnamedAnimalMod.MOD_ID, "textures/entity/mudskipper/mudskipper_3.png"));
        hashMap.put(3, new ResourceLocation(UnnamedAnimalMod.MOD_ID, "textures/entity/mudskipper/mudskipper_4.png"));
        hashMap.put(4, new ResourceLocation(UnnamedAnimalMod.MOD_ID, "textures/entity/mudskipper/mudskipper_5.png"));
    });

    public MudskipperRenderer(EntityRendererProvider.Context manager) {
        super(manager, new MudskipperModel<>(manager.bakeLayer(UAMModelLayers.MUDSKIPPER)), 0.15f);
    }

    @Override
    public ResourceLocation getTextureLocation(MudskipperEntity entity) {
        return TEXTURES.getOrDefault(entity.getVariant(), TEXTURES.get(0));
    }
}
