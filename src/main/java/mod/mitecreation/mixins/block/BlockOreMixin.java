package mod.mitecreation.mixins.block;

import mod.mitecreation.block.CreationBlock;
import mod.mitecreation.item.CreationItem;
import net.minecraft.*;
import java.util.Random;

import org.spongepowered.asm.mixin.*;

@Mixin(value=BlockOre.class)
public class BlockOreMixin extends Block {

    protected BlockOreMixin(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    @Overwrite
    public int dropBlockAsEntityItem(BlockBreakInfo blockBreakInfo) {
        Random random = new Random();
        boolean suppress_fortune;
        int id_dropped;
        int metadata_dropped = 0;
        int quantity_dropped = 1;
        if (blockBreakInfo.wasExploded()) {
            if (this == oreEmerald) {
                id_dropped = Item.shardEmerald.itemID;
            } else if (this == oreDiamond) {
                id_dropped = Item.shardDiamond.itemID;
            } else if (this == oreLapis) {
                id_dropped = Item.dyePowder.itemID;
                metadata_dropped = 4;
                quantity_dropped = 3 + blockBreakInfo.world.rand.nextInt(3);
            } else {
                id_dropped = this == oreNetherQuartz ? Item.shardNetherQuartz.itemID : (this == oreCoal ? -1 : this.blockID);
            }
        } else {
            //if (blockBreakInfo.wasHarvestedByPlayer() && blockBreakInfo.getResponsiblePlayer().worldObj.areSkillsEnabled() && !blockBreakInfo.getResponsiblePlayer().hasSkill(Skill.MINING)) {
            //    return super.dropBlockAsEntityItem(blockBreakInfo);
            //}
            if (!blockBreakInfo.wasHarvestedByPlayer()) {
                return super.dropBlockAsEntityItem(blockBreakInfo);
            }
            if (this == oreCoal) {
                id_dropped = Item.coal.itemID;
            } else if (this == oreDiamond) {
                id_dropped = Item.diamond.itemID;
            } else if (this == oreLapis) {
                id_dropped = Item.dyePowder.itemID;
                metadata_dropped = 4;
                quantity_dropped = 3 + blockBreakInfo.world.rand.nextInt(3);
            } else {
                id_dropped = this == oreEmerald ? Item.emerald.itemID : (this == oreNetherQuartz ? Item.netherQuartz.itemID : this.blockID);
            }
            if (this == oreCopper) {
                id_dropped = CreationItem.rawCopperNugget.itemID;
                quantity_dropped = 7 + random.nextInt(3) + random.nextInt(3);
            } else if (this == oreIron) {
                id_dropped = CreationItem.rawRustedIronNugget.itemID;
                quantity_dropped = 7 + random.nextInt(3) + random.nextInt(3);
            } else if (this == oreSilver) {
                id_dropped = CreationItem.rawSilverNugget.itemID;
                quantity_dropped = 7 + random.nextInt(3) + random.nextInt(3);
            } else if (this == oreGold) {
                id_dropped = CreationItem.rawGoldNugget.itemID;
                quantity_dropped = 7 + random.nextInt(3) + random.nextInt(3);
            } else if (this == CreationBlock.oreTungsten) {
                id_dropped = CreationItem.rawTungstenNugget.itemID;
                quantity_dropped = 7 + random.nextInt(3) + random.nextInt(3);
            } else if (this == oreMithril) {
                id_dropped = CreationItem.rawMithrilNugget.itemID;
                quantity_dropped = 7 + random.nextInt(3) + random.nextInt(3);
            } else if (this == oreAdamantium) {
                id_dropped = CreationItem.rawAdamantiumNugget.itemID;
                quantity_dropped = 7 + random.nextInt(3) + random.nextInt(3);
            }
        }
        //if (metadata_dropped == -1) {
        //    metadata_dropped = id_dropped == this.blockID ? this.getItemSubtype(blockBreakInfo.getMetadata()) : 0;
        //}
        //boolean bl2 = suppress_fortune = id_dropped == this.blockID && BitHelper.isBitSet(blockBreakInfo.getMetadata(), 1);
        //if (id_dropped != -1 && blockBreakInfo.getMetadata() == 0) {
        //    DedicatedServer.incrementTournamentScoringCounter(blockBreakInfo.getResponsiblePlayer(), Item.getItem(id_dropped));
        //}
        return super.dropBlockAsEntityItem(blockBreakInfo, id_dropped, metadata_dropped, quantity_dropped, 1);
    }
}
