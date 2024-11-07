package mod.mitecreation.mixin.entity;

import mod.mitecreation.init.RegistryInit;
import net.minecraft.EntityHorse;
import net.minecraft.Item;
import net.minecraft.ItemHorseArmor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityHorse.class)
public class EntityHorseMixin {
    @Shadow
    @Mutable
    private static ItemHorseArmor[] armors = new ItemHorseArmor[0];
    @Shadow
    @Mutable
    private static String[] horseArmorTextures = new String[0];
    @Shadow
    @Mutable
    private static String[] horseTextures = new String[0];
    @Shadow
    @Mutable
    private static String[] field_110269_bA = new String[0];
    @Shadow
    @Mutable
    private static String[] horseMarkingTextures = new String[0];
    @Shadow
    @Mutable
    private static String[] field_110292_bC = new String[0];

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void addCreationHorseArmor(CallbackInfo ci) {
        armors = new ItemHorseArmor[]{null, Item.horseArmorCopper, Item.horseArmorSilver, Item.horseArmorGold, Item.horseArmorIron, Item.horseArmorMithril, Item.horseArmorAdamantium, Item.horseArmorAncientMetal, RegistryInit.horseArmorTungsten};
        horseArmorTextures = new String[armors.length];

        for(int i = 0; i < armors.length; ++i) {
            horseArmorTextures[i] = armors[i] == null ? null : "textures/entity/horse/armor/horse_armor_" + armors[i].effective_material.name + ".png";
        }

        horseTextures = new String[]{"textures/entity/horse/horse_white.png", "textures/entity/horse/horse_creamy.png", "textures/entity/horse/horse_chestnut.png", "textures/entity/horse/horse_brown.png", "textures/entity/horse/horse_black.png", "textures/entity/horse/horse_gray.png", "textures/entity/horse/horse_darkbrown.png"};
        field_110269_bA = new String[]{"hwh", "hcr", "hch", "hbr", "hbl", "hgr", "hdb"};
        horseMarkingTextures = new String[]{null, "textures/entity/horse/horse_markings_white.png", "textures/entity/horse/horse_markings_whitefield.png", "textures/entity/horse/horse_markings_whitedots.png", "textures/entity/horse/horse_markings_blackdots.png"};
        field_110292_bC = new String[]{"", "wo_", "wmo", "wdo", "bdo"};
    }
}
