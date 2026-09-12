package net.sainath.shizeemod.compact;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.sainath.shizeemod.ShizeesMod;
import net.sainath.shizeemod.item.ModItems;

@JeiPlugin
public class ModJEIPlugin implements IModPlugin {

    @Override
    public Identifier getPluginUid() {
        return Identifier.fromNamespaceAndPath(ShizeesMod.MODID, "jei_plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addItemStackInfo(
                new ItemStack(ModItems.WARPING_ASTRAL.get()),
                Component.literal("§cWARNING:§r Warping Astral is violently sensitive to direct sunlight. "
                        + "Exposing this item to an open sky during the day will cause it to destabilize, "
                        + "evaporate from your hands or ground, and reconnect with its mothership.")
        );

        registration.addItemStackInfo(
                new ItemStack(ModItems.METEORIE_DETECTOR.get()),
                Component.literal("Used to scan deep underground bedrock layers for traces of Anzionite Ore.")
        );
    }
}