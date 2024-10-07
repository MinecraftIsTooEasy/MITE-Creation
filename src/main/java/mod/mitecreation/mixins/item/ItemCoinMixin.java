package mod.mitecreation.mixins.item;

import net.minecraft.Item;
import net.minecraft.ItemCoin;
import net.minecraft.Material;
import mod.mitecreation.item.CreationItem;
import mod.mitecreation.material.CreationMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemCoin.class)
public class ItemCoinMixin extends Item {

    @Inject(method = "getExperienceValue", at = @At("HEAD"), cancellable = true)
    private void getExperienceValueCreation(CallbackInfoReturnable<Integer> cir) {
        Material material = this.getExclusiveMaterial();
        if (material == Material.rusted_iron)
            cir.setReturnValue(2);
        if (material == Material.iron)
            cir.setReturnValue(200);
        if (material == CreationMaterial.tungsten)
            cir.setReturnValue(1250);
    }

    @Inject(method = "getForMaterial", at = @At("HEAD"), cancellable = true)
    private static void getForMaterialCreation(Material material, CallbackInfoReturnable<ItemCoin> cir) {
        if (material == Material.rusted_iron)
            cir.setReturnValue(CreationItem.coinRustedIron);
        if (material == Material.iron)
            cir.setReturnValue(CreationItem.coinIron);
        if (material == CreationMaterial.tungsten)
            cir.setReturnValue(CreationItem.coinTungsten);
    }

    @Inject(method = "getNuggetPeer", at = @At("HEAD"), cancellable = true)
    private void getNuggetPeerCreation(CallbackInfoReturnable<Item> cir) {
        Material material = getExclusiveMaterial();
        if (material == Material.rusted_iron)
            cir.setReturnValue(CreationItem.rustedIronNugget);
        if (material == Material.iron)
            cir.setReturnValue(Item.ironNugget);
        if (material == CreationMaterial.tungsten)
            cir.setReturnValue(CreationItem.tungstenNugget);
    }
}