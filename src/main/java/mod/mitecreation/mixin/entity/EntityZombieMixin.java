package mod.mitecreation.mixin.entity;

import mod.mitecreation.item.CreationItem;
import net.minecraft.EntityAnimalWatcher;
import net.minecraft.EntityZombie;
import net.minecraft.Item;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityZombie.class)
public class EntityZombieMixin extends EntityAnimalWatcher {

    public EntityZombieMixin(World par1World) {
        super(par1World);
    }

    @Inject(method = "<clinit>", at = @At("HEAD"))
    private static void rareDropsCreation(CallbackInfo ci) {
        Item[] rare_drops_standard = new Item[]{Item.copperNugget, Item.silverNugget, Item.goldNugget, CreationItem.rustedIronNugget};
    }
}
