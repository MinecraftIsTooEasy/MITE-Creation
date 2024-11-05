package mod.mitecreation.mixins.block;

import mod.mitecreation.init.RegistryInit;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;

@Mixin(value = BlockGravel.class)
public abstract class BlockGravelMixin extends BlockFalling {

    protected BlockGravelMixin(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    @Overwrite
    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        Random rand;
        if (info.getMetadata() == 1) {
            return super.dropBlockAsEntityItem(info);
        }
        if (info.wasExploded() || !info.wasHarvestedByPlayer()) {
            return super.dropBlockAsEntityItem(info);
        }
        int fortune = info.getHarvesterFortune();
        if (fortune > 3) {
            fortune = 3;
        }
        if ((rand = info.world.rand).nextInt(12 - fortune * 2) > 2) {
            return super.dropBlockAsEntityItem(info);
        }
        int id_dropped = -1;
        if (rand.nextInt(3) > 0) {
            if (rand.nextInt(16) == 0) {
                id_dropped = info.wasExploded() ? Item.chipFlint.itemID : Item.flint.itemID;
            } else {
                if (info.wasExploded()) {
                    return super.dropBlockAsEntityItem(info);
                }
                id_dropped = Item.chipFlint.itemID;
            }
        } else {
            id_dropped = rand.nextInt(3) > 0 ? RegistryInit.rawCopperNugget.itemID : (rand.nextInt(3) > 0 ? RegistryInit.rawSilverNugget.itemID : (rand.nextInt(3) > 0 ? RegistryInit.rawGoldNugget.itemID : (rand.nextInt(3) > 0 ? (info.wasExploded() ? -1 : Item.shardObsidian.itemID) : (rand.nextInt(3) > 0 ? (info.wasExploded() ? -1 : Item.shardEmerald.itemID) : (rand.nextInt(3) > 0 ? (info.wasExploded() ? -1 : Item.shardDiamond.itemID) : (rand.nextInt(3) > 0 ? RegistryInit.rawMithrilNugget.itemID : RegistryInit.rawAdamantiumNugget.itemID))))));
        }
        if (this.isNetherGravel(info.getMetadata())) {
            if (id_dropped == RegistryInit.rawCopperNugget.itemID || id_dropped == RegistryInit.rawSilverNugget.itemID || id_dropped == RegistryInit.rawMithrilNugget.itemID || id_dropped == RegistryInit.rawAdamantiumNugget.itemID) {
                id_dropped = RegistryInit.rawGoldNugget.itemID;
            } else if (id_dropped == Item.shardObsidian.itemID || id_dropped == Item.shardEmerald.itemID || id_dropped == Item.shardDiamond.itemID) {
                id_dropped = Item.shardNetherQuartz.itemID;
            }
        }
        if (id_dropped != -1) {
            DedicatedServer.incrementTournamentScoringCounter(info.getResponsiblePlayer(), Item.getItem(id_dropped));
        }
        if (info.wasHarvestedByPlayer() && (id_dropped == Item.chipFlint.itemID || id_dropped == Item.flint.itemID)) {
            info.getResponsiblePlayer().triggerAchievement(AchievementList.flintFinder);
        }
        return this.dropBlockAsEntityItem(info, id_dropped);
    }

    @Shadow
    public abstract boolean isNetherGravel(int metadata);
}
