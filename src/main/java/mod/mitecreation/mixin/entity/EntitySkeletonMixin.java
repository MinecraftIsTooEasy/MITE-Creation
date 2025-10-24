package mod.mitecreation.mixin.entity;

import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.EntitySkeleton;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(EntitySkeleton.class)
public abstract class EntitySkeletonMixin {

    @Shadow public abstract void setCurrentItemOrArmor(int par1, ItemStack par2ItemStack);
    @Shadow public abstract int getSkeletonType();

    @Inject(method = "addRandomWeapon", at = @At("TAIL"))
    public void addRandomWeapon(CallbackInfo ci) {
        Random random = new Random();
        if (random.nextInt(4) == 0)
            this.setCurrentItemOrArmor(0, new ItemStack(this.getSkeletonType() == 2 ? CTRegistryInit.clubStone : Item.bow).randomizeForMob(ReflectHelper.dyCast(this), false));
        if (random.nextInt(4) == 0)
            this.setCurrentItemOrArmor(0, new ItemStack(this.getSkeletonType() == 2 ? CTRegistryInit.daggerStone : Item.bow).randomizeForMob(ReflectHelper.dyCast(this), false));
    }
}
