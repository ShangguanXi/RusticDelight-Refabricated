package com.rusticdelight.register;

import com.rusticdelight.util.ItemGroupWrapper;

import static com.rusticdelight.RusticDelight.makeId;

public class ItemGroupRegister {
    public static final ItemGroupWrapper RUSTIC_DELIGHT_GROUP = new ItemGroupWrapper(
            makeId("rustic_delight_group"),
            "itemGroup.rusticdelight",
            () -> BlockRegister.WILD_COTTON
    );

    public static void initialize() {}
}
