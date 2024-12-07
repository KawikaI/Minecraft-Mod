package kawika.tutorialmod;

import kawika.tutorialmod.entity.ModEntities;
import kawika.tutorialmod.entity.client.ModModelLayers;
import kawika.tutorialmod.entity.client.PorcupineModel;
import kawika.tutorialmod.entity.client.PorcupineRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.PORCUPINE, PorcupineRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PORCUPINE, PorcupineModel::getTexturedModelData);

    }
}
