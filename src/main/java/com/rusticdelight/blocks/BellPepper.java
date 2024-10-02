package com.rusticdelight.blocks;

import com.rusticdelight.register.ItemRegister;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class BellPepper extends CropBlock {


    public BellPepper(Settings settings) {
        super(settings);
    }
    @Override
    protected ItemConvertible getSeedsItem() {
        return ItemRegister.BELL_PEPPER_SEEDS;
    }



}
