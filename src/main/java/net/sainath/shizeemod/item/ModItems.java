package net.sainath.shizeemod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sainath.shizeemod.ShizeesMod;
import net.sainath.shizeemod.item.custom.MeteorieDetectorItem;
import net.sainath.shizeemod.item.custom.MeteorieDetectorItem;

import java.util.function.Consumer;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ShizeesMod.MODID);

    public static final DeferredItem<Item> ASTRAL_SHARD = ITEMS.registerSimpleItem("astralshard");
    public static final DeferredItem<Item> WARPING_ASTRAL = ITEMS.registerSimpleItem("warping_astral");

    public static final DeferredItem<Item> METEORIE_DETECTOR = ITEMS.registerItem("meteorie_detector",
            properties -> new MeteorieDetectorItem(properties.durability(64)){
                @Override
                public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                    builder.accept(Component.translatable("tooltip.shizeesmod.meteoriedetector.tooltip"));
                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                }
            });


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
