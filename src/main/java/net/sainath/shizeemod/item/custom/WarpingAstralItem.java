package net.sainath.shizeemod.item.custom;



import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;


public class WarpingAstralItem extends Item {
    public WarpingAstralItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, EquipmentSlot slot) {
        if (entity instanceof Player player) {
            boolean isInHand = slot == EquipmentSlot.MAINHAND || slot == EquipmentSlot.OFFHAND;

            if (isInHand && isExposedToDayLight(level, player.blockPosition())) {
                triggerVanish(level, player.getX(), player.getY() + 1.0, player.getZ());

                stack.shrink(1);
                player.sendSystemMessage(Component.literal(
                        "§cYou exposed the Warping Astral to sunlight! It ceased to exist and bonded back with its mothership."
                ));
            }
        }
        super.inventoryTick(stack, level, entity, slot);
    }
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(Component.literal("§7§oHates the sun. Handle only under cover or in darkness..."));
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }

    private boolean isExposedToDayLight(Level level, BlockPos pos) {
        return level.isBrightOutside() && level.canSeeSky(pos);
    }

    private void triggerVanish(Level level, double x, double y, double z) {
        if (level instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(
                    ParticleTypes.PORTAL,
                    x, y, z,
                    35,
                    0.4, 0.4, 0.4,
                    0.2
            );
            level.playSound(
                    null,
                    x, y, z,
                    SoundEvents.ENDERMAN_TELEPORT,
                    SoundSource.PLAYERS,
                    1.0f,
                    0.8f
            );
        }
    }
}
