package teamdraco.unnamedanimalmod.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import teamdraco.unnamedanimalmod.UAMModelLayers;
import teamdraco.unnamedanimalmod.UnnamedAnimalMod;
import teamdraco.unnamedanimalmod.client.model.GreaterPrairieChickenModel;
import teamdraco.unnamedanimalmod.common.entity.GreaterPrairieChickenEntity;
import net.minecraft.client.renderer.entity.MobRenderer;

public class GreaterPrairieChickenRenderer extends MobRenderer<GreaterPrairieChickenEntity, GreaterPrairieChickenModel<GreaterPrairieChickenEntity>> {
    private static final ResourceLocation ADULT = new ResourceLocation(UnnamedAnimalMod.MOD_ID, "textures/entity/greater_prairie_chicken/adult.png");
    private static final ResourceLocation CHILD = new ResourceLocation(UnnamedAnimalMod.MOD_ID, "textures/entity/greater_prairie_chicken/child.png");

    public GreaterPrairieChickenRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new GreaterPrairieChickenModel<>(renderManagerIn.bakeLayer(UAMModelLayers.GREATER_PRAIRIE_CHICKEN)), 0.45F);
    }

    public ResourceLocation getTextureLocation(GreaterPrairieChickenEntity entity) {
        return entity.isBaby() ? CHILD : ADULT;
    }

    protected float getBob(GreaterPrairieChickenEntity livingBase, float partialTicks) {
        float f = Mth.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
        float f1 = Mth.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
        return (Mth.sin(f) + 1.0F) * f1;
    }
}