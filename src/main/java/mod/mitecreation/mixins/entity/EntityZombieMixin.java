package mod.mitecreation.mixins.entity;

import mod.mitecreation.item.CreationItem;
import mod.mitecreation.util.EntityZombieDropHelper;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.ArrayList;
import java.util.List;

@Mixin(EntityZombie.class)
public class EntityZombieMixin extends EntityAnimalWatcher {
    @Shadow
    Item[] rare_drops_villager;

    public EntityZombieMixin(World par1World) {
        super(par1World);
    }

    /**
     * @author
     * @reason
     */
    @Overwrite
    protected void dropFewItems(boolean recently_hit_by_player, DamageSource damage_source) {
        if (this.rand.nextFloat() < (recently_hit_by_player ? 0.5F : 0.25F)) {
            this.dropItem(Item.rottenFlesh.itemID, 1);
        }

        if (recently_hit_by_player && !this.has_taken_massive_fall_damage && this.rand.nextInt(this.getBaseChanceOfRareDrop()) < 5 + damage_source.getLootingModifier() * 2) {
            Item[] rare_drops = this.isVillager() ? this.rare_drops_villager : EntityZombieDropHelper.rare_drops_standard;
            this.dropItem(rare_drops[this.rand.nextInt(rare_drops.length)].itemID, 1);
        }

    }

    @Inject(
            method = "addRandomWeapon",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/WeightedRandom;getRandomItem(Ljava/util/Random;Ljava/util/Collection;)Lnet/minecraft/WeightedRandomItem;",
                    shift = At.Shift.BEFORE),
            locals = LocalCapture.CAPTURE_FAILHARD)
    public void addRandomWeapon(CallbackInfo ci, List items) {
        items.add(new RandomItemListEntry(CreationItem.clubStone, 1));
        items.add(new RandomItemListEntry(CreationItem.daggerStone, 2));
    }

    @Shadow
    public boolean isVillager() {
        return false;
    }
}
