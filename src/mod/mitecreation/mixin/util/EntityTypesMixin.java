package mod.mitecreation.mixin.util;

import mod.mitecreation.Entity.EntitySpirit;
import net.minecraft.Entity;
import net.minecraft.EntityTypes;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityTypes.class)
public class EntityTypesMixin {
    @Shadow
    public static void addMapping(Class par0Class, String par1Str, int par2) {
    }

    @Shadow
    private static void addMapping(Class par0Class, String par1Str, int par2, int par3, int par4) {
    }

    @Shadow
    public static Entity createEntityByID(int par0, World par1World) {
        return null;
    }

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void injectClinit(CallbackInfo callbackInfo) {
        addMapping(EntitySpirit.class, "EntitySpirit", 542, 0xFFFFFFF, 0xFFAD0000);
    }
}
