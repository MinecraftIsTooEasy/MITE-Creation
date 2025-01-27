package mod.mitecreation.mixin.world.chunk;

import mod.mitecreation.world.structure.MapGenCTRuins;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(ChunkProviderFlat.class)
public class ChunkProviderFlatMixin {
    @Shadow @Final private FlatGeneratorInfo flatWorldGenInfo;

    @Shadow @Final private List structureGenerators;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void addCreationStructure(World par1World, long par2, boolean par4, String par5Str, CallbackInfo ci) {
        if (par4) {
            Map var6 = this.flatWorldGenInfo.getWorldFeatures();
            if (var6.containsKey("village")) {
                Map var7 = (Map)var6.get("village");
                if (!var7.containsKey("size")) {
                    var7.put("size", "1");
                }
                this.structureGenerators.add(new MapGenVillage(var7));
            }
            if (var6.containsKey("biome_1")) {
                this.structureGenerators.add(new MapGenCTRuins((Map) var6.get("biome_1")));
            }
        }

    }
}
