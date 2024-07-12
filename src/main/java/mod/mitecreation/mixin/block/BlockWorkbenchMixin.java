package mod.mitecreation.mixin.block;

import net.minecraft.*;
import mod.mitecreation.materil.Materials;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.BlockWorkbench.getToolMaterial;

@Mixin(BlockWorkbench.class)
public abstract class BlockWorkbenchMixin extends Block {

    @Unique
    protected Icon[] front_icons = new Icon[16];

    @Unique
    protected Icon[] side_icons = new Icon[16];

    @Shadow
    @Mutable
    @Final
    private static Material[] tool_materials;

    protected BlockWorkbenchMixin(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    @Inject(method = {"<clinit>()V"}, at = {@At("RETURN")})
    private static void injectClinitCreation(CallbackInfo callback) {
        tool_materials = new Material[]{
                Material.flint,
                Material.copper,
                Material.silver,
                Material.gold,
                Material.iron,
                Material.ancient_metal,
                Materials.tungsten,
                Material.mithril,
                Material.adamantium,
                Material.obsidian
        };
    }

    @ModifyConstant(method = "getIcon", constant = @Constant(intValue = 10))
    private int modifyGetIconIndex(int original){
        return 11;
    }

    @ModifyConstant(method = "registerIcons", constant = @Constant(intValue = 4, ordinal = 1))
    private int injectModifyCraftingTableIconRegister(int original){
        return 3;
    }

    @Inject(method = "registerIcons", at = @At("TAIL"))
    private void registerIconsCreation(IconRegister par1IconRegister, CallbackInfo ci) {
        int i = this.front_icons.length - 3;
        this.front_icons[i] = par1IconRegister.registerIcon("crafting_table/" + getToolMaterial(i).toString() + "/front");
        this.side_icons[i] = par1IconRegister.registerIcon("crafting_table/" + getToolMaterial(i).toString() + "/side");
    }
}
