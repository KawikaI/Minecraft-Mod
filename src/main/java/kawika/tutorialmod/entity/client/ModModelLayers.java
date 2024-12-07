package kawika.tutorialmod.entity.client;


import kawika.tutorialmod.TutorialMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer PORCUPINE =
            new EntityModelLayer(Identifier.of(TutorialMod.MOD_ID, "porcupine"), "main");

}
