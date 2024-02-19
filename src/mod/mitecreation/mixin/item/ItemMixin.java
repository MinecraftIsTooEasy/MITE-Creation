package mod.mitecreation.mixin.item;

import mod.mitecreation.item.Items;
import mod.mitecreation.item.materil.Materials;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value=Item.class)
public class ItemMixin {
    @Shadow
    @Final
    private int itemID;
    
    //@Redirect(method="<clinit>",at=@At(value="INVOKE", target="INVOKESTATIC net/minecraft/StatisticList.initStats()V"))
    //private static void injector(CallbackInfo callbackInfo){
    //    StatisticList.initStats();
    //}
    public void setResourceLocation(String string) {
        this.setTextureName(string);
    }
    @Shadow
    public Item setTextureName(String string) {
        return null;
    }
    @Overwrite
    public Item getRepairItem() {
        Material material = this.getMaterialForRepairs();
        if(material == Material.rusted_iron){
            return Items.rustedIronNugget;
        }
        if (material == Material.copper) {
            return Item.copperNugget;
        }
        if (material == Material.silver) {
            return Item.silverNugget;
        }
        if (material == Material.gold) {
            return Item.goldNugget;
        }
        if (material != Material.iron) {
            if (material == Materials.tungsten) {
                return Items.tungstenNugget;
            }
            if (material == Material.mithril) {
                return Item.mithrilNugget;
            }
            if (material == Material.adamantium) {
                return Item.adamantiumNugget;
            }
            if (material == Material.ancient_metal) {
                return Item.ancientMetalNugget;
            }
        }
        return Item.ironNugget;
    }
    @Shadow
    private Material getMaterialForRepairs() {
        return null;
    }
    public int getCookTime(int heat_level) {
        if(this.itemID == Items.rawGoldNugget.itemID) {
            return getCookTimeA(heat_level);
        }
        if(this.itemID == Items.rawSilverNugget.itemID) {
            return getCookTimeA(heat_level);
        }
        if(this.itemID == Items.rawCopperNugget.itemID) {
            return getCookTimeA(heat_level);
        }
        if(this.itemID == Items.rustedIronNugget.itemID){
            return getCookTimeA(heat_level);
        }
        if(this.itemID == Items.rawAncientMetalNugget.itemID){
            return getCookTimeB(heat_level);
        }
        if(this.itemID == Items.rawMithrilNugget.itemID){
            return getCookTimeB(heat_level);
        }
        if(this.itemID == Items.rawAdamantiumNugget.itemID){
            return getCookTimeC(heat_level);
        }
        return this.isBlock() ? 200 * (this.getAsItemBlock().getBlock().getMinHarvestLevel(-1) + 1) : 200;
    }
    public int getCookTimeA(int heat_level){
        if(heat_level == 1){
            return 400;
        } else if (heat_level == 2) {
            return 200;
        } else if (heat_level == 3) {
            return 100;
        } else if (heat_level == 4) {
            return 25;
        }
        return -1;
    }
    public int getCookTimeB(int heat_level){
        if(heat_level == 1){
            return -1;
        } else if (heat_level == 2) {
            return 400;
        } else if (heat_level == 3) {
            return 200;
        } else if (heat_level == 4) {
            return 100;
        }
        return -1;
    }
    public int getCookTimeC(int heat_level){
        if(heat_level == 1){
            return -1;
        } else if (heat_level == 2) {
            return -1;
        } else if (heat_level == 3) {
            return 400;
        } else if (heat_level == 4) {
            return 200;
        }
        return -1;
    }
    @Shadow
    public ItemBlock getAsItemBlock() {
        return null;
    }
    @Shadow
    private boolean isBlock() {
        return false;
    }
}
