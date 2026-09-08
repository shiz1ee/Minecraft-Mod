package net.sainath.shizeemod.datagen;

import io.netty.util.concurrent.CompleteFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.sainath.shizeemod.ShizeesMod;
import net.sainath.shizeemod.block.ModBlocks;
import net.sainath.shizeemod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class runner extends RecipeProvider.Runner {

        public runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "ShizeesMod Recipies";
        }
    }

    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.MISC, ModBlocks.ASTRAL_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ASTRAL_SHARD.get())
                .unlockedBy(getHasName(ModItems.ASTRAL_SHARD.get()), has(ModItems.ASTRAL_SHARD))
                .group("astral")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.ASTRAL_SHARD.get(), 9)
                .requires(ModBlocks.ASTRAL_BLOCK)
                .unlockedBy(getHasName(ModBlocks.ASTRAL_BLOCK.get()), has(ModBlocks.ASTRAL_BLOCK))
                .group("astral")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.ASTRAL_SHARD.get(), 18)
                .requires(ModBlocks.ASTRAL_BLOCK)
                .requires(Items.DIAMOND)
                .unlockedBy(getHasName(ModBlocks.ASTRAL_BLOCK.get()), has(ModBlocks.ASTRAL_BLOCK))
                .group("astral")
                .save(output, "shizeesmod:astral_from_diamond");

        List<ItemLike> ASTRAL_SHARD_SMELTABLES = List.of(ModItems.WARPING_ASTRAL, ModBlocks.ANZIORITE);

        oreSmelting(ASTRAL_SHARD_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.ASTRAL_SHARD.get(), 0.25f, 200, "astral");
        oreBlasting(ASTRAL_SHARD_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.ASTRAL_SHARD.get(), 0.25f, 100, "astral");
    }

    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables,
                                                                RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result,
                                                                float experience, int cookingTime, String group, String fromDesc) {
        for(ItemLike itemlike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output, ShizeesMod.MODID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemlike));
        }
    }
}
