package kawika.tutorialmod.block.custom;



import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class ModSaplingBlock extends SaplingBlock {
    private Block blockToSpawnOn;

    public ModSaplingBlock(SaplingGenerator generator, Settings settings, Block blockToSpawnOn) {
        super(generator, settings);
        this.blockToSpawnOn = blockToSpawnOn;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.DIRT) || floor.isOf(blockToSpawnOn);
    }
}
