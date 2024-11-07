package mod.mitecreation.mixin.entity;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import mod.mitecreation.init.RegistryInit;
import mod.mitecreation.util.EntityZombieDropHelper;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

@Mixin(EntityZombie.class)
public class EntityZombieMixin extends EntityAnimalWatcher {

    public EntityZombieMixin(World par1World) {
        super(par1World);
    }

    @ModifyExpressionValue(
            method = "dropFewItems",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/EntityZombie;rare_drops_standard:[Lnet/minecraft/Item;"
            ))
    private Item[] dropRawNuggets(Item[] original) {
        return EntityZombieDropHelper.rare_drops_standard;
    }

    @Inject(
            method = "addRandomWeapon",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/WeightedRandom;getRandomItem(Ljava/util/Random;Ljava/util/Collection;)Lnet/minecraft/WeightedRandomItem;",
                    shift = At.Shift.BEFORE),
            locals = LocalCapture.CAPTURE_FAILHARD)
    public void addRandomWeapon(CallbackInfo ci, List items) {
        items.add(new RandomItemListEntry(RegistryInit.clubStone, 1));
        items.add(new RandomItemListEntry(RegistryInit.daggerStone, 2));
    }

}
