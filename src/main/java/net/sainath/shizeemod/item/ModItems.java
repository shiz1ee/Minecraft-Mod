package net.sainath.shizeemod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sainath.shizeemod.ShizeesMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ShizeesMod.MODID);

    public static final DeferredItem<Item> ASTRAL_SHARD = ITEMS.registerSimpleItem("astralshard");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
