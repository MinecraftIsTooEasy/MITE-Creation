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
    protected IIcon[] front_icons = new IIcon[16];
    protected IIcon[] side_icons = new IIcon[16];

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
    public IIcon a(int side, int metadata) {
        if (metadata < 4) {
            return side == 1 ? this.icon_flint_top : Block.wood.a(side, metadata);
        } else if (metadata >= 12) {
            return side == 1 ? this.icon_obsidian_top : Block.wood.a(side, metadata - 12);
        } else if (side == 0) {
            return Block.planks.m(side);
        } else if (side == 1) {
            return this.displayOnCreativeTab;
        } else {
            return side != 2 && side != 3 ? this.side_icons[metadata] : this.front_icons[metadata];
        }
    }
    @Overwrite
    public boolean isValidMetadata(int metadata) {
        return metadata >= 0 && metadata < 16;
    }

    @Overwrite
    public void a(mt par1IconRegister) {
        this.icon_flint_top = par1IconRegister.a("crafting_table/flint/top");
        this.icon_obsidian_top = par1IconRegister.a("crafting_table/obsidian/top");
        this.displayOnCreativeTab = par1IconRegister.a("crafting_table_top");

        for(int i = 4; i < this.front_icons.length - 3; ++i) {
            this.front_icons[i] = par1IconRegister.a("crafting_table/" + BlockWorkbench.getToolMaterial(i).toString() + "/front");
            this.side_icons[i] = par1IconRegister.a("crafting_table/" + BlockWorkbench.getToolMaterial(i).toString() + "/side");
        }
    }

    @Shadow
    @Mutable
    @Final
    private static Material[] tool_materials;
    @Shadow
    private IIcon displayOnCreativeTab;
    @Shadow
    private IIcon icon_flint_top;
    @Shadow
    private IIcon icon_obsidian_top;
}

