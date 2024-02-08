package mod.mitecreation.mixin.block;

import mod.mitecreation.item.Items;
import net.minecraft.*;
import java.util.Random;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value=BlockOre.class)
public class BlockOreMixin extends Block{
    public int richOrPoor;
    
    protected BlockOreMixin(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }
    public Block setResourceLocation(String string) {
        return this.setTextureName(string);
    }
    
    public int dropBlockAsEntityItem(BlockBreakInfo blockBreakInfo) {
        boolean bl;
        int n;
        int n2 = -1;
        int n3 = 1;
        if (blockBreakInfo.wasExploded()) {
            if (this == oreEmerald) {
                n = Item.shardEmerald.itemID;
            } else if (this == oreDiamond) {
                n = Item.shardDiamond.itemID;
            } else if (this == oreLapis) {
                n = Item.dyePowder.itemID;
                n2 = 4;
                n3 = 3 + blockBreakInfo.world.rand.nextInt(3);
            } else {
                n = this == oreNetherQuartz ? Item.shardNetherQuartz.itemID : (this == oreCoal ? -1 : this.blockID);
            }
        } else {
            if (blockBreakInfo.wasHarvestedByPlayer() && blockBreakInfo.getResponsiblePlayer().worldObj.areSkillsEnabled() && !blockBreakInfo.getResponsiblePlayer().hasSkill(Skill.MINING)) {
                return super.dropBlockAsEntityItem(blockBreakInfo);
            }
            if (this == oreCoal) {
                n = Item.coal.itemID;
            } else if (this == oreDiamond) {
                n = Item.diamond.itemID;
            } else if (this == oreLapis) {
                n = Item.dyePowder.itemID;
                n2 = 4;
                n3 = 3 + blockBreakInfo.world.rand.nextInt(3);
            } else {
                n = this == oreEmerald ? Item.emerald.itemID : (this == oreNetherQuartz ? Item.netherQuartz.itemID : this.blockID);
            }
            if(this == oreCopper){
                if(((BlockOre)oreCopper).richOrPoor == 1){
                    n = Items.rawCopperNugget.itemID;
                    n3 = 7 + new Random().nextInt(3) + new Random().nextInt(3);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 2) {
                    n = Items.rawCopperNugget.itemID;
                    n3 = 14 + new Random().nextInt(5) + new Random().nextInt(5);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 0) {
                    n = Items.rawCopperNugget.itemID;
                    n3 = 3 + new Random().nextInt(2) + new Random().nextInt(2);
                }
            }else if(this == oreIron){
                if(((BlockOre)oreIron).richOrPoor == 1){
                    n = Items.rustedIronNugget.itemID;
                    n3 = 7 + new Random().nextInt(3) + new Random().nextInt(3);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 2) {
                    n = Items.rustedIronNugget.itemID;
                    n3 = 14 + new Random().nextInt(5) + new Random().nextInt(5);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 0) {
                    n = Items.rustedIronNugget.itemID;
                    n3 = 3 + new Random().nextInt(2) + new Random().nextInt(2);
                }
            }else if(this == oreSilver){
                if(((BlockOre)oreSilver).richOrPoor == 1){
                    n = Items.rawSilverNugget.itemID;
                    n3 = 7 + new Random().nextInt(3) + new Random().nextInt(3);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 2) {
                    n = Items.rawSilverNugget.itemID;
                    n3 = 14 + new Random().nextInt(5) + new Random().nextInt(5);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 0) {
                    n = Items.rawSilverNugget.itemID;
                    n3 = 3 + new Random().nextInt(2) + new Random().nextInt(2);
                }
            }else if(this == oreGold){
                if(((BlockOre)oreGold).richOrPoor == 1){
                    n = Items.rawGoldNugget.itemID;
                    n3 = 7 + new Random().nextInt(3) + new Random().nextInt(3);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 2) {
                    n = Items.rawGoldNugget.itemID;
                    n3 = 14 + new Random().nextInt(5) + new Random().nextInt(5);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 0) {
                    n = Items.rawGoldNugget.itemID;
                    n3 = 3 + new Random().nextInt(2) + new Random().nextInt(2);
                }
            }else if(this == oreMithril){
                if(((BlockOre)oreMithril).richOrPoor == 1){
                    n = Items.rawMithrilNugget.itemID;
                    n3 = 7 + new Random().nextInt(3) + new Random().nextInt(3);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 2) {
                    n = Items.rawMithrilNugget.itemID;
                    n3 = 14 + new Random().nextInt(5) + new Random().nextInt(5);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 0) {
                    n = Items.rawMithrilNugget.itemID;
                    n3 = 3 + new Random().nextInt(2) + new Random().nextInt(2);
                }
            }else if(this == oreAdamantium){
                if(((BlockOre)oreAdamantium).richOrPoor == 1){
                    n = Items.rawAdamantiumNugget.itemID;
                    n3 = 7 + new Random().nextInt(3) + new Random().nextInt(3);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 2) {
                    n = Items.rawAdamantiumNugget.itemID;
                    n3 = 14 + new Random().nextInt(5) + new Random().nextInt(5);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 0) {
                    n = Items.rawAdamantiumNugget.itemID;
                    n3 = 3 + new Random().nextInt(2) + new Random().nextInt(2);
                }
            }
        }
        if (n2 == -1) {
            n2 = n == this.blockID ? this.getItemSubtype(blockBreakInfo.getMetadata()) : 0;
        }
        boolean bl2 = bl = n == this.blockID && BitHelper.isBitSet(blockBreakInfo.getMetadata(), 1);
        if (n != -1 && blockBreakInfo.getMetadata() == 0) {
            DedicatedServer.incrementTournamentScoringCounter(blockBreakInfo.getResponsiblePlayer(), Item.getItem(n));
        }
        float f = bl ? 1.0f : 1.0f + (float)blockBreakInfo.getHarvesterFortune() * 0.1f;
        return super.dropBlockAsEntityItem(blockBreakInfo, n, n2, n3, f);
    }
    
    public Block setTextureName(String string) {
        if((Block)this instanceof BlockOre){
            if(this.richOrPoor == 0){
                this.textureName = "poor_" + string;
            } else if (this.richOrPoor == 2) {
                this.textureName = "rich_" + string;
            }
        }
        this.textureName = string;
        return this;
    }
}
