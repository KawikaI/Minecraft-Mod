package kawika.tutorialmod.block;
import kawika.tutorialmod.TutorialMod;
import kawika.tutorialmod.world.tree.ModSaplingGenerators;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import kawika.tutorialmod.block.custom.ModSaplingBlock;

// blocks
public class ModBlocks {
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(4f)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()));

    public static final Block FLOURITE_BLOCK = registerBlock("flourite_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()));

    public static final Block FLOURITE_ORE = registerBlock("flourite_ore",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()));



    public static final Block FLOURITE_DEEPSLATE_BLOCK = registerBlock("flourite_deepslate_block",
            new Block(AbstractBlock.Settings.create().strength(3f)
                    .requiresTool()));


    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
        new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));




    public static final Block FLOURITE_NETHER_BLOCK = Registry.register(
            Registries.BLOCK,
            Identifier.of(TutorialMod.MOD_ID, "flourite_nether_block"),
            new Block(FabricBlockSettings.create()
                    .strength(3.0f, 3.0f)      // tweak hardness/resistance
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHER_GOLD_ORE)) // or NETHERRACK, STONE, etc.
    );

    public static final Block FLOURITE_BUTTON = registerBlock("flourite_button",
            new ButtonBlock(BlockSetType.IRON, 10, AbstractBlock.Settings.create().requiresTool()));
    public static final Block FLOURITE_PRESSURE_PLATE = registerBlock("flourite_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().requiresTool()));

    public static final Block BLACKWOOD_LOG = registerBlock("blackwood_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG).strength(3f)));
    public static final Block BLACKWOOD_WOOD = registerBlock("blackwood_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD).strength(3f)));
    public static final Block STRIPPED_BLACKWOOD_LOG = registerBlock("stripped_blackwood_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final Block STRIPPED_BLACKWOOD_WOOD = registerBlock("stripped_blackwood_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));

    public static final Block BLACKWOOD_PLANKS = registerBlock("blackwood_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).strength(3f)));
    public static final Block BLACKWOOD_LEAVES = registerBlock("blackwood_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));

    public static final Block BLACKWOOD_SAPLING = registerBlock("blackwood_sapling",
            new ModSaplingBlock(ModSaplingGenerators.BLACKWOOD, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING), Blocks.END_STONE));





    // register block itself
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    // register block item (allows players to hold and place block)
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    // Initialize and register all custom blocks for the mod
    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        // add blocks to item group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.PINK_GARNET_BLOCK);
            entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
            entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
            entries.add(ModBlocks.PINK_GARNET_ORE);
        });
    }
}
