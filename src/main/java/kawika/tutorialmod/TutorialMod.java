package kawika.tutorialmod;



import kawika.tutorialmod.block.ModBlocks;
import kawika.tutorialmod.item.ModItemGroups;
import kawika.tutorialmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.util.Identifier;

public class TutorialMod implements ModInitializer {




	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// your existing stuff...
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);



		//ModWorldGeneration.generateModWorldGeneration();




	}
}