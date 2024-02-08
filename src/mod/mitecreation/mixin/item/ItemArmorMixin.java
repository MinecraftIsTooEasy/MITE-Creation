package mod.mitecreation.mixin.item;

import mod.mitecreation.item.materil.Materials;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemArmor.class)
public abstract class ItemArmorMixin extends Item implements IDamageableItem {
    protected Material effective_material;
    @Mutable
    @Final
    private final boolean is_chain_mail;
    public ItemArmorMixin(int par1, Material material, int par4, boolean is_chain_mail, boolean isChainMail) {
        super(par1, material, (String)null);
        this.effective_material = material;
        this.is_chain_mail = isChainMail;
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeModeTab.tabCombat);
    }
        @Overwrite
        public int getMaterialProtection() {
        int protection;
        if (this.effective_material == Material.leather) {
            protection = 2;
        } else if (this.effective_material != Material.rusted_iron && this.effective_material != Material.gold) {
            if (this.effective_material != Material.copper && this.effective_material != Material.silver) {
                if (this.effective_material == Materials.tungsten) {
                    protection = 9;
                } else if (this.effective_material != Material.iron && this.effective_material != Material.ancient_metal) {
                    if (this.effective_material == Material.mithril) {
                        protection = 9;
                    } else {
                        if (this.effective_material != Material.adamantium) {
                            return 0;
                        }

                        protection = 10;
                    }
                } else {
                    protection = 8;
                }
            } else {
                protection = 7;
            }
        } else {
            protection = 6;
        }

        if (this.is_chain_mail) {
            protection -= 2;
        }

        return protection;
    }
}

