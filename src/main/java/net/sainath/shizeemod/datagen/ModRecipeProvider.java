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
import net.minecraft.world.level.block.Blocks;
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

        shaped(RecipeCategory.MISC, ModItems.METEORIE_DETECTOR.get())
                .pattern("BCB")
                .pattern("CAC")
                .pattern("BCB")
                .define('A', Items.DIAMOND)
                .define('B', Blocks.ANDESITE)
                .define('C', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.DIAMOND))
                .group("astral")
                .save(output);



        shapeless(RecipeCategory.FOOD, ModItems.DOUGH.get())
                .requires(Items.WHEAT, 3).requires(Items.EGG).requires(Items.MILK_BUCKET)
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(output);

        shapeless(RecipeCategory.FOOD, ModItems.CHOCOLATE.get())
                .requires(Items.COCOA_BEANS, 2).requires(Items.SUGAR).requires(Items.MILK_BUCKET)
                .unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
                .save(output);

        shapeless(RecipeCategory.FOOD, ModItems.STRAWBERRY.get())
                .requires(Items.SWEET_BERRIES).requires(Items.WHEAT_SEEDS)
                .unlockedBy(getHasName(Items.SWEET_BERRIES), has(Items.SWEET_BERRIES))
                .save(output);

        shapeless(RecipeCategory.FOOD, ModItems.AVOCADO.get())
                .requires(Items.APPLE).requires(Items.EMERALD)
                .unlockedBy(getHasName(Items.APPLE), has(Items.APPLE))
                .save(output);

        //FOOOOOODDDDDDD
        oreSmelting(List.of(ModItems.DOUGH.get()), RecipeCategory.FOOD, CookingBookCategory.FOOD,
                ModItems.CROISSANT.get(), 0.35f, 200, "croissant");

        shapeless(RecipeCategory.FOOD, ModItems.CROISSANTSANDWICH.get())
                .requires(ModItems.CROISSANT.get()).requires(Items.COOKED_BEEF).requires(Items.EGG)
                .unlockedBy(getHasName(ModItems.CROISSANT.get()), has(ModItems.CROISSANT.get()))
                .save(output);

        shapeless(RecipeCategory.FOOD, ModItems.CROISSANTAVOCADOSANDWICH.get())
                .requires(ModItems.CROISSANT.get()).requires(ModItems.AVOCADO).requires(Items.EGG)
                .unlockedBy(getHasName(ModItems.CROISSANT.get()), has(ModItems.CROISSANT.get()))
                .save(output);

        shapeless(RecipeCategory.FOOD, ModItems.DANISHGLAZED.get())
                .requires(ModItems.DOUGH.get()).requires(Items.HONEY_BOTTLE).requires(Items.SUGAR)
                .unlockedBy(getHasName(ModItems.DOUGH.get()), has(ModItems.DOUGH.get()))
                .save(output);

        shapeless(RecipeCategory.FOOD, ModItems.DANISHGLAZED2.get())
                .requires(ModItems.DANISHGLAZED.get()).requires(ModItems.STRAWBERRY.get())
                .unlockedBy(getHasName(ModItems.DANISHGLAZED.get()), has(ModItems.DANISHGLAZED.get()))
                .save(output);

        shapeless(RecipeCategory.FOOD, ModItems.STRAWBERRYSHORTCAKE.get())
                .requires(ModItems.DOUGH.get()).requires(ModItems.STRAWBERRY.get(), 2)
                .requires(Items.SUGAR).requires(Items.EGG)
                .unlockedBy(getHasName(ModItems.STRAWBERRY.get()), has(ModItems.STRAWBERRY.get()))
                .save(output);

        shapeless(RecipeCategory.FOOD, ModItems.CHOCOLATEBERRYSHORTCAKE.get())
                .requires(ModItems.DOUGH.get()).requires(ModItems.CHOCOLATE.get())
                .requires(ModItems.STRAWBERRY.get()).requires(Items.SWEET_BERRIES).requires(Items.SUGAR)
                .unlockedBy(getHasName(ModItems.CHOCOLATE.get()), has(ModItems.CHOCOLATE.get()))
                .save(output);

        shaped(RecipeCategory.FOOD, ModItems.DONUT.get(),2)
                .pattern(" S ")
                .pattern("D D")
                .pattern(" D ")
                .define('S', Items.SUGAR)
                .define('D', ModItems.DONUT.get())
                .unlockedBy(getHasName(ModItems.DOUGH.get()), has(ModItems.DOUGH.get()))
                .save(output);

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
