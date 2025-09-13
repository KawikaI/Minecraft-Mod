package kawika.tutorialmod.datagen;



import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import kawika.tutorialmod.block.ModBlocks;
import kawika.tutorialmod.item.ModItems;


import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;



public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // Use the Flourite block texture for related redstone family parts (button/pressure plate)
        BlockStateModelGenerator.BlockTexturePool flouriteTexturePool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLOURITE_BLOCK);

        // Generate block + item models for the button and pressure plate
        flouriteTexturePool.button(ModBlocks.FLOURITE_BUTTON);
        flouriteTexturePool.pressurePlate(ModBlocks.FLOURITE_PRESSURE_PLATE);

        // Cube-all blocks
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOURITE_DEEPSLATE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOURITE_NETHER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FLOURITE, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_FLOURITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLOURITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLOURITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLOURITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLOURITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLOURITE_HOE, Models.HANDHELD);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FLOURITE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FLOURITE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FLOURITE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FLOURITE_BOOTS);

        // 🔽 Add Pink Garnet items (adjust names to YOUR ModItems)
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);


        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PORCUPINE_SPAWN_EGG, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOON_BOW, Models.HANDHELD);

        itemModelGenerator.register(ModItems.PINK_GARNET_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_HOE, Models.HANDHELD);

    }
}