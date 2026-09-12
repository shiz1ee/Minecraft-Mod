package net.sainath.shizeemod.datagen;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.sainath.shizeemod.block.ModBlocks;
import net.sainath.shizeemod.worldgen.ModWorldgenKeys;

import java.util.List;

public class ModConfiguredFeatures {
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> targets = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ANZIORITE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.ANZIORITE.get().defaultBlockState())
        );

        // 6 blocks per cluster, 30% air-exposure discard chance
        context.register(ModWorldgenKeys.OVERWORLD_ANZIONITE_ORE_KEY,
                new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(targets, 6, 0.3f)));
    }
}