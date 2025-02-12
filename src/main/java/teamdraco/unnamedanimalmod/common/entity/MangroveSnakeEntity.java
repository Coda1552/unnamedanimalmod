package teamdraco.unnamedanimalmod.common.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import teamdraco.unnamedanimalmod.init.UAMEntities;
import teamdraco.unnamedanimalmod.init.UAMItems;
import teamdraco.unnamedanimalmod.init.UAMSounds;

import javax.annotation.Nullable;

public class MangroveSnakeEntity extends Animal {
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(MangroveSnakeEntity.class, EntityDataSerializers.INT);

    public MangroveSnakeEntity(EntityType<? extends Animal> type, Level worldIn) {
        super(type, worldIn);
        this.moveControl = new MangroveSnakeMoveControl(this);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.maxUpStep = 1;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.5D));
        this.goalSelector.addGoal(1, new BreedGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 2.0D, 1) {
            @Override
            public boolean canUse() {
                return super.canUse() && isInWater();
            }
        });
        this.goalSelector.addGoal(3, new MangroveSnakeEntity.WanderGoal(this, 1.0D, 10));
        this.goalSelector.addGoal(4, new TryFindWaterGoal(this));
    }

    @Override
    public int getAmbientSoundInterval() {
        return 800;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return UAMSounds.MANGROVE_SNAKE_AMBIENT.get();
    }

    protected SoundEvent getDeathSound() {
        return UAMSounds.MANGROVE_SNAKE_DEATH.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return UAMSounds.MANGROVE_SNAKE_HURT.get();
    }

    @Override
    protected float getSoundVolume() {
        return 0.1f;
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor worldIn, DifficultyInstance difficultyIn, MobSpawnType reason, @Nullable SpawnGroupData spawnDataIn, @Nullable CompoundTag dataTag) {
        if (random.nextFloat() > 0.2D) {
            setVariant(0);
        }
        else {
            setVariant(1);
        }
        return spawnDataIn;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_241840_1_, AgeableMob p_241840_2_) {
        return UAMEntities.MANGROVE_SNAKE.get().create(p_241840_1_);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
    }

    @Override
    public boolean isFood(ItemStack p_70877_1_) {
        return p_70877_1_.getItem() == UAMItems.FROG_LEGS.get();
    }

    public int getVariant() {
        return this.entityData.get(VARIANT);
    }

    public void setVariant(int variant) {
        this.entityData.set(VARIANT, variant);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", getVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        setVariant(compound.getInt("Variant"));
    }

    @Override
    public void travel(Vec3 travelVector) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(0.1F, travelVector);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(travelVector);
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10).add(Attributes.MOVEMENT_SPEED, 0.15).add(Attributes.ATTACK_DAMAGE, 1.0);
    }

    public float getWalkTargetValue(BlockPos pos, LevelReader worldIn) {
        if (worldIn.getFluidState(pos).is(FluidTags.WATER)) {
            return 10.0F;
        } else {
            return 1.5F;
        }
    }

    static class MangroveSnakeMoveControl extends MoveControl {
        private final MangroveSnakeEntity snake;

        MangroveSnakeMoveControl(MangroveSnakeEntity snake) {
            super(snake);
            this.snake = snake;
        }

        private void updateSpeed() {
            if (this.snake.isInWater()) {
                this.snake.setDeltaMovement(this.snake.getDeltaMovement().add(0.0D, 0.005D, 0.0D));

                if (this.snake.isBaby()) {
                    this.snake.setSpeed(Math.max(this.snake.getSpeed() / 3.0F, 0.06F));
                }
            } else if (this.snake.onGround) {
                this.snake.setSpeed(Math.max(this.snake.getSpeed(), 0.06F));
            }

        }

        public void tick() {
            this.updateSpeed();
            if (this.operation == Operation.MOVE_TO && !this.snake.getNavigation().isDone()) {
                double d0 = this.wantedX - this.snake.getX();
                double d1 = this.wantedY - this.snake.getY();
                double d2 = this.wantedZ - this.snake.getZ();
                double d3 = Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
                d1 = d1 / d3;
                float f = (float)(Math.atan2(d2, d0) * (double)(180F / (float)Math.PI)) - 90.0F;
                this.snake.yRot = this.rotlerp(this.snake.yRot, f, 90.0F);
                this.snake.yBodyRot = this.snake.yRot;
                float f1 = (float)(this.speedModifier * this.snake.getAttributeValue(Attributes.MOVEMENT_SPEED));
                this.snake.setSpeed(Mth.lerp(0.125F, this.snake.getSpeed(), f1));
                this.snake.setDeltaMovement(this.snake.getDeltaMovement().add(0.0D, (double)this.snake.getSpeed() * d1 * 0.1D, 0.0D));
            } else {
                this.snake.setSpeed(0.0F);
            }
        }
    }

    static class WanderGoal extends RandomStrollGoal {
        private final MangroveSnakeEntity snake;

        private WanderGoal(MangroveSnakeEntity snake, double speedIn, int chance) {
            super(snake, speedIn, chance);
            this.snake = snake;
        }

        public boolean canUse() {
            return !this.mob.isInWater() && super.canUse();
        }
    }
}
