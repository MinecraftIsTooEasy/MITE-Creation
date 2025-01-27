package mod.mitecreation.mixin.world;

import mod.mitecreation.world.structure.CTRuinsPieces;
import mod.mitecreation.world.structure.StructureCTRuinsStart;
import net.minecraft.MapGenStructureIO;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MapGenStructureIO.class)
public abstract class MapGenStructureIOMixin {
    @Shadow private static void func_143034_b(Class class_, String string) {}

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void addCreationStructure(CallbackInfo ci) {
        func_143034_b(StructureCTRuinsStart.class, "Ruins");
        CTRuinsPieces.initStructure();
    }
}
