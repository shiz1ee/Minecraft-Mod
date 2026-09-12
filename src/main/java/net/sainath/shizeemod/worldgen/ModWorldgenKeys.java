package net.sainath.shizeemod.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.sainath.shizeemod.ShizeesMod;

public class ModWorldgenKeys {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ANZIONITE_ORE_KEY =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(ShizeesMod.MODID, "anzionite_ore"));

    public static final ResourceKey<PlacedFeature> ANZIONITE_ORE_PLACED_KEY =
            ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(ShizeesMod.MODID, "anzionite_ore_placed"));

    public static final ResourceKey<BiomeModifier> ADD_ANZIONITE_ORE_MODIFIER =
            ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Identifier.fromNamespaceAndPath(ShizeesMod.MODID, "add_anzionite_ore"));
}