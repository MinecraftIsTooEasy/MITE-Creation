package mod.mitecreation.mixin.block;

import mod.mitecreation.item.Items;
import mod.mitecreation.util.BlockOreTransHelper;
import net.minecraft.*;
import java.util.Random;

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
        boolean bl;
        int n;
        int n2 = -1;
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
            if (blockBreakInfo.wasHarvestedByPlayer() && blockBreakInfo.getResponsiblePlayer().worldObj.areSkillsEnabled() && !blockBreakInfo.getResponsiblePlayer().hasSkill(Skill.MINING)) {
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
                if(((BlockOre)oreCopper).richOrPoor == 1){
                    n = Items.rawCopperNugget.itemID;
                    n3 = 7 + new Random().nextInt(3) + new Random().nextInt(3);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 2) {
                    n = Items.rawCopperNugget.itemID;
                    n3 = 14 + new Random().nextInt(5) + new Random().nextInt(5);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 0) {
                    n = Items.rawCopperNugget.itemID;
                    n3 = 3 + new Random().nextInt(2) + new Random().nextInt(2);
                }
            }else if(this == oreIron){
                if(((BlockOre)oreIron).richOrPoor == 1){
                    n = Items.rustedIronNugget.itemID;
                    n3 = 7 + new Random().nextInt(3) + new Random().nextInt(3);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 2) {
                    n = Items.rustedIronNugget.itemID;
                    n3 = 14 + new Random().nextInt(5) + new Random().nextInt(5);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 0) {
                    n = Items.rustedIronNugget.itemID;
                    n3 = 3 + new Random().nextInt(2) + new Random().nextInt(2);
                }
            }else if(this == oreSilver){
                if(((BlockOre)oreSilver).richOrPoor == 1){
                    n = Items.rawSilverNugget.itemID;
                    n3 = 7 + new Random().nextInt(3) + new Random().nextInt(3);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 2) {
                    n = Items.rawSilverNugget.itemID;
                    n3 = 14 + new Random().nextInt(5) + new Random().nextInt(5);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 0) {
                    n = Items.rawSilverNugget.itemID;
                    n3 = 3 + new Random().nextInt(2) + new Random().nextInt(2);
                }
            }else if(this == oreGold){
                if(((BlockOre)oreGold).richOrPoor == 1){
                    n = Items.rawGoldNugget.itemID;
                    n3 = 7 + new Random().nextInt(3) + new Random().nextInt(3);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 2) {
                    n = Items.rawGoldNugget.itemID;
                    n3 = 14 + new Random().nextInt(5) + new Random().nextInt(5);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 0) {
                    n = Items.rawGoldNugget.itemID;
                    n3 = 3 + new Random().nextInt(2) + new Random().nextInt(2);
                }
            }else if(this == oreMithril){
                if(((BlockOre)oreMithril).richOrPoor == 1){
                    n = Items.rawMithrilNugget.itemID;
                    n3 = 7 + new Random().nextInt(3) + new Random().nextInt(3);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 2) {
                    n = Items.rawMithrilNugget.itemID;
                    n3 = 14 + new Random().nextInt(5) + new Random().nextInt(5);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 0) {
                    n = Items.rawMithrilNugget.itemID;
                    n3 = 3 + new Random().nextInt(2) + new Random().nextInt(2);
                }
            }else if(this == oreAdamantium){
                if(((BlockOre)oreAdamantium).richOrPoor == 1){
                    n = Items.rawAdamantiumNugget.itemID;
                    n3 = 7 + new Random().nextInt(3) + new Random().nextInt(3);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 2) {
                    n = Items.rawAdamantiumNugget.itemID;
                    n3 = 14 + new Random().nextInt(5) + new Random().nextInt(5);
                } else if (((BlockOre)blockBreakInfo.block).richOrPoor == 0) {
                    n = Items.rawAdamantiumNugget.itemID;
                    n3 = 3 + new Random().nextInt(2) + new Random().nextInt(2);
                }
            }
        }
        if (n2 == -1) {
            n2 = n == this.blockID ? this.getItemSubtype(blockBreakInfo.getMetadata()) : 0;
        }
        boolean bl2 = bl = n == this.blockID && BitHelper.isBitSet(blockBreakInfo.getMetadata(), 1);
        if (n != -1 && blockBreakInfo.getMetadata() == 0) {
            DedicatedServer.incrementTournamentScoringCounter(blockBreakInfo.getResponsiblePlayer(), Item.getItem(n));
        }
        float f = bl ? 1.0f : 1.0f + (float)blockBreakInfo.getHarvesterFortune() * 0.1f;
        return super.dropBlockAsEntityItem(blockBreakInfo, n, n2, n3, f);
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
        return "0=Rich Ore, 1=Normal Ore ,2=Poor Ore";
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
        return true;
    }

    public float getBlockHardness(int metadata) {
        if(metadata == 1){
            return super.getBlockHardness(metadata) * 0.7f;
        }if(metadata == 0){
            return super.getBlockHardness(metadata) * 1.4f;
        }
        return super.getBlockHardness(metadata);
    }
}
