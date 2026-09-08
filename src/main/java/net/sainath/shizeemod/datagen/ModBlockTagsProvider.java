package net.sainath.shizeemod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.sainath.shizeemod.ShizeesMod;
import net.sainath.shizeemod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, ShizeesMod.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ASTRAL_BLOCK.getKey())
                .add(ModBlocks.ANZIORITE.getKey());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ANZIORITE.getKey());
    }
}
