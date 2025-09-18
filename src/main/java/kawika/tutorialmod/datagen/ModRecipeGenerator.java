package kawika.tutorialmod.datagen;

import kawika.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import kawika.tutorialmod.block.ModBlocks;
import kawika.tutorialmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // Only raw items can be smelted/blasted
        List<ItemConvertible> FLUORITE_SMELTABLES = List.of(ModItems.RAW_FLOURITE);
        List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModItems.RAW_PINK_GARNET);

        // Fluorite: smelt & blast raw -> refined
        offerSmelting(exporter, FLUORITE_SMELTABLES, RecipeCategory.MISC,
                ModItems.FLOURITE, 0.7f, 200, "fluorite");
        offerBlasting(exporter, FLUORITE_SMELTABLES, RecipeCategory.MISC,
                ModItems.FLOURITE, 0.7f, 100, "fluorite");

        // Pink Garnet: smelt & blast raw -> refined
        offerSmelting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC,
                ModItems.PINK_GARNET, 0.7f, 200, "pink_garnet");
        offerBlasting(exporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC,
                ModItems.PINK_GARNET, 0.7f, 100, "pink_garnet");

        // Storage ↔ items
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS,
                ModItems.FLOURITE, RecipeCategory.DECORATIONS, ModBlocks.FLOURITE_BLOCK);

        // Your custom crafting recipes
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_FLOURITE)
                .pattern("SFS")
                .pattern("SFS")
                .pattern("SFS")
                .input('S', Blocks.STONE)
                .input('F', ModItems.FLOURITE)
                .criterion(hasItem(Blocks.STONE), conditionsFromItem(Blocks.STONE))
                .criterion(hasItem(ModItems.FLOURITE), conditionsFromItem(ModItems.FLOURITE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET)
                .pattern("SSS")
                .pattern("FFF")
                .pattern("SSS")
                .input('S', Blocks.STONE)
                .input('F', ModItems.PINK_GARNET)
                .criterion(hasItem(Blocks.STONE), conditionsFromItem(Blocks.STONE))
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(exporter, Identifier.of(TutorialMod.MOD_ID, "raw_pink_garnet"));

        // Trim pattern recipe
        offerSmithingTrimRecipe(exporter, ModItems.KAWIKA_SMITHING_TEMPLATE,
                Identifier.of(TutorialMod.MOD_ID, "kawika"));
    }
}