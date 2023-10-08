package teamdraco.unnamedanimalmod.common.worldgen.trees.mangrove;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class Entry {
    public final BlockPos pos;
    public final BlockState state;

    public Entry(BlockPos pos, BlockState state) {
        this.pos = pos;
        this.state = state;
    }
}
