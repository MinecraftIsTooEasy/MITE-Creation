package mod.mitecreation.mixin.item;

import com.google.common.collect.Multimap;
import mod.mitecreation.material.CTMaterials;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.ArrayList;
import java.util.List;

@Mixin(ItemStack.class)
public class ItemStackMixin {
    @Inject(method = "getTooltip", at = @At(value = "INVOKE", target = "Lnet/minecraft/ItemTool;getToolMaterial()Lnet/minecraft/Material;"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void addPeachWoodUndeadBonus(EntityPlayer par1EntityPlayer, boolean par2, Slot slot, CallbackInfoReturnable<List> cir, ArrayList var3, Item var4, String var5, boolean is_map, Multimap var16, ItemTool tool) {
        if (par2 && var4 instanceof ItemTool && (tool = (ItemTool) var4).getToolMaterial() == CTMaterials.peachWood) {
            var3.add((EnumChatFormatting.WHITE) + Translator.get("item.tooltip.bonusVsUndead"));
        }
    }
}
