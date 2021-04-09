package mod.coda.unnamedanimalmod.init;

import mod.coda.unnamedanimalmod.UnnamedAnimalMod;
import mod.coda.unnamedanimalmod.item.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FishBucketItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class UAMItems {
    
    public static Item.Properties DEFAULT_PROPERTIES() {
        return new Item.Properties().group(UnnamedAnimalMod.GROUP);
    }

    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, UnnamedAnimalMod.MOD_ID);
    
    public static final RegistryObject<Item> BLUBBER = REGISTRY.register("blubber", () -> new BlubberItem(DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> SALT = REGISTRY.register("salt", () -> new Item(DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MUD_BALL = REGISTRY.register("mud_ball", () -> new MudBallItem(DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MUD_BRICK = REGISTRY.register("mud_brick", () -> new Item(DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> DRIED_MUD_FRAGMENT = REGISTRY.register("dried_mud_fragment", () -> new Item(DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> DRIED_MUD_BRICK = REGISTRY.register("dried_mud_brick", () -> new Item(DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> FRIED_PRAIRIE_CHICKEN_EGG = REGISTRY.register("fried_prairie_chicken_egg", () -> new Item(new Item.Properties().group(UnnamedAnimalMod.GROUP).maxStackSize(64).food(new Food.Builder().saturation(0.6f).hunger(6).build())));
    public static final RegistryObject<Item> ELEPHANTNOSE_FISH = REGISTRY.register("elephantnose_fish", () -> new Item(new Item.Properties().group(UnnamedAnimalMod.GROUP).food(new Food.Builder().saturation(0.2f).hunger(1).build())));
    public static final RegistryObject<Item> FLASHLIGHT_FISH = REGISTRY.register("flashlight_fish", () -> new Item(new Item.Properties().group(UnnamedAnimalMod.GROUP).food(new Food.Builder().saturation(0.2f).hunger(1).effect(() -> new EffectInstance(Effects.GLOWING, 100, 1), 1F).build())));
    public static final RegistryObject<Item> ROCKET_KILLIFISH = REGISTRY.register("rocket_killifish", () -> new Item(new Item.Properties().group(UnnamedAnimalMod.GROUP).food(new Food.Builder().saturation(0.2f).hunger(1).build())));
    public static final RegistryObject<Item> MUSK_OX_SHANK = REGISTRY.register("musk_ox_shank", () -> new Item(new Item.Properties().group(UnnamedAnimalMod.GROUP).food(new Food.Builder().hunger(4).saturation(0.2f).effect(() -> new EffectInstance(Effects.SLOWNESS, 100, 0), 0.75f).meat().build())));
    public static final RegistryObject<Item> COOKED_MUSK_OX_SHANK = REGISTRY.register("cooked_musk_ox_shank", () -> new Item(new Item.Properties().group(UnnamedAnimalMod.GROUP).food(new Food.Builder().hunger(10).saturation(0.6f).effect(() -> new EffectInstance(Effects.SLOWNESS, 100, 0), 0.25f).meat().build())));
    public static final RegistryObject<Item> FROG_LEGS = REGISTRY.register("frog_legs", () -> new Item(new Item.Properties().group(UnnamedAnimalMod.GROUP).food(new Food.Builder().hunger(2).saturation(0.2f).meat().build())));
    public static final RegistryObject<Item> COOKED_FROG_LEGS = REGISTRY.register("cooked_frog_legs", () -> new Item(new Item.Properties().group(UnnamedAnimalMod.GROUP).food(new Food.Builder().hunger(5).saturation(0.3f).meat().build())));
    public static final RegistryObject<Item> MANGROVE_FRUIT = REGISTRY.register("mangrove_fruit", () -> new Item(new Item.Properties().group(UnnamedAnimalMod.GROUP).food(new Food.Builder().hunger(1).saturation(0.1f).effect(() -> new EffectInstance(Effects.HUNGER, 100, 0), 1f).build())));

    public static final RegistryObject<Item> TOMATO_FROG_EGG = REGISTRY.register("tomato_frog_egg", () -> new TomatoFrogEggItem(new Item.Properties().group(UnnamedAnimalMod.GROUP).maxStackSize(16)));
    public static final RegistryObject<Item> PACMAN_FROG_EGG = REGISTRY.register("pacman_frog_egg", () -> new PacmanFrogEggItem(new Item.Properties().group(UnnamedAnimalMod.GROUP).maxStackSize(16)));
    public static final RegistryObject<Item> GREATER_PRAIRIE_CHICKEN_EGG = REGISTRY.register("greater_prairie_chicken_egg", () -> new GreaterPrairieChickenEggItem(new Item.Properties().group(UnnamedAnimalMod.GROUP).maxStackSize(16)));
    public static final RegistryObject<Item> PLATYPUS_EGG = REGISTRY.register("platypus_egg", () -> new PlatypusEggItem(new Item.Properties().group(UnnamedAnimalMod.GROUP).maxStackSize(16)));
    public static final RegistryObject<Item> MARINE_IGUANA_EGG = REGISTRY.register("marine_iguana_egg", () -> new MarineIguanaEggItem(new Item.Properties().group(UnnamedAnimalMod.GROUP).maxStackSize(16)));
    public static final RegistryObject<Item> FLASHLIGHT_FISH_BUCKET = REGISTRY.register("flashlight_fish_bucket", () -> new FishBucketItem(UAMEntities.FLASHLIGHT_FISH, () -> Fluids.WATER, new Item.Properties().group(UnnamedAnimalMod.GROUP).maxStackSize(1)));
    public static final RegistryObject<Item> PLATYPUS_BUCKET = REGISTRY.register("platypus_bucket", () -> new UAMBucketItem(UAMEntities.PLATYPUS::get, new Item.Properties().maxStackSize(1).group(UnnamedAnimalMod.GROUP)));
    public static final RegistryObject<Item> ELEPHANTNOSE_FISH_BUCKET = REGISTRY.register("elephantnose_fish_bucket", () -> new FishBucketItem(UAMEntities.ELEPHANTNOSE_FISH, () -> Fluids.WATER, new Item.Properties().group(UnnamedAnimalMod.GROUP).maxStackSize(1)));
    public static final RegistryObject<Item> BLACK_DIAMOND_STINGRAY_BUCKET = REGISTRY.register("black_diamond_stingray_bucket", () -> new FishBucketItem(UAMEntities.BLACK_DIAMOND_STINGRAY, () -> Fluids.WATER, new Item.Properties().group(UnnamedAnimalMod.GROUP).maxStackSize(1)));
    public static final RegistryObject<Item> BANANA_SLUG_POT = REGISTRY.register("banana_slug_pot", () -> new UAMPotItem(UAMEntities.BANANA_SLUG::get, new Item.Properties().maxStackSize(1).group(UnnamedAnimalMod.GROUP)));
    public static final RegistryObject<Item> TOMATO_FROG_BOWL = REGISTRY.register("tomato_frog_bowl", () -> new UAMBowltem(UAMEntities.TOMATO_FROG::get, new Item.Properties().maxStackSize(1).group(UnnamedAnimalMod.GROUP)));
    public static final RegistryObject<Item> PACMAN_FROG_BOWL = REGISTRY.register("pacman_frog_bowl", () -> new UAMBowltem(UAMEntities.PACMAN_FROG::get, new Item.Properties().maxStackSize(1).group(UnnamedAnimalMod.GROUP)));
    public static final RegistryObject<Item> ROCKET_KILLIFISH_BUCKET = REGISTRY.register("rocket_killifish_bucket", () -> new FishBucketItem(UAMEntities.ROCKET_KILLIFISH, () -> Fluids.WATER, new Item.Properties().group(UnnamedAnimalMod.GROUP).maxStackSize(1)));

    public static final RegistryObject<Item> BLACK_DIAMOND_STINGRAY_SPAWN_EGG = REGISTRY.register("black_diamond_stingray_spawn_egg", () -> new UAMSpawnEggItem(UAMEntities.BLACK_DIAMOND_STINGRAY, 0x35374e, 0xf2f3fe, DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> TOMATO_FROG_SPAWN_EGG = REGISTRY.register("tomato_frog_spawn_egg", () -> new UAMSpawnEggItem(UAMEntities.TOMATO_FROG, 0x961900, 0xf1800a, DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> SOUTHERN_RIGHT_WHALE_SPAWN_EGG = REGISTRY.register("southern_right_whale_spawn_egg", () -> new UAMSpawnEggItem(UAMEntities.SOUTHERN_RIGHT_WHALE, 0x263334, 0xcdcabc, DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> GREATER_PRAIRIE_CHICKEN_SPAWN_EGG = REGISTRY.register("greater_prairie_chicken_spawn_egg", () -> new UAMSpawnEggItem(UAMEntities.GREATER_PRAIRIE_CHICKEN, 0x4e4340, 0xeda825, DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> FLASHLIGHT_FISH_SPAWN_EGG = REGISTRY.register("flashlight_fish_spawn_egg", () -> new UAMSpawnEggItem(UAMEntities.FLASHLIGHT_FISH, 0x1a0d11, 0xf7ffff, DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> HUMPHEAD_PARROTFISH_SPAWN_EGG = REGISTRY.register("humphead_parrotfish_spawn_egg", () -> new UAMSpawnEggItem(UAMEntities.HUMPHEAD_PARROTFISH, 0x447e62, 0xd29cac, DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MUSK_OX_SPAWN_EGG = REGISTRY.register("musk_ox_spawn_egg", () -> new UAMSpawnEggItem(UAMEntities.MUSK_OX, 0x402b27, 0x1e1413, DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> BANANA_SLUG_SPAWN_EGG = REGISTRY.register("banana_slug_spawn_egg", () -> new UAMSpawnEggItem(UAMEntities.BANANA_SLUG, 0xe2ba4c, 0xa78330, DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MARINE_IGUANA_SPAWN_EGG = REGISTRY.register("marine_iguana_spawn_egg", () -> new UAMSpawnEggItem(UAMEntities.MARINE_IGUANA, 0x27272d, 0x78f7d4, DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> PLATYPUS_SPAWN_EGG = REGISTRY.register("platypus_spawn_egg", () -> new UAMSpawnEggItem(UAMEntities.PLATYPUS, 0x71492a, 0x544b38, DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> PACMAN_FROG_SPAWN_EGG = REGISTRY.register("pacman_frog_spawn_egg", () -> new UAMSpawnEggItem(UAMEntities.PACMAN_FROG, 0x9a9c26, 0x3d1a0c, DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> ELEPHANTNOSE_FISH_SPAWN_EGG = REGISTRY.register("elephantnose_fish_spawn_egg", () -> new UAMSpawnEggItem(UAMEntities.ELEPHANTNOSE_FISH, 0x4c3b36, 0xc9c1b9, DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> CAPYBARA_SPAWN_EGG = REGISTRY.register("capybara_spawn_egg", () -> new UAMSpawnEggItem(UAMEntities.CAPYBARA, 0x9e5d39, 0x412f24, DEFAULT_PROPERTIES()));

    public static final RegistryObject<Item> SALT_BLOCK = REGISTRY.register("salt_block", () -> new BlockItem(UAMBlocks.SALT_BLOCK.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MANGROVE_SAPLING = REGISTRY.register("mangrove_sapling", () -> new BlockItem(UAMBlocks.MANGROVE_SAPLING.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MANGROVE_LOG = REGISTRY.register("mangrove_log", () -> new BlockItem(UAMBlocks.MANGROVE_LOG.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MANGROVE_WOOD = REGISTRY.register("mangrove_wood", () -> new BlockItem(UAMBlocks.MANGROVE_WOOD.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> STRIPPED_MANGROVE_LOG = REGISTRY.register("stripped_mangrove_log", () -> new BlockItem(UAMBlocks.STRIPPED_MANGROVE_LOG.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> STRIPPED_MANGROVE_WOOD = REGISTRY.register("stripped_mangrove_wood", () -> new BlockItem(UAMBlocks.STRIPPED_MANGROVE_WOOD.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MANGROVE_PLANKS = REGISTRY.register("mangrove_planks", () -> new BlockItem(UAMBlocks.MANGROVE_PLANKS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MANGROVE_SLAB = REGISTRY.register("mangrove_slab", () -> new BlockItem(UAMBlocks.MANGROVE_SLAB.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MANGROVE_STAIRS = REGISTRY.register("mangrove_stairs", () -> new BlockItem(UAMBlocks.MANGROVE_STAIRS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MANGROVE_DOOR = REGISTRY.register("mangrove_door", () -> new BlockItem(UAMBlocks.MANGROVE_DOOR.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MANGROVE_TRAPDOOR = REGISTRY.register("mangrove_trapdoor", () -> new BlockItem(UAMBlocks.MANGROVE_TRAPDOOR.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MANGROVE_BUTTON = REGISTRY.register("mangrove_button", () -> new BlockItem(UAMBlocks.MANGROVE_BUTTON.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MANGROVE_PRESSURE_PLATE = REGISTRY.register("mangrove_pressure_plate", () -> new BlockItem(UAMBlocks.MANGROVE_PRESSURE_PLATE.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MANGROVE_FENCE = REGISTRY.register("mangrove_fence", () -> new BlockItem(UAMBlocks.MANGROVE_FENCE.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MANGROVE_FENCE_GATE = REGISTRY.register("mangrove_fence_gate", () -> new BlockItem(UAMBlocks.MANGROVE_FENCE_GATE.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MANGROVE_LEAVES = REGISTRY.register("mangrove_leaves", () -> new BlockItem(UAMBlocks.MANGROVE_LEAVES.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> FLOWERING_MANGROVE_LEAVES = REGISTRY.register("flowering_mangrove_leaves", () -> new BlockItem(UAMBlocks.FLOWERING_MANGROVE_LEAVES.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MUD_BLOCK = REGISTRY.register("mud_block", () -> new BlockItem(UAMBlocks.MUD_BLOCK.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MUD_BRICKS = REGISTRY.register("mud_bricks", () -> new BlockItem(UAMBlocks.MUD_BRICKS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> CHISELED_MUD_BRICKS = REGISTRY.register("chiseled_mud_bricks", () -> new BlockItem(UAMBlocks.CHISELED_MUD_BRICKS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MUD_BRICKS_SLAB = REGISTRY.register("mud_brick_slab", () -> new BlockItem(UAMBlocks.MUD_BRICK_SLAB.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> MUD_BRICKS_STAIRS = REGISTRY.register("mud_brick_stairs", () -> new BlockItem(UAMBlocks.MUD_BRICK_STAIRS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> DRIED_MUD_BLOCK = REGISTRY.register("dried_mud_block", () -> new BlockItem(UAMBlocks.DRIED_MUD_BLOCK.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> DRIED_MUD_BRICKS = REGISTRY.register("dried_mud_bricks", () -> new BlockItem(UAMBlocks.DRIED_MUD_BRICKS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> CHISELED_DRIED_MUD_BRICKS = REGISTRY.register("chiseled_dried_mud_bricks", () -> new BlockItem(UAMBlocks.CHISELED_DRIED_MUD_BRICKS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> DRIED_MUD_BRICKS_SLAB = REGISTRY.register("dried_mud_brick_slab", () -> new BlockItem(UAMBlocks.DRIED_MUD_BRICK_SLAB.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> DRIED_MUD_BRICKS_STAIRS = REGISTRY.register("dried_mud_brick_stairs", () -> new BlockItem(UAMBlocks.DRIED_MUD_BRICK_STAIRS.get(), DEFAULT_PROPERTIES()));
    public static final RegistryObject<Item> RICH_FARMLAND = REGISTRY.register("rich_farmland", () -> new BlockItem(UAMBlocks.RICH_FARMLAND.get(), DEFAULT_PROPERTIES()));
}