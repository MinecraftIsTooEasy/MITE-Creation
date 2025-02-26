package mod.mitecreation.mixin.block;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalIntRef;
import mod.mitecreation.init.CTRegistryInit;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BlockOre.class, priority = 2000)
public class BlockOreMixin extends Block {

    protected BlockOreMixin(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    @Inject(method = "dropBlockAsEntityItem", at = @At(value = "FIELD", target = "Lnet/minecraft/BlockOre;blockID:I", ordinal = 2))
    private void changeDrop(BlockBreakInfo info, CallbackInfoReturnable<Integer> cir, @Local(ordinal = 0) LocalIntRef id_dropped, @Local(ordinal = 2) LocalIntRef quantity_dropped) {
        if (info.wasExploded()) {
            int rawNuggetID = this.oreDropRawNuggetID(info.getMetadata());
            if (rawNuggetID != 0) {
                id_dropped.set(rawNuggetID);
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
        if (this == Block.oreCopper) return CTRegistryInit.rawCopperNugget.itemID;
        if (this == Block.oreSilver) return CTRegistryInit.rawSilverNugget.itemID;
        if (this == Block.oreIron) return CTRegistryInit.rawRustedIronNugget.itemID;
        if (this == Block.oreGold) return CTRegistryInit.rawGoldNugget.itemID;
        if (this == Block.oreMithril) return CTRegistryInit.rawMithrilNugget.itemID;
        if (this == Block.oreAdamantium) return CTRegistryInit.rawAdamantiumNugget.itemID;
        if (this == Block.oreNetherQuartz) return Item.shardNetherQuartz.itemID;
        if (this == Block.oreDiamond) return Item.shardDiamond.itemID;
        if (this == Block.oreEmerald) return Item.shardEmerald.itemID;
        if (this == CTRegistryInit.oreTungsten) return CTRegistryInit.rawTungstenNugget.itemID;
        return 0;
    }

    @ModifyExpressionValue(method = "dropBlockAsEntityItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/BlockBreakInfo;getHarvesterFortune()I"))
    private int moreFortuneCreation(int original) {
        return (int) (original  * 3.0F);
    }

}
