package kawika.tutorialmod.datagen;

import kawika.tutorialmod.block.ModBlocks;
import kawika.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput out,
                                 CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(out, registryLookup);
    }

    @Override
    public void generate() {
        // ===== FLOURITE: blocks drop the FLOURITE item (with fortune), not themselves
        addDrop(ModBlocks.FLOURITE_BLOCK,
                multipleItemDrops(ModBlocks.FLOURITE_BLOCK, ModItems.FLOURITE, 1, 3)); // tweak counts
        addDrop(ModBlocks.FLOURITE_DEEPSLATE_BLOCK,
                multipleItemDrops(ModBlocks.FLOURITE_DEEPSLATE_BLOCK, ModItems.FLOURITE, 1, 3));
        addDrop(ModBlocks.FLOURITE_NETHER_BLOCK,
                multipleItemDrops(ModBlocks.FLOURITE_NETHER_BLOCK, ModItems.FLOURITE, 1, 3));

        // Non-cube flourite parts
        addDrop(ModBlocks.FLOURITE_BUTTON);
        addDrop(ModBlocks.FLOURITE_PRESSURE_PLATE);

        // ===== PINK GARNET (as you had it working)
        addDrop(ModBlocks.PINK_GARNET_ORE,
                oreDrops(ModBlocks.PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));
        addDrop(ModBlocks.PINK_GARNET_DEEPSLATE_ORE,
                oreDrops(ModBlocks.PINK_GARNET_DEEPSLATE_ORE, ModItems.RAW_PINK_GARNET));

        addDrop(ModBlocks.RAW_PINK_GARNET_BLOCK); // drops itself

        addDrop(ModBlocks.PINK_GARNET_BLOCK,
                multipleItemDrops(ModBlocks.PINK_GARNET_BLOCK, ModItems.PINK_GARNET, 4, 9));
    }

    /** Drop multiple of an item, fortune-compatible, silk touch handled. */
    private LootTable.Builder multipleItemDrops(Block sourceBlock, Item dropItem, int min, int max) {
        // Fortune formula same as ore drops; tweak if you want linear count bonus instead
        RegistryWrapper.Impl<Enchantment> enchants =
                this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        return this.dropsWithSilkTouch(sourceBlock,
                this.applyExplosionDecay(sourceBlock,
                        ((LeafEntry.Builder<?>)
                                ItemEntry.builder(dropItem)
                                        .apply(SetCountLootFunction
                                                .builder(UniformLootNumberProvider.create(min, max))))
                                .apply(ApplyBonusLootFunction.oreDrops(enchants.getOrThrow(Enchantments.FORTUNE)))
                ));
    }
}
