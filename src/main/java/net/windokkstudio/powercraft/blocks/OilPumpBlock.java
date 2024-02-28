package net.windokkstudio.powercraft.blocks;


import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
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


import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.lang.System.*;


public class OilPumpBlock extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

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
    public void setPlacedBy(Level world, BlockPos pos, BlockState blockstate, LivingEntity entity, ItemStack itemstack) {
        super.setPlacedBy(world, pos, blockstate, entity, itemstack);
        List<BlockPos> positions = new ArrayList<>();
        switch (blockstate.getValue(FACING)){
            case NORTH -> {
                //First Collider
                positions.add(BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() + 1));
                world.setBlock(BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() + 1), PowercraftBlocks.OIL_PUMP_COLLISION.get().defaultBlockState(), 3);
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() + 1);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("parent_x", pos.getX());
                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() + 1);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("parent_y", pos.getY());
                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() + 1);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("parent_z", pos.getZ());
                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                }

                //Second Collider
                positions.add(BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() + 2));
                world.setBlock(BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() + 2), PowercraftBlocks.OIL_PUMP_COLLISION.get().defaultBlockState(), 3);
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() + 2);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("parent_x", pos.getX());
                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() + 2);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("parent_y", pos.getY());
                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() + 2);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("parent_z", pos.getZ());
                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                }

                //Third Collider
                positions.add(BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() - 1 ));
                world.setBlock(BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() - 1), PowercraftBlocks.OIL_PUMP_COLLISION.get().defaultBlockState(), 3);
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() - 1);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("parent_x", pos.getX());
                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() - 1);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("parent_y", pos.getY());
                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() - 1);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("parent_z", pos.getZ());
                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                }

                //Fourth Collider
                positions.add(BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() - 2 ));
                world.setBlock(BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() - 2), PowercraftBlocks.OIL_PUMP_COLLISION.get().defaultBlockState(), 3);
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() - 2);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("parent_x", pos.getX());
                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() - 2);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("parent_y", pos.getY());
                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() - 2);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("parent_z", pos.getZ());
                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                }

                //Fifth Collider
                positions.add(BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() - 3 ));
                world.setBlock(BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() - 3), PowercraftBlocks.OIL_PUMP_COLLISION.get().defaultBlockState(), 3);
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() - 3);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("parent_x", pos.getX());
                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() - 3);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("parent_y", pos.getY());
                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                }
                if (!world.isClientSide()) {
                    BlockPos _bp = BlockPos.containing(pos.getX(), pos.getY(), pos.getZ() - 3);
                    BlockEntity _blockEntity = world.getBlockEntity(_bp);
                    BlockState _bs = world.getBlockState(_bp);
                    if (_blockEntity != null)
                        _blockEntity.getPersistentData().putDouble("parent_z", pos.getZ());
                    world.sendBlockUpdated(_bp, _bs, _bs, 3);
                }

            }

            case WEST -> {System.out.println("WEST");}
            case SOUTH -> {System.out.println("SOUTH");}
            case EAST -> {System.out.println("EAST");}
        }





    }


}
