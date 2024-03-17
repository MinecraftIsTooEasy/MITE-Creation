package mod.mitecreation.mixin.render;

import mod.mitecreation.entity.EntitySpiderQueen;
import mod.mitecreation.render.RenderSpiderQueen;
import mod.mitecreation.render.RenderSpirit;
import net.minecraft.*;
import mod.mitecreation.entity.EntitySpirit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

import static net.xiaoyu233.fml.util.ReflectHelper.dyCast;

@Mixin(RenderManager.class)
public class RenderManagerMixin {
    @Shadow
    private final Map<Class<? extends Entity>, Render> entityRenderMap = new HashMap<>();
    @Inject(
            method = "<init>",
            at = @At(value = "RETURN"))
    private void injectRegister(CallbackInfo callback) {
        this.entityRenderMap.put(EntitySpirit.class, new RenderSpirit());
        this.entityRenderMap.put(EntitySpiderQueen.class, new RenderSpiderQueen(1.45F));

        for (Render o : this.entityRenderMap.values()) {
            o.setRenderManager(dyCast(RenderManager.class, this));
        }
    }
}
