package kawika.tutorialmod;



import kawika.tutorialmod.block.ModBlocks;
import kawika.tutorialmod.entity.ModEntities;
import kawika.tutorialmod.entity.custom.PorcupineEntity;
import kawika.tutorialmod.item.ModItemGroups;
import kawika.tutorialmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TutorialMod implements ModInitializer {


	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(ModEntities.PORCUPINE, PorcupineEntity.createPorcupineAttributes());
		ModEntities.registerModEntities();
		// calling register calls
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);
	}
}