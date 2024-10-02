package com.rusticdelight.register;


import com.rusticdelight.blocks.BellPepper;
import com.rusticdelight.blocks.Cotton;
import com.rusticdelight.blocks.Pancakes;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import vectorwing.farmersdelight.common.block.WildCropBlock;
import java.util.ArrayList;
import java.util.List;

public class BlockRegister {
    public static final List<Block> registeredBlocks = new ArrayList<>();
    public static final Block COTTON_BOLL_CRATE =  register("cotton_boll_crate", new Block(Block.Settings.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
    public static final Block BELL_PEPPER_RED_CRATE =  register("bell_pepper_red_crate", new Block(Block.Settings.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
    public static final Block BELL_PEPPER_GREEN_CRATE =  register("bell_pepper_green_crate", new Block(Block.Settings.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
    public static final Block BELL_PEPPER_YELLOW_CRATE =  register("bell_pepper_yellow_crate", new Block(Block.Settings.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
    public static final Block BELL_PEPPER_SEEDS_BAG =  register("bell_pepper_seeds_bag", new Block(Block.Settings.copy(Blocks.WHITE_WOOL).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
    public static final Block COTTON_SEEDS_BAG =  register("cotton_seeds_bag", new Block(Block.Settings.copy(Blocks.WHITE_WOOL).strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD)));
    public static final Block WILD_BELL_PEPPER =  register("wild_bell_peppers", new WildCropBlock(StatusEffects.FIRE_RESISTANCE , 10,Block.Settings.copy(Blocks.TALL_GRASS)));
    public static final Block WILD_COTTON =  register("wild_cotton", new WildCropBlock(StatusEffects.HASTE , 12,Block.Settings.copy(Blocks.TALL_GRASS)));

    public static final Block COTTON =  register("cotton", new Cotton(Block.Settings.copy(Blocks.CARROTS).noCollision().nonOpaque()));
    public static final Block BELL_PEPPER =  register("bell_peppers", new BellPepper(Block.Settings.copy(Blocks.CARROTS).noCollision().nonOpaque()));
    public static final Block HONEY_PANCAKES =  register("honey_pancakes", new Pancakes(Block.Settings.copy(Blocks.CAKE),4,0.6F,StatusEffects.SPEED, 1200, 0));
    public static final Block CHOCOLATE_PANCAKES =  register("chocolate_pancakes", new Pancakes(Block.Settings.copy(Blocks.CAKE),3,0.6F,StatusEffects.SPEED, 1200, 0));
    public static final Block VEGETABLE_PANCAKES =  register("vegetable_pancakes", new Pancakes(Block.Settings.copy(Blocks.CAKE),3,0.6F,StatusEffects.HASTE, 1200, 0));

    private static <T extends Block> T register(String path, T block) {
        Registry.register(Registries.BLOCK, Identifier.of("rusticdelight", path), block);
        Registry.register(Registries.ITEM, Identifier.of("rusticdelight", path), new BlockItem(block, new Item.Settings()));
        registeredBlocks.add(block);
        return block;
    }
    public static void initialize(){

    }
}
