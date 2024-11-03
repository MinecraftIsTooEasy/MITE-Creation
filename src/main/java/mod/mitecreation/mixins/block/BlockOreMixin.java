package mod.mitecreation.mixins.block;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalIntRef;
import mod.mitecreation.init.RegistryInit;
import net.minecraft.*;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;
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
        if (this == Block.oreCopper) return RegistryInit.rawCopperNugget.itemID;
        if (this == Block.oreSilver) return RegistryInit.rawSilverNugget.itemID;
        if (this == Block.oreIron) return RegistryInit.rawRustedIronNugget.itemID;
        if (this == Block.oreGold) return RegistryInit.rawGoldNugget.itemID;
        if (this == Block.oreMithril) return RegistryInit.rawMithrilNugget.itemID;
        if (this == Block.oreAdamantium) return RegistryInit.rawAdamantiumNugget.itemID;
        if (this == Block.oreNetherQuartz) return Item.shardNetherQuartz.itemID;
        if (this == Block.oreDiamond) return Item.shardDiamond.itemID;
        if (this == Block.oreEmerald) return Item.shardEmerald.itemID;
        if (this == RegistryInit.oreTungsten) return RegistryInit.rawTungstenNugget.itemID;
        return 0;
    }

    @ModifyExpressionValue(method = "dropBlockAsEntityItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/BlockBreakInfo;getHarvesterFortune()I"))
    private int moreFortuneCreation(int original) {
        return (int) (original  * 3.0F);
    }
}
