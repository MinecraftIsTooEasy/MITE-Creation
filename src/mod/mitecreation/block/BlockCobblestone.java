package mod.mitecreation.block;
import net.minecraft.*;

public class BlockCobblestone extends Block implements IBlockWithSubtypes {

    private final BlockSubtypes subtypes = new BlockSubtypes(new String[]{"cobblestone", "cobblestone_deepslate"});

    public BlockCobblestone() {
        super(4, Material.stone, new BlockConstants());
        setHardness(2.0f);
        setResistance(10.0f);
        setStepSound(soundStoneFootstep);
        setUnlocalizedName("stonebrick").setCreativeTab(CreativeModeTab.tabBlock);
        setTextureName("cobblestone");
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
    public IIcon a(int n, int n2) {
        return this.subtypes.getIcon(this.getBlockSubtype(n2));
    }

    @Override
    public float getBlockHardness(int metadata) {
        metadata = getBlockSubtypeUnchecked(metadata);
        switch (metadata){
            case 0:
                return super.getBlockHardness(metadata);
            case 1:
                return super.getBlockHardness(metadata) * 1.25f;
            default:
                throw new IllegalArgumentException("Unhandled subtype:" + metadata);
        }
    }

    @Override
    public int getMetadataForPlacement(World world, int n, int n2, int n3, ItemStack itemStack, Entity entity, EnumFace enumFace, float f, float f2, float f3) {
        return itemStack.getItemSubtype();
    }

    @Override
    public void a(mt mt2) {
        this.subtypes.setIcons(this.registerIcons(mt2, this.getTextures(),""));
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
        return "0=Cobblestone, 1=Cobblestone Deepslate";
    }

    public BlockCobblestone setHardness(float f){
        return (BlockCobblestone) super.setHardness(f);
    }

    public BlockCobblestone setResistance(float f){
        return (BlockCobblestone) super.setResistance(f);
    }
}
