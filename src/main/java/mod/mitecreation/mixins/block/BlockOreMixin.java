package mod.mitecreation.mixins.block;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalIntRef;
import mod.mitecreation.block.CreationBlock;
import mod.mitecreation.item.CreationItem;
import net.minecraft.*;
import java.util.Random;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value=BlockOre.class)
public class BlockOreMixin extends Block {

    protected BlockOreMixin(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    @Inject(method = "dropBlockAsEntityItem", at = @At(value = "FIELD", target = "Lnet/minecraft/BlockOre;blockID:I", ordinal = 2))
    private void changeDrop(BlockBreakInfo info, CallbackInfoReturnable<Integer> cir, @Local(ordinal = 0) LocalIntRef id_dropped, @Local(ordinal = 2) LocalIntRef quantity_dropped) {
        if (info.wasExploded()) {
            int pieceID = this.oreDropRawNuggetID(info.getMetadata());
            if (pieceID != 0) {
                id_dropped.set(pieceID);
                quantity_dropped.set(1 + info.world.rand.nextInt(2));
            }
            return;
        }
        int rawNuggetID = this.oreDropRawNuggetID(info.getMetadata());
        if (rawNuggetID != 0) {
            id_dropped.set(rawNuggetID);
            quantity_dropped.set(7 + info.world.rand.nextInt(4));
        }
    }

    @Unique
    private int oreDropRawNuggetID(int metadata) {
        if (this == Block.oreCopper) return CreationItem.rawCopperNugget.itemID;
        if (this == Block.oreSilver) return CreationItem.rawSilverNugget.itemID;
        if (this == Block.oreIron) return CreationItem.rawRustedIronNugget.itemID;
        if (this == Block.oreGold) return CreationItem.rawGoldNugget.itemID;
        if (this == Block.oreMithril) return CreationItem.rawMithrilNugget.itemID;
        if (this == Block.oreAdamantium) return CreationItem.rawAdamantiumNugget.itemID;
        if (this == Block.oreNetherQuartz) return Item.shardNetherQuartz.itemID;
        if (this == Block.oreDiamond) return Item.shardDiamond.itemID;
        if (this == Block.oreEmerald) return Item.shardEmerald.itemID;
        if (this == CreationBlock.oreTungsten) return CreationItem.rawTungstenNugget.itemID;
        return 0;
    }

//    @ModifyConstant(method = "dropBlockAsEntityItem", constant = @Constant(floatValue = 0.1f))
//    private float moreFortune(float constant) {
//        return constant * 2.0f;
//    }
}
