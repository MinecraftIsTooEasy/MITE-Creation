package mod.mitecreation.mixin.world;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(WorldProviderUnderworld.class)
public abstract class WorldProviderUnderworldMixin extends WorldProvider {


    public WorldProviderUnderworldMixin(int dimension_id, String name) {
        super(dimension_id, name);
    }
}
