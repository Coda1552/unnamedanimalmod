package teamdraco.unnamedanimalmod.common.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import teamdraco.unnamedanimalmod.init.UAMItems;

public class FlashlightFishEntity extends AbstractSchoolingFish {
    public FlashlightFishEntity(EntityType<? extends FlashlightFishEntity> p_i50279_1_, Level p_i50279_2_) {
        super(p_i50279_1_, p_i50279_2_);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 8.0F, 1.6D, 1.4D, EntitySelector.NO_SPECTATORS::test));
        this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 1.0D, 1));
    }

    public ItemStack getBucketItemStack() {
        return new ItemStack(UAMItems.FLASHLIGHT_FISH_BUCKET.get());
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.COD_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.COD_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.COD_HURT;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }

    @Override
    public int getMaxSchoolSize() {
        return 8;
    }

}
