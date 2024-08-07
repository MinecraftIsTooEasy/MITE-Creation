package mod.mitecreation.mixins.block;

import mod.mitecreation.block.CreationBlock;
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
        Item.itemsList[CreationBlock.cobbledDeepStaleSingleSlab.blockID] =
                (new ItemSlab(CreationBlock.cobbledDeepStaleSingleSlab, CreationBlock.cobbledDeepStaleDoubleSlab, false))
                        .setUnlocalizedName("cobbledDeepslateSlab");
        Item.itemsList[CreationBlock.cobbledDeepStaleDoubleSlab.blockID] =
                (new ItemSlab(CreationBlock.cobbledDeepStaleSingleSlab, CreationBlock.cobbledDeepStaleDoubleSlab, true))
                        .setUnlocalizedName("cobbledDeepslateSlab");

        Item.itemsList[CreationBlock.deepStaleBrickSingleSlab.blockID] =
                (new ItemSlab(CreationBlock.deepStaleBrickSingleSlab, CreationBlock.deepStaleBrickDoubleSlab, false))
                        .setUnlocalizedName("deepslateBrickSlab");
        Item.itemsList[CreationBlock.deepStaleBrickDoubleSlab.blockID] =
                (new ItemSlab(CreationBlock.deepStaleBrickSingleSlab, CreationBlock.deepStaleBrickDoubleSlab, true))
                        .setUnlocalizedName("deepslateBrickSlab");
    }
}
