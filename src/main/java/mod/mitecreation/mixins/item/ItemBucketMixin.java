package mod.mitecreation.mixins.item;

import mod.mitecreation.item.CreationItem;
import mod.mitecreation.materil.CreationMaterial;
import net.minecraft.*;
import org.spongepowered.asm.mixin.*;
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
            if (vessel_material == CreationMaterial.tungsten)
                return CreationItem.tungstenBucket;
            if (vessel_material == Material.wood)
                return CreationItem.woodBucketEmpty;
        } else if (contents == Material.water) {
            if (vessel_material == CreationMaterial.tungsten)
                return CreationItem.tungstenBucketWater;
            if (vessel_material == Material.wood)
                return CreationItem.woodBucketWater;
        } else if (contents == Material.lava) {
            if (vessel_material == CreationMaterial.tungsten)
                return CreationItem.tungstenBucketLava;
        } else if (contents == Material.milk) {
            if (vessel_material == CreationMaterial.tungsten)
                return CreationItem.tungstenBucketMilk;
            if (vessel_material == Material.wood)
                return CreationItem.woodBucketMilk;
        } else if (contents == Material.stone) {
            if (vessel_material == CreationMaterial.tungsten)
                return CreationItem.tungstenBucketStone;
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
