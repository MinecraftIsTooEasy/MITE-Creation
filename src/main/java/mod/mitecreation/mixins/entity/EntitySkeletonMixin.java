package mod.mitecreation.mixins.entity;

import mod.mitecreation.item.CreationItem;
import net.minecraft.EntitySkeleton;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.xiaoyu233.fml.util.ReflectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(EntitySkeleton.class)
public class EntitySkeletonMixin {

    @Inject(method = "addRandomWeapon", at = @At("TAIL"))
    public void addRandomWeapon(CallbackInfo ci) {
        Random random = new Random();
        if (random.nextInt(4) == 0)
            this.setCurrentItemOrArmor(0, new ItemStack(this.getSkeletonType() == 2 ? CreationItem.clubStone : Item.bow).randomizeForMob(ReflectHelper.dyCast(this), true));
        if (random.nextInt(4) == 0)
            this.setCurrentItemOrArmor(0, new ItemStack(this.getSkeletonType() == 2 ? CreationItem.daggerStone : Item.bow).randomizeForMob(ReflectHelper.dyCast(this), true));
    }

    @Shadow
    public void setCurrentItemOrArmor(int par1, ItemStack par2ItemStack) {
    }

    @Shadow
    public int getSkeletonType() {
        return 0;
    }
}
