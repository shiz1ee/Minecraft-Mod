package net.sainath.shizeemod.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.List;

public class ModFoods {
    public static final FoodProperties DONUT = new FoodProperties.Builder().nutrition(2).saturationModifier(0.3f).build();
    public static final Consumable DONUT_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1.7f)
            .onConsume
                    (new ApplyStatusEffectsConsumeEffect
                            (new MobEffectInstance
                                    (MobEffects.SPEED, 400),
                                    1.0f)).build();


    public static final FoodProperties CHOCOLATEBERRYSHORTCAKE = new FoodProperties.Builder().nutrition(10).saturationModifier(0.7f).build();
    public static final Consumable CHOCOLATEBERRYSHORTCAKE_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(2.5f)
            .onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
                    new MobEffectInstance(MobEffects.SPEED, 400, 0), //speed I , 20s
                    new MobEffectInstance(MobEffects.ABSORPTION, 1200, 1) //absoprtion II, 60s

            ))).build();


    public static final FoodProperties CROISSANT = new FoodProperties.Builder().nutrition(3).saturationModifier(0.4f).build();
    public static final Consumable CROISSANT_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1.6f).build();

    public static final FoodProperties CROISSANTSANDWICH = new FoodProperties.Builder().nutrition(8).saturationModifier(0.7f).build();
    public static final Consumable CROISSANTSANDWICH_CONSUMABLE = Consumables.defaultFood().consumeSeconds(2.0f).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION,80,0))).build();

    public static final FoodProperties CROISSANTAVOCADOSANDWICH = new FoodProperties.Builder().nutrition(7).saturationModifier(0.6f).build();
    public static final Consumable CROISSANTAVOCADOSANDWICH_CONSUMABLE = Consumables.defaultFood().consumeSeconds(2.0f).onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
            new MobEffectInstance(MobEffects.REGENERATION, 100,0),
            new MobEffectInstance(MobEffects.RESISTANCE, 200,0)))).build();

    public static final FoodProperties DANISHGLAZED = new FoodProperties.Builder().nutrition(4).saturationModifier(0.5f).build();
    public static final Consumable DANISHGLAZED_CONSUMABLE = Consumables.defaultFood().consumeSeconds(1.6f).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HASTE,300, 0))).build();

    public static final FoodProperties DANISHGLAZED2 = new FoodProperties.Builder().nutrition(4).saturationModifier(0.5f).build();
    public static final Consumable DANISHGLAZED_CONSUMABLE2 = Consumables.defaultFood().consumeSeconds(1.6f).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HASTE,300, 0))).build();

    public static final FoodProperties STRAWBERRYSHORTCAKE = new FoodProperties.Builder().nutrition(8).saturationModifier(0.6f).build();
    public static final Consumable STRAWBERRYSHORTCAKE_CONSUMABLE = Consumables.defaultFood().consumeSeconds(2.2f).onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
            new MobEffectInstance(MobEffects.REGENERATION,100,0),
            new MobEffectInstance(MobEffects.ABSORPTION, 120, 1)
    ))).build();










}