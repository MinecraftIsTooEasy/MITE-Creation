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
                    default:
                        throw new IllegalArgumentException("Unhandled metadata!");
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
                    default:
                        throw new IllegalArgumentException("Unhandled metadata!");
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
                    default:
                        throw new IllegalArgumentException("Unhandled metadata!");
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
                    default:
                        throw new IllegalArgumentException("Unhandled metadata!");
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
                    default:
                        throw new IllegalArgumentException("Unhandled metadata!");
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
                    default:
                        throw new IllegalArgumentException("Unhandled metadata!");
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
        if((Block)this instanceof BlockOre){
            if(this.richOrPoor == 0){
                this.textureName = "poor_" + string;
            } else if (this.richOrPoor == 2) {
                this.textureName = "rich_" + string;
            }
        }
        this.textureName = string;
        return this;
    }

    @Override
    public String getMetadataNotes() {
        return "0=Poor Ore, 1=Normal Ore ,2=Rich Ore";
    }

    @Override
    public int getItemSubtype(int n) {
        int i = n;
        if(this.getBlockSubtype(n) == 3){
            i = 0;
        } else if (this.getBlockSubtype(n) == 4) {
            i = 1;
        } else if (this.getBlockSubtype(n) == 5) {
            i = 2;
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
        if(n == 3){
            return 0;
        } else if (n == 4) {
            return 1;
        } else if (n == 5) {
            return 2;
        }
        return n;
    }

    @Override
    public void a(mt mt2) {
        this.subtypes.setIcons(this.registerIcons(mt2, this.getTextures()));
    }

    @Override
    public IIcon a(int n, int n2) {
        return this.subtypes.getIcon(this.getBlockSubtype(n2));
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
        FishModLoader.LOGGER.info(metadata);
        return true;
    }

    public float getBlockHardness(int metadata) {
        if(metadata == 0){
            return super.getBlockHardness(metadata) * 0.7f;
        }if(metadata == 2){
            return super.getBlockHardness(metadata) * 1.4f;
        }
        return super.getBlockHardness(metadata);
    }
}