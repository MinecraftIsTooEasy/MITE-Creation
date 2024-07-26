package mod.mitecreation.block;

import mod.mitecreation.item.CreationItem;
import net.minecraft.*;

public class BlockAncientRelict extends Block {

    public BlockAncientRelict(int par1) {
        super(par1, Material.ancient_metal, (new BlockConstants()).setNeverHidesAdjacentFaces().setNotAlwaysLegal());
    }

    @Override
    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        int metadata_dropped = 0;
        int quantity_dropped = 1;
        int id_dropped = 0;
        if (info.wasExploded()) {
            id_dropped = -1;
        } else {
                id_dropped = CreationItem.rawAncientMetalNugget.itemID;
        }
        boolean suppress_fortune = BitHelper.isBitSet(info.getMetadata(), 1);
        float chance = suppress_fortune ? 0.5F : 0.5F + (float) info.getHarvesterFortune() * 0.1F;
        this.dropXpOnBlockBreak(info.world, info.x, info.y, info.z, (int) (6 * chance));

        return super.dropBlockAsEntityItem(info, id_dropped, metadata_dropped, quantity_dropped, chance);
    }
}
