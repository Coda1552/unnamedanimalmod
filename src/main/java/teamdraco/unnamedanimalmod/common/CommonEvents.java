package teamdraco.unnamedanimalmod.common;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teamdraco.unnamedanimalmod.common.block.RichFarmlandBlock;
import teamdraco.unnamedanimalmod.common.entity.MuskOxEntity;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class CommonEvents {

    // todo - biome modifiers
/*    @SubscribeEvent
    public static void doSpawning(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.Category.JUNGLE) {
            event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(UAMEntities.BLACK_DIAMOND_STINGRAY.get(), UAMConfig.Common.INSTANCE.blackDiamondStingraySpawnWeight.get(), 1, 1));
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(UAMEntities.TOMATO_FROG.get(), UAMConfig.Common.INSTANCE.tomatoFrogSpawnWeight.get(), 1, 2));
            event.getSpawns().getSpawner(EntityClassification.WATER_AMBIENT).add(new MobSpawnInfo.Spawners(UAMEntities.ELEPHANTNOSE_FISH.get(), UAMConfig.Common.INSTANCE.elephantnoseFishSpawnWeight.get(), 1, 5));
        }

        if (Biomes.SUNFLOWER_PLAINS.location().equals(event.getName())) {
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(UAMEntities.GREATER_PRAIRIE_CHICKEN.get(), UAMConfig.Common.INSTANCE.greaterPrairieChickenSpawnWeight.get(), 4, 4));
        }

        if (event.getCategory() == Biome.Category.ICY) {
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(UAMEntities.MUSK_OX.get(), UAMConfig.Common.INSTANCE.muskOxSpawnWeight.get(), 2, 4));
        }

        if (Biomes.COLD_OCEAN.location().equals(event.getName())) {
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(UAMEntities.SOUTHERN_RIGHT_WHALE.get(), UAMConfig.Common.INSTANCE.southernRightWhaleSpawnWeight.get(), 1, 3));
        }

        if (Biomes.WARM_OCEAN.location().equals(event.getName())) {
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(UAMEntities.HUMPHEAD_PARROTFISH.get(), UAMConfig.Common.INSTANCE.humpheadParrotfishSpawnWeight.get(), 1, 3));
            event.getSpawns().getSpawner(EntityClassification.WATER_AMBIENT).add(new MobSpawnInfo.Spawners(UAMEntities.FLASHLIGHT_FISH.get(), UAMConfig.Common.INSTANCE.flashlightFishSpawnWeight.get(), 4, 8));
        }

        if (Biomes.LUKEWARM_OCEAN.location().equals(event.getName()) || Biomes.DEEP_LUKEWARM_OCEAN.location().equals(event.getName())) {
            event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(UAMEntities.LEAFY_SEADRAGON.get(), UAMConfig.Common.INSTANCE.leafySeadragonSpawnWeight.get(), 1, 3));
            event.getSpawns().getSpawner(EntityClassification.WATER_CREATURE).add(new MobSpawnInfo.Spawners(UAMEntities.SPOTTED_GARDEN_EEL.get(), UAMConfig.Common.INSTANCE.spottedGardenEelSpawnWeight.get(), 3, 6));
        }

        if (Biomes.STONE_SHORE.location().equals(event.getName())) {
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(UAMEntities.MARINE_IGUANA.get(), UAMConfig.Common.INSTANCE.marineIguanaSpawnWeight.get(), 4, 6));
        }

        if (Biomes.GIANT_TREE_TAIGA.location().equals(event.getName()) || Biomes.GIANT_TREE_TAIGA_HILLS.location().equals(event.getName()) || Biomes.GIANT_SPRUCE_TAIGA_HILLS.location().equals(event.getName()) || Biomes.GIANT_SPRUCE_TAIGA.location().equals(event.getName())) {
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(UAMEntities.BANANA_SLUG.get(), UAMConfig.Common.INSTANCE.bananaSlugSpawnWeight.get(), 1, 1));
        }

        if (event.getCategory() == Biome.Category.SWAMP) {
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(UAMEntities.PLATYPUS.get(), UAMConfig.Common.INSTANCE.platypusSpawnWeight.get(), 1, 1));
            event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(UAMEntities.PACMAN_FROG.get(), UAMConfig.Common.INSTANCE.pacmanFrogSpawnWeight.get(), 1, 2));
        }
    }*/

    @SubscribeEvent
    public static void harvest(BlockEvent.BreakEvent event) {
        if (event.getLevel() instanceof ServerLevel level) {
            BlockState cropState = event.getState();
            if (cropState.getBlock() instanceof CropBlock cropBlock) {
                if (cropBlock.isMaxAge(cropState)) {
                    BlockState farmlandState = level.getBlockState(event.getPos().below());
                    if (farmlandState.getBlock() instanceof RichFarmlandBlock) {
                        List<ItemStack> drops = Block.getDrops(cropState, level, event.getPos(), null);
                        List<ItemStack> uniqueDrops = new ArrayList<>();
                        List<Item> addedItems = new ArrayList<>();
                        drops.forEach(s -> {
                            if (!addedItems.contains(s.getItem())) {
                                addedItems.add(s.getItem());
                                uniqueDrops.add(s);
                            }
                        });
                        if (uniqueDrops.size() > 1) {
                            uniqueDrops.forEach(s -> {
                                if (!(s.getItem() instanceof BlockItem && ((BlockItem) s.getItem()).getBlock() instanceof CropBlock)) {
                                    ItemEntity entity = new ItemEntity(level, event.getPos().getX() + 0.5f, event.getPos().getY() + 0.5f, event.getPos().getZ() + 0.5f, s);
                                    level.addFreshEntity(entity);
                                }
                            });
                        }
                        else {
                            ItemEntity entity = new ItemEntity(level, event.getPos().getX() + 0.5f, event.getPos().getY() + 0.5f, event.getPos().getZ() + 0.5f, uniqueDrops.get(0));
                            level.addFreshEntity(entity);
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEntityJoinWorld(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Wolf wolf) {
            wolf.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>((Wolf) entity, MuskOxEntity.class, true));
        }
    }
}
