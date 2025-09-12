package kawika.tutorialmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import kawika.tutorialmod.datagen.ModBlockTagProvider;
import kawika.tutorialmod.datagen.ModItemTagProvider;
import kawika.tutorialmod.datagen.ModLootTableGenerator;
import kawika.tutorialmod.datagen.ModModelProvider;
import kawika.tutorialmod.datagen.ModRecipeGenerator;

public class TutorialModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator gen) {
		System.out.println(">>> datagen: onInitializeDataGenerator");
		var pack = gen.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableGenerator::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeGenerator::new);
	}
}