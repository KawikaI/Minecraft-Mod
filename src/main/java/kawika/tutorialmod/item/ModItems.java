package kawika.tutorialmod.item;

import kawika.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

// creates  and init items
public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));


    public static final Item GOON_BOW = registerItem("goon_bow",
            new BowItem(new Item.Settings().maxDamage(500)));

    public static final Item CAULIFLOWER = registerItem("cauliflower",
            new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)));

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes",
            new Item(new Item.Settings()));


    // adds items to ingredients tab
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(PINK_GARNET);
        entries.add(RAW_PINK_GARNET);
        entries.add(CAULIFLOWER);
    }

    // register items
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }
    // Initialize and register all custom items for the mod
    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}

