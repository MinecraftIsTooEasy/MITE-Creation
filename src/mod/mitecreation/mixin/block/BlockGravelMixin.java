package mod.mitecreation.mixin.block;

import mod.mitecreation.item.Items;
import net.minecraft.*;
import net.xiaoyu233.fml.FishModLoader;
import org.spongepowered.asm.mixin.Mixin;
import mod.mitecreation.block.Blocks;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(value= BlockGravel.class)
public class BlockGravelMixin extends BlockFalling implements IBlockWithSubtypes{

    protected BlockGravelMixin(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material,constants);
    }

    @Overwrite
    public int dropBlockAsEntityItem(BlockBreakInfo blockBreakInfo) {
        Random random;
        if (blockBreakInfo.getMetadata() == 1) {
            return super.dropBlockAsEntityItem(blockBreakInfo);
        }
        if (blockBreakInfo.wasExploded() || !blockBreakInfo.wasHarvestedByPlayer()) {
            return super.dropBlockAsEntityItem(blockBreakInfo);
        }
        int n = blockBreakInfo.getHarvesterFortune();
        if (n > 3) {
            n = 3;
        }
        if ((random = blockBreakInfo.world.rand).nextInt(12 - n * 2) > 2) {
            return super.dropBlockAsEntityItem(blockBreakInfo);
        }
        int n2 = -1;
        if (random.nextInt(3) > 0) {
            if (random.nextInt(16) == 0) {
                n2 = blockBreakInfo.wasExploded() ? Item.chipFlint.itemID : Item.flint.itemID;
            } else {
                if (blockBreakInfo.wasExploded()) {
                    return super.dropBlockAsEntityItem(blockBreakInfo);
                }
                n2 = Item.chipFlint.itemID;
            }
        } else {
            n2 = random.nextInt(3) > 0 ? Items.rawCopperNugget.itemID : (random.nextInt(3) > 0 ? Items.rawSilverNugget.itemID : (random.nextInt(3) > 0 ? Items.rawGoldNugget.itemID : (random.nextInt(3) > 0 ? Items.rawGoldNugget.itemID : (random.nextInt(3) > 0 ? (blockBreakInfo.wasExploded() ? -1 : Item.shardObsidian.itemID) : (random.nextInt(3) > 0 ? (blockBreakInfo.wasExploded() ? -1 : Item.shardEmerald.itemID) : (random.nextInt(3) > 0 ? (blockBreakInfo.wasExploded() ? -1 : Item.shardDiamond.itemID) : (random.nextInt(3) > 0 ? Items.rawMithrilNugget.itemID : Items.rawAdamantiumNugget.itemID)))))));
        }
        if (this.isNetherGravel(blockBreakInfo.getMetadata())) {
            if (n2 == Item.copperNugget.itemID || n2 == Item.silverNugget.itemID || n2 == Item.mithrilNugget.itemID || n2 == Item.adamantiumNugget.itemID) {
                n2 = Item.goldNugget.itemID;
            } else if (n2 == Item.shardObsidian.itemID || n2 == Item.shardEmerald.itemID || n2 == Item.shardDiamond.itemID) {
                n2 = Item.shardNetherQuartz.itemID;
            }
        }
        if (n2 != -1) {
            DedicatedServer.incrementTournamentScoringCounter(blockBreakInfo.getResponsiblePlayer(), Item.getItem(n2));
        }
        if (blockBreakInfo.wasHarvestedByPlayer() && (n2 == Item.chipFlint.itemID || n2 == Item.flint.itemID)) {
            blockBreakInfo.getResponsiblePlayer().triggerAchievement(AchievementList.flintFinder);
        }
        return this.dropBlockAsEntityItem(blockBreakInfo, n2);
    }
    @Shadow
    private boolean isNetherGravel(int metadata) {
        return false;
    }

    @Shadow
    private BlockSubtypes subtypes;

    @Override
    public String getMetadataNotes() {
        return "0=Gravel, 1=Village Road, 2=Nether Gravel, 3=Deep Gravel, 4=Sand Gravel";
    }

    @Override
    public boolean isValidMetadata(int metadata) {
        return metadata >= 0 && metadata < 4;
    }

    @Override
    public int getBlockSubtypeUnchecked(int metadata) {
        if(metadata >= 4){
            return 0;
        }
        return metadata;
    }

    @Override
    public int getItemSubtype(int metadata) {
        switch (metadata){
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                FishModLoader.LOGGER.error("getItemSubtype():Unhandled subtype:" + metadata);
                return 0;
        }
    }

    @Override
    public void a(mt par1IconRegister) {
        this.subtypes.setIcons(this.registerIcons(par1IconRegister, this.getTextures()));
    }

    @Override
    public IIcon a(int side, int metadata) {
        return this.subtypes.getIcon(this.getBlockSubtype(metadata));
    }

    @Override
    public String[] getTextures() {
        return this.subtypes.getTextures();
    }

    @Override
    public String[] getNames() {
        return this.subtypes.getNames();
    }
    @Inject(method = "<init>",at = @At("TAIL"))
    private void inject(CallbackInfo callbackInfo){
        this.subtypes = new BlockSubtypes(new String[]{"gravel", "nether_gravel","deep_gravel","sand_gravel"});
    }
}
