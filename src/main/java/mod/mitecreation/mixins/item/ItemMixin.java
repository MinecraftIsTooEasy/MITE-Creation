package mod.mitecreation.mixins.item;

import mod.mitecreation.api.IItem;
import mod.mitecreation.item.CreationItem;
import mod.mitecreation.materil.CreationMaterial;
import net.minecraft.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Item.class)
public abstract class ItemMixin implements IItem {
    @Shadow public static Item reed;

    @Shadow public abstract boolean hasEffect(ItemStack par1ItemStack);

    @Shadow public static Item redstone;
    @Shadow
    @Final
    public int itemID;

    //@Redirect(method="<clinit>",at=@At(value="INVOKE", target="INVOKESTATIC net/minecraft/StatisticList.initStats()V"))
    //private static void injector(CallbackInfo callbackInfo){
    //    StatisticList.initStats();
    //}
    public void useVanillaTexture(String texture) {
        this.setTextureName(texture);
    }

    @Shadow
    protected Item setTextureName(String string) {
        return null;
    }

    @Inject(method = "getRepairItem", at = @At("HEAD"), cancellable = true)
    private void getRepairItemCreation(CallbackInfoReturnable<Item> cir) {
        Material material_for_repairs = this.getMaterialForRepairs();
        Item repairItem = repairItemCreation(material_for_repairs);
        if (repairItem != null) cir.setReturnValue(repairItem);
    }

    @Unique
    private static Item repairItemCreation(Material material_for_repairs) {
        if (material_for_repairs == Material.rusted_iron)
            return CreationItem.rustedIronNugget;
        if (material_for_repairs == CreationMaterial.tungsten)
            return CreationItem.tungstenNugget;
        return null;
    }

    @Shadow
    private Material getMaterialForRepairs() {
        return null;
    }

    @Override
    public int getCookTime(int heat_level) {
        if(this.itemID == CreationItem.rawGoldNugget.itemID) {
            return getCookTimeA(heat_level);
        }
        if(this.itemID == CreationItem.rawSilverNugget.itemID) {
            return getCookTimeA(heat_level);
        }
        if(this.itemID == CreationItem.rawCopperNugget.itemID) {
            return getCookTimeA(heat_level);
        }
        if(this.itemID == CreationItem.rawRustedIronNugget.itemID){
            return getCookTimeB(heat_level);
        }
        if(this.itemID == CreationItem.rustedIronNugget.itemID){
            return getCookTimeB(heat_level);
        }
        if(this.itemID == CreationItem.rawAncientMetalNugget.itemID){
            return getCookTimeB(heat_level);
        }
        if(this.itemID == CreationItem.rawTungstenNugget.itemID){
            return getCookTimeC(heat_level);
        }
        if(this.itemID == CreationItem.rawMithrilNugget.itemID){
            return getCookTimeC(heat_level);
        }
        if(this.itemID == CreationItem.rawAdamantiumNugget.itemID){
            return getCookTimeD(heat_level);
        }
        return this.isBlock() ? 200 * (this.getAsItemBlock().getBlock().getMinHarvestLevel(-1) + 1) : 200;
    }

    @Unique
    public int getCookTimeA(int heat_level){
        return 400 >> heat_level;
    }

    @Unique
    public int getCookTimeB(int heat_level){
        if (heat_level < 2) {
            return -1;
        } else {
            return 800 >> heat_level;
        }
    }

    @Unique
    public int getCookTimeC(int heat_level){
        if (heat_level < 3) {
            return -1;
        } else {
            return 1600 >> heat_level;
        }
    }

    @Unique
    public int getCookTimeD(int heat_level){
        if (heat_level < 4) {
            return -1;
        } else {
            return 3200 >> heat_level;
        }
    }

    @Unique
    public int getCookTimeE(int heat_level){
        if (heat_level < 5) {
            return -1;
        } else {
            return 6400 >> heat_level;
        }
    }

    @Shadow
    public ItemBlock getAsItemBlock() {
        return null;
    }
    @Shadow
    public boolean isBlock() {
        return false;
    }
}
