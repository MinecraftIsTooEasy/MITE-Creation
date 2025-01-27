package mod.mitecreation.mixin.block;

import mod.mitecreation.init.CTRegistryInit;
import mod.mitecreation.item.ItemCTLeaves;
import net.minecraft.Block;
import net.minecraft.Item;
import net.minecraft.ItemSlab;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class BlockMixin {
    @Inject(method = "<clinit>", at = @At(value = "TAIL"))
    private static void creationDoubleSlab(CallbackInfo callback) {
        Item.itemsList[CTRegistryInit.cobbledDeepStaleSingleSlab.blockID] =
                (new ItemSlab(CTRegistryInit.cobbledDeepStaleSingleSlab, CTRegistryInit.cobbledDeepStaleDoubleSlab, false))
                        .setUnlocalizedName("cobbledDeepslateSlab");
        Item.itemsList[CTRegistryInit.cobbledDeepStaleDoubleSlab.blockID] =
                (new ItemSlab(CTRegistryInit.cobbledDeepStaleSingleSlab, CTRegistryInit.cobbledDeepStaleDoubleSlab, true))
                        .setUnlocalizedName("cobbledDeepslateSlab");

        Item.itemsList[CTRegistryInit.deepStaleBrickSingleSlab.blockID] =
                (new ItemSlab(CTRegistryInit.deepStaleBrickSingleSlab, CTRegistryInit.deepStaleBrickDoubleSlab, false))
                        .setUnlocalizedName("deepslateBrickSlab");
        Item.itemsList[CTRegistryInit.deepStaleBrickDoubleSlab.blockID] =
                (new ItemSlab(CTRegistryInit.deepStaleBrickSingleSlab, CTRegistryInit.deepStaleBrickDoubleSlab, true))
                        .setUnlocalizedName("deepslateBrickSlab");

        Item.itemsList[CTRegistryInit.peachPlanksSingleSlab.blockID] =
                (new ItemSlab(CTRegistryInit.peachPlanksSingleSlab, CTRegistryInit.peachPlanksDoubleSlab, false))
                        .setUnlocalizedName("peachWoodSlab");
        Item.itemsList[CTRegistryInit.peachPlanksDoubleSlab.blockID] =
                (new ItemSlab(CTRegistryInit.peachPlanksSingleSlab, CTRegistryInit.peachPlanksDoubleSlab, true))
                        .setUnlocalizedName("peachWoodSlab");

        Item.itemsList[CTRegistryInit.peachLeaves.blockID] = (new ItemCTLeaves(CTRegistryInit.peachLeaves)).setUnlocalizedName("peachLeaves");
    }
}
