package mod.mitecreation.mixin.item;

import mod.mitecreation.item.Items;
import mod.mitecreation.item.materil.Materials;
import net.minecraft.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

import static net.xiaoyu233.fml.util.ReflectHelper.dyCast;

@Mixin(ItemArrow.class)
public class ItemArrowMixin extends Item {
    @Inject(method = "<clinit>",at = @At("RETURN"))
    private static void injectClinit(CallbackInfo callback) {
        material_types = new Material[]{Material.flint, Material.obsidian, Material.copper, Material.silver, Material.gold, Material.iron, Material.rusted_iron, Material.ancient_metal, Materials.tungsten, Material.mithril, Material.adamantium};
    }
    @Overwrite
    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add("");
            info.add(EnumChatFormat.BLUE + Translator.getFormatted("item.tooltip.missileDamage", new Object[]{(int)this.getMaterialDamageVsEntity()}));
            info.add(EnumChatFormat.GRAY + Translator.getFormatted("item.tooltip.missileRecovery", new Object[]{(int)(this.getChanceOfRecovery() * 100.0F)}));
        }
    }

        public float getChanceOfRecovery () {
            if (dyCast(this) == arrowFlint) {
                return 0.3F;
            } else if (dyCast(this) == Item.arrowObsidian) {
                return 0.4F;
            } else if (dyCast(this) == Item.arrowCopper) {
                return 0.6F;
            } else if (dyCast(this) == Item.arrowSilver) {
                return 0.6F;
            } else if (dyCast(this) == Item.arrowGold) {
                return 0.5F;
            } else if (dyCast(this) == Item.arrowRustedIron) {
                return 0.5F;
            } else if (dyCast(this) == Item.arrowIron) {
                return 0.7F;
            } else if (dyCast(this) == Item.arrowAncientMetal) {
                return 0.8F;
            } else if (dyCast(this) == Items.arrowTungsten) {
                return 0.8F;
            } else if (dyCast(this) == Item.arrowMithril) {
                return 0.8F;
            } else if (dyCast(this) == Item.arrowAdamantium) {
                return 0.9F;
            } else {
                return 0.7F;
            }
        }
    @Shadow
    public float getMaterialDamageVsEntity() {
        if (dyCast(this) == arrowFlint) {
            return 1F;
        } else if (dyCast(this) == Item.arrowObsidian) {
            return 2F;
        } else if (dyCast(this) == Item.arrowCopper) {
            return 3F;
        } else if (dyCast(this) == Item.arrowSilver) {
            return 3F;
        } else if (dyCast(this) == Item.arrowGold) {
            return 2F;
        } else if (dyCast(this) == Item.arrowRustedIron) {
            return 2F;
        } else if (dyCast(this) == Item.arrowIron) {
            return 4F;
        } else if (dyCast(this) == Item.arrowAncientMetal) {
            return 4F;
        } else if (dyCast(this) == Items.arrowTungsten) {
            return 5F;
        } else if (dyCast(this) == Item.arrowMithril) {
            return 5F;
        } else if (dyCast(this) == Item.arrowAdamantium) {
            return 6F;
        } else {
            return 1F;
        }
    }
    @Shadow
    @Final
    @Mutable
    public static Material[] material_types;
    @Shadow
    @Final
    public Material arrowhead_material;

}
