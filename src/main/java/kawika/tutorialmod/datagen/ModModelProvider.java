package kawika.tutorialmod.datagen;



import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import kawika.tutorialmod.block.ModBlocks;
import kawika.tutorialmod.item.ModItems;


import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;



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
        BlockStateModelGenerator.BlockTexturePool flouriteTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLOURITE_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOURITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLOURITE_DEEPSLATE_BLOCK);





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



        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FLOURITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FLOURITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FLOURITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.FLOURITE_BOOTS));

    }
}