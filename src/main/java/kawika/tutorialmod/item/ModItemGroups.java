package kawika.tutorialmod.item;

import kawika.tutorialmod.TutorialMod;
import kawika.tutorialmod.block.ModBlocks;
import kawika.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

// create custom items item group
public class ModItemGroups {
    public static final ItemGroup CUSTOM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "custom_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RUBY))
                    .displayName(Text.translatable("itemgroup.tutorialmod.custom_items"))
                    .entries((displayContext, entries) -> {
                        // enter into tab
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);
                    }).build());

    // create custom blocks item group
    public static final ItemGroup CUSTOM_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "custom_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.custom_blocks"))
                    .entries((displayContext, entries) -> {
                        // enter into tab
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                    }).build());

    // register item groups
    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
