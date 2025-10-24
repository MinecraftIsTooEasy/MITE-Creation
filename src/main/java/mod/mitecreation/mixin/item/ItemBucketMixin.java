package mod.mitecreation.mixin.item;

import mod.mitecreation.init.CTRegistryInit;
import mod.mitecreation.material.CTMaterials;
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
public abstract class ItemBucketMixin extends ItemVessel {

    @Shadow public abstract ItemVessel getPeerForContents(Material material);
    @Shadow public abstract ItemVessel getPeerForVesselMaterial(Material material);

    public ItemBucketMixin(int id, Material vessel_material, Material contents_material, int standard_volume, int max_stack_size_empty, int max_stack_size_full, String texture) {
        super(id, vessel_material, contents_material, standard_volume, max_stack_size_empty, max_stack_size_full, texture);
    }

    @Unique
    private static ItemVessel creationVessels(Material vessel_material, Material contents) {
        if (contents == null) {
            if (vessel_material == CTMaterials.tungsten)
                return CTRegistryInit.tungstenBucket;
            if (vessel_material == Material.wood)
                return CTRegistryInit.woodBucketEmpty;
        } else if (contents == Material.water) {
            if (vessel_material == CTMaterials.tungsten)
                return CTRegistryInit.tungstenBucketWater;
            if (vessel_material == Material.wood)
                return CTRegistryInit.woodBucketWater;
        } else if (contents == Material.lava) {
            if (vessel_material == CTMaterials.tungsten)
                return CTRegistryInit.tungstenBucketLava;
        } else if (contents == Material.milk) {
            if (vessel_material == CTMaterials.tungsten)
                return CTRegistryInit.tungstenBucketMilk;
            if (vessel_material == Material.wood)
                return CTRegistryInit.woodBucketMilk;
        } else if (contents == Material.stone) {
            if (vessel_material == CTMaterials.tungsten)
                return CTRegistryInit.tungstenBucketStone;
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
}
