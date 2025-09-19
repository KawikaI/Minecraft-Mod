package kawika.tutorialmod.world.gen;



import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import kawika.tutorialmod.world.ModPlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(
                BiomeSelectors.all(), // <- target every biome
                GenerationStep.Feature.VEGETAL_DECORATION,
                ModPlacedFeatures.BLACKWOOD_PLACED_KEY
        );
    }
}
