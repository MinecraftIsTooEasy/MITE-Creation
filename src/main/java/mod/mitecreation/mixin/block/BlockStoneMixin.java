package mod.mitecreation.mixin.block;

import mod.mitecreation.util.BlockStoneMixinHelper;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockStone.class)
@Implements(@Interface(iface = IBlockWithSubtypes.class,prefix = "vw$"))
public class BlockStoneMixin extends Block implements IBlockWithSubtypes {

    private final BlockSubtypes subtypes = BlockStoneMixinHelper.subtypesInitializer();

    protected BlockStoneMixin(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    @Override
    public String[] getTextures() {
        return this.subtypes.getTextures();
    }

    @Override
    public String[] getNames() {
        return this.subtypes.getNames();
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        return this.subtypes.getIcon(this.getBlockSubtype(metadata));
    }

    @Override
    public float getBlockHardness(int metadata) {
        metadata = getBlockSubtypeUnchecked(metadata);
        switch (metadata){
            case 0:
                return super.getBlockHardness(metadata);
            case 1:
                return super.getBlockHardness(metadata) * 2f;
            default:
                throw new IllegalArgumentException("Unhandled subtype:" + metadata);
        }
    }

    @Override
    public int getMetadataForPlacement(World world, int n, int n2, int n3, ItemStack itemStack, Entity entity, EnumFace enumFace, float f, float f2, float f3) {
        return itemStack.getItemSubtype();
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.subtypes.setIcons(this.registerIcons(par1IconRegister, this.getTextures(),""));
    }

    @Override
    public int getBlockSubtypeUnchecked(int n) {
        switch (n){
            case 0:
                return n;
            case 1:
                return n;
            default:
                return 0;
        }
    }

    @Override
    public boolean isValidMetadata(int n) {
        return n >= 0 && n < 2;
    }

    @Override
    public int getItemSubtype(int n) {
        return this.getBlockSubtype(n);
    }

    @Override
    public String getMetadataNotes() {
        return "0=Stone, 1=Deepslate";
    }

}
