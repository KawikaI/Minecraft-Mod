package kawika.tutorialmod.world;



import kawika.tutorialmod.TutorialMod;
import kawika.tutorialmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {


    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOURITE_ORE_KEY = registerKey("flourite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLACKWOOD_KEY = registerKey("blackwood");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_FLOURITE_BLOCK_KEY = registerKey("nether_flourite_block");

    public static final RegistryKey<ConfiguredFeature<?, ?>> PINK_GARNET_ORE_KEY = registerKey("pink_garnet_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINK_GARNET_DEEPSLATE_ORE_KEY = registerKey("pink_garnet_deepslate_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> RAW_PINK_GARNET_BLOCK_KEY = registerKey("raw_pink_garnet_block");



    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, BLACKWOOD_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.BLACKWOOD_LOG),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.of(ModBlocks.BLACKWOOD_LEAVES),
                new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(1), ConstantIntProvider.create(5),
                        0.25f, 0.5f, 0.15f, 0.05f),
                new TwoLayersFeatureSize(1, 0, 2)).dirtProvider(BlockStateProvider.of(Blocks.END_STONE)).build());

        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldFluoriteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.FLOURITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.FLOURITE_DEEPSLATE_BLOCK.getDefaultState()));

        List<OreFeatureConfig.Target> overworldPink_GarnetOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.PINK_GARNET_ORE.getDefaultState()),
                        //OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.RAW_PINK_GARNET_BLOCK.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.PINK_GARNET_DEEPSLATE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> rawPinkGarnetTargets = List.of(
                OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.RAW_PINK_GARNET_BLOCK.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.RAW_PINK_GARNET_BLOCK.getDefaultState())
        );

        List<OreFeatureConfig.Target> netherFluoriteOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.FLOURITE_NETHER_BLOCK.getDefaultState()));



        register(context, FLOURITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldFluoriteOres,12));
        register(context, NETHER_FLOURITE_BLOCK_KEY, Feature.ORE, new OreFeatureConfig(netherFluoriteOres,9));

        register(context, PINK_GARNET_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldPink_GarnetOres,12));
        register(context,PINK_GARNET_DEEPSLATE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldPink_GarnetOres,12));

        register(context, RAW_PINK_GARNET_BLOCK_KEY, Feature.ORE, new OreFeatureConfig(rawPinkGarnetTargets,12));





    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(TutorialMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}