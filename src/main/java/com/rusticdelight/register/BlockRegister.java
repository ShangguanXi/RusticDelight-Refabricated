package com.rusticdelight.register;


import com.rusticdelight.blocks.BellPepperCorpBlock;
import com.rusticdelight.blocks.CottonCorpBlock;
import com.rusticdelight.blocks.PancakeBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import static com.rusticdelight.RusticDelight.makeId;
import static com.rusticdelight.register.ItemGroupRegister.RUSTIC_DELIGHT_GROUP;

public class BlockRegister {
    public static final Block COTTON_BOLL_CRATE = registerWithItem("cotton_boll_crate", new Block(Block.Settings.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
    public static final Block BELL_PEPPER_RED_CRATE = registerWithItem("bell_pepper_red_crate", new Block(Block.Settings.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
    public static final Block BELL_PEPPER_GREEN_CRATE = registerWithItem("bell_pepper_green_crate", new Block(Block.Settings.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
    public static final Block BELL_PEPPER_YELLOW_CRATE = registerWithItem("bell_pepper_yellow_crate", new Block(Block.Settings.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
    public static final Block BELL_PEPPER_SEEDS_BAG = registerWithItem("bell_pepper_seeds_bag", new Block(Block.Settings.copy(Blocks.WHITE_WOOL).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
    public static final Block COTTON_SEEDS_BAG = registerWithItem("cotton_seeds_bag", new Block(Block.Settings.copy(Blocks.WHITE_WOOL).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
    public static final Block WILD_BELL_PEPPERS = registerWithItem("wild_bell_peppers", new WildCropBlock(StatusEffects.FIRE_RESISTANCE, 10, Block.Settings.copy(Blocks.TALL_GRASS)));
    public static final Block WILD_COTTON = registerWithItem("wild_cotton", new WildCropBlock(StatusEffects.HASTE, 12, Block.Settings.copy(Blocks.TALL_GRASS)));

    public static final Block COTTON = register("cotton", new CottonCorpBlock(Block.Settings.copy(Blocks.CARROTS).noCollision().nonOpaque()));
    public static final Block BELL_PEPPER = register("bell_peppers", new BellPepperCorpBlock(Block.Settings.copy(Blocks.CARROTS).noCollision().nonOpaque()));
    public static final Block HONEY_PANCAKES = registerWithItem("honey_pancakes", new PancakeBlock(Block.Settings.copy(Blocks.CAKE), 4, 0.6F, StatusEffects.SPEED, 1200, 0));
    public static final Block CHOCOLATE_PANCAKES = registerWithItem("chocolate_pancakes", new PancakeBlock(Block.Settings.copy(Blocks.CAKE), 3, 0.6F, StatusEffects.SPEED, 1200, 0));
    public static final Block VEGETABLE_PANCAKES = registerWithItem("vegetable_pancakes", new PancakeBlock(Block.Settings.copy(Blocks.CAKE), 3, 0.6F, StatusEffects.HASTE, 1200, 0));

    private static <T extends Block> T register(String path, T block) {
        return Registry.register(Registries.BLOCK, makeId(path), block);
    }

    private static <T extends Block> T registerWithItem(String path, T block) {
        var identifier = makeId(path);
        RUSTIC_DELIGHT_GROUP.register(Registries.ITEM, identifier, new BlockItem(block, new Item.Settings()));
        return Registry.register(Registries.BLOCK, identifier, block);
    }

    public static void initialize() {}
}
