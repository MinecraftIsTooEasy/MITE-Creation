package mod.mitecreation.mixin.item;

import net.minecraft.*;
import mod.mitecreation.materil.Materials;
import mod.mitecreation.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
@Mixin(ItemCarrotOnAStick.class)
public class ItemCarrotOnAStickMixin extends Item implements IDamageableItem {
    protected Material hook_material;
    @Shadow
    public int getNumComponentsForDurability() {
        return 0;
    }
    @Overwrite
    public ItemFishingRod getFishingRodItem() {
        if (this.hook_material == Material.flint) {
            return Item.fishingRodFlint;
        } else if (this.hook_material == Material.obsidian) {
            return Item.fishingRodObsidian;
        } else if (this.hook_material == Material.copper) {
            return Item.fishingRodCopper;
        } else if (this.hook_material == Material.silver) {
            return Item.fishingRodSilver;
        } else if (this.hook_material == Material.gold) {
            return Item.fishingRodGold;
        } else if (this.hook_material == Material.iron) {
            return Item.fishingRodIron;
        } else if (this.hook_material == Materials.tungsten) {
            return Items.fishingRodTungsten;
        } else if (this.hook_material == Material.mithril) {
            return Item.fishingRodMithril;
        } else if (this.hook_material == Material.adamantium) {
            return Item.fishingRodAdamantium;
        } else if (this.hook_material == Material.ancient_metal) {
            return Item.fishingRodAncientMetal;
        } else {
            return null;
        }
    }
}
