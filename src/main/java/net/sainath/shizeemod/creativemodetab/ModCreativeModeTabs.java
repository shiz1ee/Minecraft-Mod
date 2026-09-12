package net.sainath.shizeemod.creativemodetab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sainath.shizeemod.ShizeesMod;
import net.sainath.shizeemod.block.ModBlocks;
import net.sainath.shizeemod.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ShizeesMod.MODID);

    public static final Supplier<CreativeModeTab> ASTRAL_ITEMS_TAB = CREATIVE_MODE_TABS.register("astral_items_tab"
        , () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ASTRAL_SHARD.get()))
                    .title(Component.translatable("creativetab.ShizeesMod.Astral_items"))
                    .withTabsBefore(CreativeModeTabs.INGREDIENTS)
                    .withTabsAfter(Identifier.fromNamespaceAndPath(ShizeesMod.MODID, "astal_blocks_tab"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(ModItems.ASTRAL_SHARD);
                        output.accept(ModItems.WARPING_ASTRAL);

                        output.accept(ModItems.METEORIE_DETECTOR);


                    }).build());


    public static final Supplier<CreativeModeTab> ASTRAL_BLOCKS_TAB = CREATIVE_MODE_TABS.register("astral_blocks_tab"
        , () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ASTRAL_BLOCK.get()))
                    .title(Component.translatable("creativetab.ShizeesMod.Astral_blocks"))
                    .displayItems((itemDisplayParameters, output) ->{
                        output.accept(ModBlocks.ASTRAL_BLOCK);
                        output.accept(ModBlocks.ANZIORITE);


                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
