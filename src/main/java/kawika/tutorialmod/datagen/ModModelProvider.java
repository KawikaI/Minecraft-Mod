package kawika.tutorialmod.datagen;



import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import kawika.tutorialmod.block.ModBlocks;
import kawika.tutorialmod.item.ModItems;


import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.item.ArmorItem;


public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool fluoriteTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLOURITE_BLOCK);
        //var flouritePool = gen.registerCubeAllModelTexturePool(ModBlocks.FLOURITE_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOURITE_DEEPSLATE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOURITE_NETHER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOURITE_ORE);

        blockStateModelGenerator.registerLog(ModBlocks.BLACKWOOD_LOG).log(ModBlocks.BLACKWOOD_LOG).wood(ModBlocks.BLACKWOOD_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_BLACKWOOD_LOG).log(ModBlocks.STRIPPED_BLACKWOOD_LOG).wood(ModBlocks.STRIPPED_BLACKWOOD_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLACKWOOD_PLANKS);
        blockStateModelGenerator.registerSingleton(ModBlocks.BLACKWOOD_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.BLACKWOOD_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);



        fluoriteTexturePool.button(ModBlocks.FLOURITE_BUTTON);
        fluoriteTexturePool.pressurePlate(ModBlocks.FLOURITE_PRESSURE_PLATE);








    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FLOURITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_FLOURITE, Models.GENERATED);


        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);

        itemModelGenerator.register(ModItems.PORCUPINE_SPAWN_EGG, Models.GENERATED);

        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOON_BOW, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);

        itemModelGenerator.register(ModItems.PINK_GARNET_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_AXE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.FLOURITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLOURITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLOURITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLOURITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLOURITE_HOE, Models.HANDHELD);



        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FLOURITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FLOURITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FLOURITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FLOURITE_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_BOOTS));




        itemModelGenerator.register(ModItems.KAWIKA_SMITHING_TEMPLATE, Models.GENERATED);
    }


}