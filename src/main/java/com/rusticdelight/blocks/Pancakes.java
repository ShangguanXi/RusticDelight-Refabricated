package com.rusticdelight.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Pancakes extends Block {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final Integer MAX_SERVINGS = 5;
    public static final IntProperty SERVINGS = IntProperty.of("servings", 0, MAX_SERVINGS);

    protected static final VoxelShape PLATE_SHAPE = Block.createCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
    protected static final VoxelShape[] PANCAKES_SHAPES = new VoxelShape[]{
            VoxelShapes.combine(PLATE_SHAPE, Block.createCuboidShape(3.0D, 2.0D, 3.0D, 13.0D, 8.0D, 13.0D), BooleanBiFunction.OR),
            VoxelShapes.combine(PLATE_SHAPE, Block.createCuboidShape(3.0D, 2.0D, 3.0D, 13.0D, 7.0D, 13.0D), BooleanBiFunction.OR),
            VoxelShapes.combine(PLATE_SHAPE, Block.createCuboidShape(3.0D, 2.0D, 3.0D, 13.0D, 6.0D, 13.0D), BooleanBiFunction.OR),
            VoxelShapes.combine(PLATE_SHAPE, Block.createCuboidShape(3.0D, 2.0D, 3.0D, 13.0D, 5.0D, 13.0D), BooleanBiFunction.OR),
            VoxelShapes.combine(PLATE_SHAPE, Block.createCuboidShape(3.0D, 2.0D, 3.0D, 13.0D, 4.0D, 13.0D), BooleanBiFunction.OR),
            VoxelShapes.combine(PLATE_SHAPE, Block.createCuboidShape(3.0D, 2.0D, 3.0D, 13.0D, 3.0D, 13.0D), BooleanBiFunction.OR)
    };
    private final Integer foodLevels;
    private final Float saturation;
    private final StatusEffect statusEffect;
    private final Integer time;
    private final Integer amplifier;

    public Pancakes(Settings settings, Integer foodLevels, Float saturation, StatusEffect statusEffect, Integer time, Integer amplifier) {
        super(settings);
        this.setDefaultState(getStateManager().getDefaultState().with(FACING, Direction.NORTH).with(getServingsProperty(), 0));
        this.foodLevels = foodLevels;
        this.saturation = saturation;
        this.statusEffect = statusEffect;
        this.time = time;
        this.amplifier = amplifier;
    }

    public IntProperty getServingsProperty() {
        return SERVINGS;
    }

    @Override
    public ActionResult onUse(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getStackInHand(hand);
        if (level.isClient) {
            if (this.consumeBite(level, pos, state, player) == ActionResult.SUCCESS) {
                return ActionResult.SUCCESS;
            }
            if (heldStack.isEmpty()) {
                return ActionResult.CONSUME;
            }
        }
        return this.consumeBite(level, pos, state, player);
    }

    protected ActionResult consumeBite(World level, BlockPos pos, BlockState state, PlayerEntity playerIn) {
        if (!playerIn.canConsume(false)) {
            return ActionResult.PASS;
        } else {

            playerIn.getHungerManager().setFoodLevel(playerIn.getHungerManager().getFoodLevel()+foodLevels);
            playerIn.getHungerManager().setSaturationLevel(playerIn.getHungerManager().getSaturationLevel()+ (saturation*foodLevels*2));
            playerIn.addStatusEffect(new StatusEffectInstance(statusEffect, time, amplifier));
            int bites = state.get(SERVINGS);
            if (bites < MAX_SERVINGS) {
                level.setBlockState(pos, state.with(SERVINGS, bites + 1), 5);
            } else {
                level.removeBlock(pos, false);
            }
            level.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.PLAYERS, 0.8F, 0.8F);
            return ActionResult.SUCCESS;
        }
    }




    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, SERVINGS);
    }

    @Override
    public int getComparatorOutput(BlockState blockState, World level, BlockPos pos) {
        return blockState.get(getServingsProperty());
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView level, BlockPos pos, NavigationType type) {
        return false;
    }

    public int getMaxServings() {
        return MAX_SERVINGS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView level, BlockPos pos, ShapeContext context) {
        return PANCAKES_SHAPES[state.get(SERVINGS)];
    }

    public Integer getFoodLevels() {
        return foodLevels;
    }

    public Float getSaturationLevel() {
        return saturation;
    }

    public StatusEffect getStatusEffect() {
        return statusEffect;
    }

    public Integer getTime() {
        return time;
    }

    public Integer getAmplifier() {
        return amplifier;
    }
}
