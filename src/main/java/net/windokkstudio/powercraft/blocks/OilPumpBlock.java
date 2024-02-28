package net.windokkstudio.powercraft.blocks;


import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.windokkstudio.powercraft.init.PowercraftBlocks;


import javax.annotation.Nullable;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.System.*;


public class OilPumpBlock extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    List<BlockPos> positions = new ArrayList<>();

    public OilPumpBlock() {
        super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.GRAVEL).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0;
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        List<ItemStack> dropsOriginal = super.getDrops(state, builder);
        if (!dropsOriginal.isEmpty())
            return dropsOriginal;
        return Collections.singletonList(new ItemStack(this, 1));
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
        destroyOilPump(world);
        boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
        return retval;
    }

    @Override
    public void wasExploded(Level world, BlockPos pos, Explosion e) {
        destroyOilPump(world);
        super.wasExploded(world, pos, e);
    }

    @Override
    public void destroy(LevelAccessor p_49860_, BlockPos p_49861_, BlockState p_49862_){
        destroyOilPump(p_49860_);
        super.destroy(p_49860_,p_49861_,p_49862_);
    }


    public void destroyOilPump(LevelAccessor world){
        for (BlockPos position : positions) {
            world.setBlock(position, Blocks.AIR.defaultBlockState(), 3);
        }
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState blockstate, LivingEntity entity, ItemStack itemstack) {
        super.setPlacedBy(world, pos, blockstate, entity, itemstack);

        double startX = pos.getX();
        double startY = pos.getY();
        double startZ = pos.getZ();
        switch (blockstate.getValue(FACING)){
            case NORTH -> {

                double minX = startX - 2;
                double maxX = startX + 1;
                double minY = startY;
                double maxY = startY + 4;
                double minZ = startZ - 3;
                double maxZ = startZ + 2;

                for (double x = minX; x <= maxX; x++) {
                    for (double y = minY; y <= maxY; y++) {
                        for (double z = minZ; z <= maxZ; z++) {
                            if(x != startX || y != startY || z != startZ){
                                positions.add(BlockPos.containing(x, y, z));
                                world.setBlock(BlockPos.containing(x, y, z), PowercraftBlocks.OIL_PUMP_COLLISION.get().defaultBlockState(), 3);
                                if (!world.isClientSide()) {
                                    BlockPos _bp = BlockPos.containing(x, y, z);
                                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                    BlockState _bs = world.getBlockState(_bp);
                                    if (_blockEntity != null)
                                        _blockEntity.getPersistentData().putDouble("parent_x", pos.getX());
                                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                                }
                                if (!world.isClientSide()) {
                                    BlockPos _bp = BlockPos.containing(x, y, z);
                                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                    BlockState _bs = world.getBlockState(_bp);
                                    if (_blockEntity != null)
                                        _blockEntity.getPersistentData().putDouble("parent_y", pos.getY());
                                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                                }
                                if (!world.isClientSide()) {
                                    BlockPos _bp = BlockPos.containing(x, y, z);
                                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                    BlockState _bs = world.getBlockState(_bp);
                                    if (_blockEntity != null)
                                        _blockEntity.getPersistentData().putDouble("parent_z", pos.getZ());
                                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                                }
                            }
                        }
                    }
                }
            }
            case WEST -> {
                double maxX = startX + 2;
                double minX = startX - 3;
                double minY = startY;
                double maxY = startY + 4;
                double minZ = startZ - 1;
                double maxZ = startZ + 2;

                for (double x = minX; x <= maxX; x++) {
                    for (double y = minY; y <= maxY; y++) {
                        for (double z = minZ; z <= maxZ; z++) {
                            if(x != startX || y != startY || z != startZ){
                                positions.add(BlockPos.containing(x, y, z));

                                world.setBlock(BlockPos.containing(x, y, z), PowercraftBlocks.OIL_PUMP_COLLISION.get().defaultBlockState(), 3);
                                if (!world.isClientSide()) {
                                    BlockPos _bp = BlockPos.containing(x, y, z);
                                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                    BlockState _bs = world.getBlockState(_bp);
                                    if (_blockEntity != null)
                                        _blockEntity.getPersistentData().putDouble("parent_x", pos.getX());
                                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                                }
                                if (!world.isClientSide()) {
                                    BlockPos _bp = BlockPos.containing(x, y, z);
                                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                    BlockState _bs = world.getBlockState(_bp);
                                    if (_blockEntity != null)
                                        _blockEntity.getPersistentData().putDouble("parent_y", pos.getY());
                                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                                }
                                if (!world.isClientSide()) {
                                    BlockPos _bp = BlockPos.containing(x, y, z);
                                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                    BlockState _bs = world.getBlockState(_bp);
                                    if (_blockEntity != null)
                                        _blockEntity.getPersistentData().putDouble("parent_z", pos.getZ());
                                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                                }
                            }
                        }
                    }
                }
            }
            case SOUTH -> {
                double minX = startX - 1;
                double maxX = startX + 2;
                double minY = startY;
                double maxY = startY + 4;
                double maxZ = startZ + 3;
                double minZ = startZ - 2;

                for (double x = minX; x <= maxX; x++) {
                    for (double y = minY; y <= maxY; y++) {
                        for (double z = minZ; z <= maxZ; z++) {
                            if(x != startX || y != startY || z != startZ){
                                positions.add(BlockPos.containing(x, y, z));
                                world.setBlock(BlockPos.containing(x, y, z), PowercraftBlocks.OIL_PUMP_COLLISION.get().defaultBlockState(), 3);
                                if (!world.isClientSide()) {
                                    BlockPos _bp = BlockPos.containing(x, y, z);
                                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                    BlockState _bs = world.getBlockState(_bp);
                                    if (_blockEntity != null)
                                        _blockEntity.getPersistentData().putDouble("parent_x", pos.getX());
                                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                                }
                                if (!world.isClientSide()) {
                                    BlockPos _bp = BlockPos.containing(x, y, z);
                                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                    BlockState _bs = world.getBlockState(_bp);
                                    if (_blockEntity != null)
                                        _blockEntity.getPersistentData().putDouble("parent_y", pos.getY());
                                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                                }
                                if (!world.isClientSide()) {
                                    BlockPos _bp = BlockPos.containing(x, y, z);
                                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                    BlockState _bs = world.getBlockState(_bp);
                                    if (_blockEntity != null)
                                        _blockEntity.getPersistentData().putDouble("parent_z", pos.getZ());
                                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                                }
                            }
                        }
                    }
                }
            }
            case EAST -> {
                double minX = startX - 2;
                double maxX = startX + 3;
                double minY = startY;
                double maxY = startY + 4;
                double minZ = startZ - 2;
                double maxZ = startZ + 1;

                for (double x = minX; x <= maxX; x++) {
                    for (double y = minY; y <= maxY; y++) {
                        for (double z = minZ; z <= maxZ; z++) {
                            if(x != startX || y != startY || z != startZ){
                                positions.add(BlockPos.containing(x, y, z));

                                world.setBlock(BlockPos.containing(x, y, z), PowercraftBlocks.OIL_PUMP_COLLISION.get().defaultBlockState(), 3);
                                if (!world.isClientSide()) {
                                    BlockPos _bp = BlockPos.containing(x, y, z);
                                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                    BlockState _bs = world.getBlockState(_bp);
                                    if (_blockEntity != null)
                                        _blockEntity.getPersistentData().putDouble("parent_x", pos.getX());
                                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                                }
                                if (!world.isClientSide()) {
                                    BlockPos _bp = BlockPos.containing(x, y, z);
                                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                    BlockState _bs = world.getBlockState(_bp);
                                    if (_blockEntity != null)
                                        _blockEntity.getPersistentData().putDouble("parent_y", pos.getY());
                                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                                }
                                if (!world.isClientSide()) {
                                    BlockPos _bp = BlockPos.containing(x, y, z);
                                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                                    BlockState _bs = world.getBlockState(_bp);
                                    if (_blockEntity != null)
                                        _blockEntity.getPersistentData().putDouble("parent_z", pos.getZ());
                                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                                }
                            }
                        }
                    }
                }
            }
        }

    }




}
