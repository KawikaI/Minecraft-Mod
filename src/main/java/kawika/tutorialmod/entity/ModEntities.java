package kawika.tutorialmod.entity;

import kawika.tutorialmod.TutorialMod;



import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import kawika.tutorialmod.TutorialMod;
import kawika.tutorialmod.entity.custom.PorcupineEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static void registerModEntities() {
        TutorialMod.LOGGER.info("Registering Entities for " + TutorialMod.MOD_ID);
    }


    public static final EntityType<PorcupineEntity> PORCUPINE = Registry.register(
            Registries.ENTITY_TYPE, // Correct Registry for EntityType
            Identifier.of(TutorialMod.MOD_ID, "porcupine"), // Corrected Identifier usage
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PorcupineEntity::new) // Entity creation
                    .dimensions(EntityDimensions.fixed(1.0f, 1.0f)) // Set width and height
                    .build()
    );

}
