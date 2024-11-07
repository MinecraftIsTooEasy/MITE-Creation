package mod.mitecreation.mixin.block;

import mod.mitecreation.init.RegistryInit;
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
        Item.itemsList[RegistryInit.cobbledDeepStaleSingleSlab.blockID] =
                (new ItemSlab(RegistryInit.cobbledDeepStaleSingleSlab, RegistryInit.cobbledDeepStaleDoubleSlab, false))
                        .setUnlocalizedName("cobbledDeepslateSlab");
        Item.itemsList[RegistryInit.cobbledDeepStaleDoubleSlab.blockID] =
                (new ItemSlab(RegistryInit.cobbledDeepStaleSingleSlab, RegistryInit.cobbledDeepStaleDoubleSlab, true))
                        .setUnlocalizedName("cobbledDeepslateSlab");

        Item.itemsList[RegistryInit.deepStaleBrickSingleSlab.blockID] =
                (new ItemSlab(RegistryInit.deepStaleBrickSingleSlab, RegistryInit.deepStaleBrickDoubleSlab, false))
                        .setUnlocalizedName("deepslateBrickSlab");
        Item.itemsList[RegistryInit.deepStaleBrickDoubleSlab.blockID] =
                (new ItemSlab(RegistryInit.deepStaleBrickSingleSlab, RegistryInit.deepStaleBrickDoubleSlab, true))
                        .setUnlocalizedName("deepslateBrickSlab");
    }
}
