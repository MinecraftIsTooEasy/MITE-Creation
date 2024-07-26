package mod.mitecreation.block;

import mod.mitecreation.materil.CreationMaterial;
import net.minecraft.*;

public class CreationWorkbench  extends BlockWorkbench {
    private Icon workbenchIconTop;
    protected Icon[] front_icons = new Icon[2];
    protected Icon[] side_icons = new Icon[2];
    public static final Material[] tool_materials = new Material[]{Material.rusted_iron, CreationMaterial.tungsten};

    public CreationWorkbench(int blockId) {
        super(blockId);
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        if (side == 0) {
            return Block.planks.getBlockTextureFromSide(side);
        }
        if (side == 1) {
            return this.workbenchIconTop;
        }
        if (side == 2 || side == 3) {
            return this.front_icons[metadata];
        }
        return this.side_icons[metadata];
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.workbenchIconTop = par1IconRegister.registerIcon("crafting_table_top");
        for (int i = 0; i < this.front_icons.length; ++i) {
            this.front_icons[i] = par1IconRegister.registerIcon("crafting_table/" + CreationWorkbench.getToolMaterial(i).name + "/front");
            this.side_icons[i] = par1IconRegister.registerIcon("crafting_table/" + CreationWorkbench.getToolMaterial(i).name + "/side");
        }
    }

    public static Material getToolMaterial(int metadata) {
        return tool_materials[metadata];
    }

    public static float getCraftingSpeedModifier(Material benchMaterial) {
        if (benchMaterial == Material.rusted_iron) {
            return  0.0F;
        } else if (benchMaterial == CreationMaterial.tungsten) {
            return 0.55F;
        }
        return 0.0F;
    }


    public static Material getMaterialToCheckToolBenchHardnessAgainst(int metadata) {
        return switch (metadata) {
            case 0 -> Material.rusted_iron;
            case 1 -> CreationMaterial.tungsten;
            default -> Material.obsidian;
        };
    }

    @Override
    public String getMetadataNotes() {
        return "0 is rusted iron, 1 is tungsten";
    }

    @Override
    public boolean isValidMetadata(int metadata) {
        return metadata < 2;
    }
}
