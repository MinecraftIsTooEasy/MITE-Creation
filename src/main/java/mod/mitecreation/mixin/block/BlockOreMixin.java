package mod.mitecreation.mixin.block;

import mod.mitecreation.item.Items;
import mod.mitecreation.util.BlockOreTransHelper;
import net.minecraft.*;
import java.util.Random;

import net.xiaoyu233.fml.FishModLoader;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value=BlockOre.class)
@Implements(@Interface(iface = IBlockWithSubtypes.class,prefix = "vw$"))
public class BlockOreMixin extends Block implements IBlockWithSubtypes{

    private final BlockSubtypes subtypes = BlockOreTransHelper.subtypesInitializer();

    public int richOrPoor;

    protected BlockOreMixin(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    public Block setResourceLocation(String string) {
        return this.setTextureName(string);
    }

    public int dropBlockAsEntityItem(BlockBreakInfo blockBreakInfo) {
        Random random = new Random();
        boolean bl;
        int n;
        int n2 = 0;
        int n3 = 1;
        if (blockBreakInfo.wasExploded()) {
            if (this == oreEmerald) {
                n = Item.shardEmerald.itemID;
            } else if (this == oreDiamond) {
                n = Item.shardDiamond.itemID;
            } else if (this == oreLapis) {
                n = Item.dyePowder.itemID;
                n2 = 4;
                n3 = 3 + blockBreakInfo.world.rand.nextInt(3);
            } else {
                n = this == oreNetherQuartz ? Item.shardNetherQuartz.itemID : (this == oreCoal ? -1 : this.blockID);
            }
        } else {
            //if (blockBreakInfo.wasHarvestedByPlayer() && blockBreakInfo.getResponsiblePlayer().worldObj.areSkillsEnabled() && !blockBreakInfo.getResponsiblePlayer().hasSkill(Skill.MINING)) {
            //    return super.dropBlockAsEntityItem(blockBreakInfo);
            //}
            if(!blockBreakInfo.wasHarvestedByPlayer()){
                return super.dropBlockAsEntityItem(blockBreakInfo);
            }
            if (this == oreCoal) {
                n = Item.coal.itemID;
            } else if (this == oreDiamond) {
                n = Item.diamond.itemID;
            } else if (this == oreLapis) {
                n = Item.dyePowder.itemID;
                n2 = 4;
                n3 = 3 + blockBreakInfo.world.rand.nextInt(3);
            } else {
                n = this == oreEmerald ? Item.emerald.itemID : (this == oreNetherQuartz ? Item.netherQuartz.itemID : this.blockID);
            }
            if(this == oreCopper){
                n = Items.rawCopperNugget.itemID;
                int metadata = blockBreakInfo.getMetadata();
                switch(metadata) {
                    case 0:
                        n3 = 3 + random.nextInt(2) + random.nextInt(2);
                        break;
                    case 1:
                        n3 = 7 + random.nextInt(3) + random.nextInt(3);
                        break;
                    case 2:
                        n3 = 14 + random.nextInt(5) + random.nextInt(5);
                        break;
                    case 3:
                        n3 = 3 + random.nextInt(2) + random.nextInt(2);
                        break;
                    case 4:
                        n3 = 7 + random.nextInt(3) + random.nextInt(3);
                        break;
                    case 5:
                        n3 = 14 + random.nextInt(5) + random.nextInt(5);
                        break;
                    default:
                        n3 = 0;
                        FishModLoader.LOGGER.error("dropBlockAsEntityItem():Unhandled subtype:" + metadata);
                        break;
                }
            }else if(this == oreIron){
                n = Items.rawRustedIronNugget.itemID;
                int metadata = blockBreakInfo.getMetadata();
                switch(metadata) {
                    case 0:
                        n3 = 3 + random.nextInt(2) + random.nextInt(2);
                        break;
                    case 1:
                        n3 = 7 + random.nextInt(3) + random.nextInt(3);
                        break;
                    case 2:
                        n3 = 14 + random.nextInt(5) + random.nextInt(5);
                        break;
                    case 3:
                        n3 = 3 + random.nextInt(2) + random.nextInt(2);
                        break;
                    case 4:
                        n3 = 7 + random.nextInt(3) + random.nextInt(3);
                        break;
                    case 5:
                        n3 = 14 + random.nextInt(5) + random.nextInt(5);
                        break;
                    default:
                        n3 = 0;
                        FishModLoader.LOGGER.error("dropBlockAsEntityItem():Unhandled subtype:" + metadata);
                        break;
                }
            }else if(this == oreSilver){
                n = Items.rawSilverNugget.itemID;
                int metadata = blockBreakInfo.getMetadata();
                switch(metadata) {
                    case 0:
                        n3 = 3 + random.nextInt(2) + random.nextInt(2);
                        break;
                    case 1:
                        n3 = 7 + random.nextInt(3) + random.nextInt(3);
                        break;
                    case 2:
                        n3 = 14 + random.nextInt(5) + random.nextInt(5);
                        break;
                    case 3:
                        n3 = 3 + random.nextInt(2) + random.nextInt(2);
                        break;
                    case 4:
                        n3 = 7 + random.nextInt(3) + random.nextInt(3);
                        break;
                    case 5:
                        n3 = 14 + random.nextInt(5) + random.nextInt(5);
                        break;
                    default:
                        n3 = 0;
                        FishModLoader.LOGGER.error("dropBlockAsEntityItem():Unhandled subtype:" + metadata);
                        break;
                }
            }else if(this == oreGold){
                n = Items.rawGoldNugget.itemID;
                int metadata = blockBreakInfo.getMetadata();
                switch(metadata) {
                    case 0:
                        n3 = 3 + random.nextInt(2) + random.nextInt(2);
                        break;
                    case 1:
                        n3 = 7 + random.nextInt(3) + random.nextInt(3);
                        break;
                    case 2:
                        n3 = 14 + random.nextInt(5) + random.nextInt(5);
                        break;
                    case 3:
                        n3 = 3 + random.nextInt(2) + random.nextInt(2);
                        break;
                    case 4:
                        n3 = 7 + random.nextInt(3) + random.nextInt(3);
                        break;
                    case 5:
                        n3 = 14 + random.nextInt(5) + random.nextInt(5);
                        break;
                    default:
                        n3 = 0;
                        FishModLoader.LOGGER.error("dropBlockAsEntityItem():Unhandled subtype:" + metadata);
                        break;
                }
            }else if(this == oreMithril){
                n = Items.rawMithrilNugget.itemID;
                int metadata = blockBreakInfo.getMetadata();
                switch(metadata) {
                    case 0:
                        n3 = 3 + random.nextInt(2) + random.nextInt(2);
                        break;
                    case 1:
                        n3 = 7 + random.nextInt(3) + random.nextInt(3);
                        break;
                    case 2:
                        n3 = 14 + random.nextInt(5) + random.nextInt(5);
                        break;
                    case 3:
                        n3 = 3 + random.nextInt(2) + random.nextInt(2);
                        break;
                    case 4:
                        n3 = 7 + random.nextInt(3) + random.nextInt(3);
                        break;
                    case 5:
                        n3 = 14 + random.nextInt(5) + random.nextInt(5);
                        break;
                    default:
                        n3 = 0;
                        FishModLoader.LOGGER.error("dropBlockAsEntityItem():Unhandled subtype:" + metadata);
                        break;
                }
            }else if(this == oreAdamantium){
                n = Items.rawAdamantiumNugget.itemID;
                int metadata = blockBreakInfo.getMetadata();
                switch(metadata) {
                    case 0:
                        n3 = 3 + random.nextInt(2) + random.nextInt(2);
                        break;
                    case 1:
                        n3 = 7 + random.nextInt(3) + random.nextInt(3);
                        break;
                    case 2:
                        n3 = 14 + random.nextInt(5) + random.nextInt(5);
                        break;
                    case 3:
                        n3 = 3 + random.nextInt(2) + random.nextInt(2);
                        break;
                    case 4:
                        n3 = 7 + random.nextInt(3) + random.nextInt(3);
                        break;
                    case 5:
                        n3 = 14 + random.nextInt(5) + random.nextInt(5);
                        break;
                    default:
                        n3 = 0;
                        FishModLoader.LOGGER.error("dropBlockAsEntityItem():Unhandled subtype:" + metadata);
                        break;
                }
            }
        }
        //if (n2 == -1) {
        //    n2 = n == this.blockID ? this.getItemSubtype(blockBreakInfo.getMetadata()) : 0;
        //}
        //boolean bl2 = bl = n == this.blockID && BitHelper.isBitSet(blockBreakInfo.getMetadata(), 1);
        //if (n != -1 && blockBreakInfo.getMetadata() == 0) {
        //    DedicatedServer.incrementTournamentScoringCounter(blockBreakInfo.getResponsiblePlayer(), Item.getItem(n));
        //}
        return super.dropBlockAsEntityItem(blockBreakInfo, n, n2, n3, 1);
    }

    public Block setTextureName(String string) {
        this.textureName = string;
        return this;
    }

    @Override
    public String getMetadataNotes() {
        return "0=Poor Ore, 1=Normal Ore ,2=Rich Ore, 3=Poor Ore Deepslate, 4=Normal Ore Deepslate, 5=Rich Ore Deepslate";
    }

    @Override
    public int getItemSubtype(int n) {
        if(n >= 6 || n < 0){
            FishModLoader.LOGGER.error("getItemSubtype():Unhandled subtype:" + n);
            return 0;
        }
        return this.getBlockSubtype(n);
    }

    public String isRichOrPoor(int n){
        return BlockOreTransHelper.isRichOrPoorHelper(n);
    }

    @Override
    public boolean isValidMetadata(int n) {
        return n >= 0 && n < 6;
    }

    @Override
    public int getBlockSubtypeUnchecked(int n) {
        if(n >= 6 || n < 0){
            FishModLoader.LOGGER.error("getItemSubtype():Unhandled subtype:" + n);
            return 0;
        }
        return n;
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.subtypes.setIcons(this.registerIcons(par1IconRegister, this.getTextures()));
    }

    @Override
    public Icon getIcon(int side, int metadata) {
        return this.subtypes.getIcon(this.getBlockSubtype(metadata));
    }

    @Override
    public String[] getTextures() {
        return BlockOreTransHelper.setRichOrPoor(textureName);
    }

    @Override
    public String[] getNames() {
        return BlockOreTransHelper.setRichOrPoor(textureName);
    }

    @Override
    public int getMetadataForPlacement(World world, int n, int n2, int n3, ItemStack itemStack, Entity entity, EnumFace enumFace, float f, float f2, float f3) {
        return itemStack.getItemSubtype();
    }

    public boolean onBlockPlacedMITE(World world, int x, int y, int z, int metadata, Entity placer, boolean test_only) {
        ItemStack item_stack = placer.getAsEntityLivingBase().getHeldItemStack();
        if (!test_only && placer instanceof EntityLiving) {
            if (item_stack.hasDisplayName()) {
                TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
                if (tile_entity != null) {
                    tile_entity.setCustomInvName(item_stack.getDisplayName());
                }
            }
        }
        this.richOrPoor = metadata;
        return true;
    }

    public float getBlockHardness(int metadata) {
        switch(metadata){
            case 0:
                return super.getBlockHardness(metadata) * 0.7f;
            case 1:
                return super.getBlockHardness(metadata);
            case 2:
                return super.getBlockHardness(metadata) * 1.4f;
            case 3:
                return super.getBlockHardness(metadata) * 0.7f * 1.25f;
            case 4:
                return super.getBlockHardness(metadata) * 1.25f;
            case 5:
                return super.getBlockHardness(metadata) * 1.4f * 1.25f;
        }
        return super.getBlockHardness(metadata);
    }
}
