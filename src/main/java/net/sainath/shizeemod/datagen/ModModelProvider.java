package net.sainath.shizeemod.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.sainath.shizeemod.ShizeesMod;
import net.sainath.shizeemod.block.ModBlocks;
import net.sainath.shizeemod.item.ModItems;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, ShizeesMod.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.ASTRAL_SHARD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.WARPING_ASTRAL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.METEORIE_DETECTOR.get(), ModelTemplates.FLAT_ITEM);

        /*BLOCKa*/
        blockModels.createTrivialCube(ModBlocks.ASTRAL_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.ANZIORITE.get());

    }
}
