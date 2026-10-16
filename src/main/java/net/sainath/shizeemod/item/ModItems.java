package net.sainath.shizeemod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sainath.shizeemod.ShizeesMod;
import net.sainath.shizeemod.food.ModFoods;
import net.sainath.shizeemod.item.custom.MeteorieDetectorItem;
import net.sainath.shizeemod.item.custom.MeteorieDetectorItem;
import net.sainath.shizeemod.item.custom.WarpingAstralItem;

import java.util.function.Consumer;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ShizeesMod.MODID);

    public static final DeferredItem<Item> ASTRAL_SHARD = ITEMS.registerSimpleItem("astralshard");
    public static final DeferredItem<Item> WARPING_ASTRAL = ITEMS.registerItem("warping_astral", WarpingAstralItem::new);

    public static final DeferredItem<Item> METEORIE_DETECTOR = ITEMS.registerItem("meteorie_detector",
            properties -> new MeteorieDetectorItem(properties.durability(64)){
                @Override
                public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                    builder.accept(Component.translatable("tooltip.shizeesmod.meteoriedetector.tooltip"));
                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> DONUT = ITEMS.registerItem("donut",
            properties -> new Item(properties.food(ModFoods.DONUT, ModFoods.DONUT_CONSUMABLE)));

    public static final DeferredItem<Item> CHOCOLATEBERRYSHORTCAKE = ITEMS.registerItem("chocolateberryshortcake",
            properties -> new Item(properties.food(ModFoods.CHOCOLATEBERRYSHORTCAKE, ModFoods.CHOCOLATEBERRYSHORTCAKE_CONSUMABLE)));

    public static final DeferredItem<Item> CROISSANT = ITEMS.registerItem("croissant",
            properties -> new Item(properties.food(ModFoods.CROISSANT, ModFoods.CROISSANT_CONSUMABLE)));

    public static final DeferredItem<Item> CROISSANTSANDWICH = ITEMS.registerItem("croissantsandwich",
            properties -> new Item(properties.food(ModFoods.CROISSANTSANDWICH, ModFoods.CROISSANTSANDWICH_CONSUMABLE)));

    public static final DeferredItem<Item> CROISSANTAVOCADOSANDWICH = ITEMS.registerItem("croissantavocadosandwich",
            properties -> new Item(properties.food(ModFoods.CROISSANTAVOCADOSANDWICH, ModFoods.CROISSANTAVOCADOSANDWICH_CONSUMABLE)));

    public static final DeferredItem<Item> DANISHGLAZED = ITEMS.registerItem("danishglazed",
            properties -> new Item(properties.food(ModFoods.DANISHGLAZED, ModFoods.DANISHGLAZED_CONSUMABLE)));

    public static final DeferredItem<Item> DANISHGLAZED2 = ITEMS.registerItem("danishglazed2",
            properties -> new Item(properties.food(ModFoods.DANISHGLAZED2, ModFoods.DANISHGLAZED_CONSUMABLE2)));

    public static final DeferredItem<Item> STRAWBERRYSHORTCAKE = ITEMS.registerItem("strawberryshortcake",
            properties -> new Item(properties.food(ModFoods.STRAWBERRYSHORTCAKE, ModFoods.STRAWBERRYSHORTCAKE_CONSUMABLE)));

    public static DeferredItem<Item> DOUGH = ITEMS.registerItem("dough",
            properties -> new Item(properties.food(ModFoods.DOUGH, ModFoods.DOUGH_CONSUMABLE)));

    public static DeferredItem<Item> CHOCOLATE = ITEMS.registerItem("chocolate",
            properties -> new Item(properties.food(ModFoods.CHOCOLATE, ModFoods.CHOCOLATE_CONSUMALBE)));

    public static DeferredItem<Item> STRAWBERRY = ITEMS.registerItem("strawberry",
            properties -> new Item(properties.food(ModFoods.STRAWBERRY, ModFoods.STRAWBERRY_CONSUMALBE)));

    public static DeferredItem<Item> AVOCADO = ITEMS.registerItem("avocado",
            properties -> new Item(properties.food(ModFoods.AVOCADO, ModFoods.AVOCADO_CONSUMALBE)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
