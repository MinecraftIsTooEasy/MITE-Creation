package mod.mitecreation.mixin.block;

import net.minecraft.*;
import mod.mitecreation.materil.Materials;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(BlockWorkbench.class)
public class BlockWorkbenchMixin extends Block{
    protected Icon[] front_icons = new Icon[16];
    protected Icon[] side_icons = new Icon[16];

    private final Random random = new Random();

    protected BlockWorkbenchMixin(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }


    protected void dropXpOnBlockBreak(World par1World, int par2, int par3, int par4, int par5) {
    }

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void injectClinit(CallbackInfo callback) {
        tool_materials = new Material[]{
                Material.flint,Material.copper, Material.silver, Material.gold,Material.iron,
                Material.ancient_metal, Materials.tungsten, Material.mithril, Material.adamantium, Material.obsidian};
    }

    @Overwrite
    public Icon getIcon(int side, int metadata) {
        if (metadata < 4) {
            return side == 1 ? this.icon_flint_top : Block.wood.getIcon(side, metadata);
        } else if (metadata >= 12) {
            return side == 1 ? this.icon_obsidian_top : Block.wood.getIcon(side, metadata - 12);
        } else if (side == 0) {
            return Block.planks.getBlockTextureFromSide(side);
        } else if (side == 1) {
            return this.workbenchIconTop;
        } else {
            return side != 2 && side != 3 ? this.side_icons[metadata] : this.front_icons[metadata];
        }
    }
    @Overwrite
    public boolean isValidMetadata(int metadata) {
        return metadata >= 0 && metadata < 16;
    }

    @Overwrite
    public void registerIcons(IconRegister par1IconRegister) {
        this.icon_flint_top = par1IconRegister.registerIcon("crafting_table/flint/top");
        this.icon_obsidian_top = par1IconRegister.registerIcon("crafting_table/obsidian/top");
        this.workbenchIconTop = par1IconRegister.registerIcon("crafting_table_top");

        for(int i = 4; i < this.front_icons.length - 3; ++i) {
            this.front_icons[i] = par1IconRegister.registerIcon("crafting_table/" + BlockWorkbench.getToolMaterial(i).toString() + "/front");
            this.side_icons[i] = par1IconRegister.registerIcon("crafting_table/" + BlockWorkbench.getToolMaterial(i).toString() + "/side");
        }
    }

    @Shadow
    @Mutable
    @Final
    private static Material[] tool_materials;
    @Shadow
    private Icon workbenchIconTop;
    @Shadow
    private Icon icon_flint_top;
    @Shadow
    private Icon icon_obsidian_top;
}

