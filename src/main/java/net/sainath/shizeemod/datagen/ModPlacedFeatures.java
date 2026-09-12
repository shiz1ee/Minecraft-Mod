package net.sainath.shizeemod.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.sainath.shizeemod.worldgen.ModWorldgenKeys;

import java.util.List;

public class ModPlacedFeatures {
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> oreHolder = configuredFeatures.getOrThrow(ModWorldgenKeys.OVERWORLD_ANZIONITE_ORE_KEY);

        context.register(ModWorldgenKeys.ANZIONITE_ORE_PLACED_KEY,
                new PlacedFeature(oreHolder, List.of(
                        CountPlacement.of(8),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(16)
                        ),
                        BiomeFilter.biome()
                ))
        );
    }
}