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


    public static final RegistryKey<ConfiguredFeature<?, ?>> FLOURITE_BLOCK_KEY = registerKey("flourite_block");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_FLOURITE_BLOCK_KEY = registerKey("nether_flourite_block");



    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldFluoriteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.FLOURITE_BLOCK.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.FLOURITE_DEEPSLATE_BLOCK.getDefaultState()));

        List<OreFeatureConfig.Target> netherFluoriteOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.FLOURITE_NETHER_BLOCK.getDefaultState()));



        register(context, FLOURITE_BLOCK_KEY, Feature.ORE, new OreFeatureConfig(overworldFluoriteOres,12));
        register(context, NETHER_FLOURITE_BLOCK_KEY, Feature.ORE, new OreFeatureConfig(netherFluoriteOres,9));





    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(TutorialMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}