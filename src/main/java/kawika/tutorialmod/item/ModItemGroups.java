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


public class ModItemGroups {
    public static final ItemGroup PINK_GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "pink_garnet_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_GARNET))
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.RAW_PINK_GARNET);


                        entries.add(ModItems.CAULIFLOWER);

                        entries.add(ModItems.STARLIGHT_ASHES);

                        entries.add(ModItems.PINK_GARNET_SWORD);
                        entries.add(ModItems.PINK_GARNET_PICKAXE);
                        entries.add(ModItems.PINK_GARNET_SHOVEL);
                        entries.add(ModItems.PINK_GARNET_AXE);
                        entries.add(ModItems.PINK_GARNET_HOE);
                        entries.add(ModItems.GOON_BOW);


                    }).build());

    public static final ItemGroup PINK_GARNET_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "pink_garnet_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);

                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);


                    }).build());

    public static final ItemGroup FLOURITE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "flourite_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.FLOURITE))
                    .displayName(Text.translatable("itemgroup.tutorialmod.flourite_items"))
                    .entries((displayContext, entries) -> {


                        entries.add(ModItems.FLOURITE_SWORD);
                        entries.add(ModItems.FLOURITE_PICKAXE);
                        entries.add(ModItems.FLOURITE_SHOVEL);
                        entries.add(ModItems.FLOURITE_AXE);
                        entries.add(ModItems.FLOURITE_HOE);
                        entries.add(ModItems.FLOURITE);
                        entries.add(ModItems.RAW_FLOURITE);
                        entries.add(ModBlocks.FLOURITE_BLOCK);
                        entries.add(ModBlocks.FLOURITE_DEEPSLATE_BLOCK);
                        entries.add(ModItems.FLOURITE_HELMET);
                        entries.add(ModItems.FLOURITE_CHESTPLATE);
                        entries.add(ModItems.FLOURITE_LEGGINGS);
                        entries.add(ModItems.FLOURITE_BOOTS);
                        entries.add(ModBlocks.FLOURITE_BUTTON);
                        entries.add(ModBlocks.FLOURITE_PRESSURE_PLATE);
                        entries.add(ModBlocks.FLOURITE_NETHER_BLOCK);
                        entries.add(ModItems.KAWIKA_SMITHING_TEMPLATE);
                        


                    }).build());


    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}