package net.sainath.shizeemod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sainath.shizeemod.ShizeesMod;
import net.sainath.shizeemod.item.custom.MeteorieDetectorItem;
import net.sainath.shizeemod.item.custom.MeteorieDetectorItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ShizeesMod.MODID);

    public static final DeferredItem<Item> ASTRAL_SHARD = ITEMS.registerSimpleItem("astralshard");
    public static final DeferredItem<Item> WARPING_ASTRAL = ITEMS.registerSimpleItem("warping_astral");

    public static final DeferredItem<Item> METEORIE_DETECTOR = ITEMS.registerItem("meteorie_detector",
            properties -> new MeteorieDetectorItem(properties.durability(64)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
