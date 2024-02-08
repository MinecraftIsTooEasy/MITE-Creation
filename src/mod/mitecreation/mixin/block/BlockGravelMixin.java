package mod.mitecreation.mixin.block;

import mod.mitecreation.item.Items;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import mod.mitecreation.block.Blocks;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;

@Mixin(value= BlockGravel.class)
public class BlockGravelMixin extends Block{

    protected BlockGravelMixin(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material,constants);
    }

    @Overwrite
    public int dropBlockAsEntityItem(BlockBreakInfo blockBreakInfo) {
        Random random;
        if (blockBreakInfo.getMetadata() == 1) {
            return super.dropBlockAsEntityItem(blockBreakInfo);
        }
        if (blockBreakInfo.wasExploded() || !blockBreakInfo.wasHarvestedByPlayer()) {
            return super.dropBlockAsEntityItem(blockBreakInfo);
        }
        int n = blockBreakInfo.getHarvesterFortune();
        if (n > 3) {
            n = 3;
        }
        if ((random = blockBreakInfo.world.rand).nextInt(12 - n * 2) > 2) {
            return super.dropBlockAsEntityItem(blockBreakInfo);
        }
        int n2 = -1;
        if (random.nextInt(3) > 0) {
            if (random.nextInt(16) == 0) {
                n2 = blockBreakInfo.wasExploded() ? Item.chipFlint.itemID : Item.flint.itemID;
            } else {
                if (blockBreakInfo.wasExploded()) {
                    return super.dropBlockAsEntityItem(blockBreakInfo);
                }
                n2 = Item.chipFlint.itemID;
            }
        } else {
            n2 = random.nextInt(3) > 0 ? Items.rawCopperNugget.itemID : (random.nextInt(3) > 0 ? Items.rawSilverNugget.itemID : (random.nextInt(3) > 0 ? Items.rawGoldNugget.itemID : (random.nextInt(3) > 0 ? Items.rawGoldNugget.itemID : (random.nextInt(3) > 0 ? (blockBreakInfo.wasExploded() ? -1 : Item.shardObsidian.itemID) : (random.nextInt(3) > 0 ? (blockBreakInfo.wasExploded() ? -1 : Item.shardEmerald.itemID) : (random.nextInt(3) > 0 ? (blockBreakInfo.wasExploded() ? -1 : Item.shardDiamond.itemID) : (random.nextInt(3) > 0 ? Items.rawMithrilNugget.itemID : Items.rawAdamantiumNugget.itemID)))))));
        }
        if (this.isNetherGravel(blockBreakInfo.getMetadata())) {
            if (n2 == Item.copperNugget.itemID || n2 == Item.silverNugget.itemID || n2 == Item.mithrilNugget.itemID || n2 == Item.adamantiumNugget.itemID) {
                n2 = Item.goldNugget.itemID;
            } else if (n2 == Item.shardObsidian.itemID || n2 == Item.shardEmerald.itemID || n2 == Item.shardDiamond.itemID) {
                n2 = Item.shardNetherQuartz.itemID;
            }
        }
        if (n2 != -1) {
            DedicatedServer.incrementTournamentScoringCounter(blockBreakInfo.getResponsiblePlayer(), Item.getItem(n2));
        }
        if (blockBreakInfo.wasHarvestedByPlayer() && (n2 == Item.chipFlint.itemID || n2 == Item.flint.itemID)) {
            blockBreakInfo.getResponsiblePlayer().triggerAchievement(AchievementList.flintFinder);
        }
        return this.dropBlockAsEntityItem(blockBreakInfo, n2);
    }
    @Shadow
    private boolean isNetherGravel(int metadata) {
        return false;
    }
}
