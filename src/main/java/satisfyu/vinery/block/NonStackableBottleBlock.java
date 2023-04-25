package satisfyu.vinery.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class NonStackableBottleBlock extends WineBottleBlock {
	public NonStackableBottleBlock(Properties settings) {
		super(settings);
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		VoxelShape shape = Shapes.empty();
		shape = Shapes.or(shape, Shapes.box(0.1875, 0, 0.1875, 0.8125, 0.875, 0.8125));
		return shape;
	}

	@Override
	public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
		return this.defaultBlockState();
	}

	@Override
	public boolean canBeReplaced(BlockState pState, BlockPlaceContext pUseContext) {
		return pState.getMaterial().isReplaceable() && (pUseContext.getItemInHand().isEmpty()
				|| pUseContext.getItemInHand().getItem() != this.asItem());
	}

}
