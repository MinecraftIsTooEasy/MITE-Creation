package mod.mitecreation.mixin.item;

import mod.mitecreation.init.RegistryInit;
import mod.mitecreation.material.CreationMaterials;
import net.minecraft.ItemBucket;
import net.minecraft.ItemVessel;
import net.minecraft.Material;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemBucket.class)
public class ItemBucketMixin extends ItemVessel {

    public ItemBucketMixin(int id, Material vessel_material, Material contents_material, int standard_volume, int max_stack_size_empty, int max_stack_size_full, String texture) {
        super(id, vessel_material, contents_material, standard_volume, max_stack_size_empty, max_stack_size_full, texture);
    }

    @Unique
    private static ItemVessel creationVessels(Material vessel_material, Material contents) {
        if (contents == null) {
            if (vessel_material == CreationMaterials.tungsten)
                return RegistryInit.tungstenBucket;
            if (vessel_material == Material.wood)
                return RegistryInit.woodBucketEmpty;
        } else if (contents == Material.water) {
            if (vessel_material == CreationMaterials.tungsten)
                return RegistryInit.tungstenBucketWater;
            if (vessel_material == Material.wood)
                return RegistryInit.woodBucketWater;
        } else if (contents == Material.lava) {
            if (vessel_material == CreationMaterials.tungsten)
                return RegistryInit.tungstenBucketLava;
        } else if (contents == Material.milk) {
            if (vessel_material == CreationMaterials.tungsten)
                return RegistryInit.tungstenBucketMilk;
            if (vessel_material == Material.wood)
                return RegistryInit.woodBucketMilk;
        } else if (contents == Material.stone) {
            if (vessel_material == CreationMaterials.tungsten)
                return RegistryInit.tungstenBucketStone;
        }
        return null;
    }

    @Inject(method = "getPeer", at = @At("HEAD"), cancellable = true)
    private static void getPeerCreation(Material vessel_material, Material contents, CallbackInfoReturnable<ItemVessel> cir) {
        ItemVessel creationVessels = creationVessels(vessel_material, contents);
        if (creationVessels != null) {
            cir.setReturnValue(creationVessels);
        }
    }

    @Inject(method = "getChanceOfMeltingWhenFilledWithLava", at = @At("HEAD"), cancellable = true)
    private void getChanceOfMeltingWhenFilledWithLavaCreation(CallbackInfoReturnable<Float> cir) {
        if (this.getVesselMaterial() == Material.rusted_iron) {
            cir.setReturnValue(0.24F);
        }
    }

    @Shadow
    public ItemVessel getPeerForContents(Material material) {
        return null;
    }
    @Shadow
    public ItemVessel getPeerForVesselMaterial(Material material) {
        return null;
    }

}
