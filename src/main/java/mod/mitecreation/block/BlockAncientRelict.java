package mod.mitecreation.block;

import mod.mitecreation.item.CreationItem;
import net.minecraft.*;

import java.util.Random;

public class BlockAncientRelict extends Block {

    public BlockAncientRelict(int par1) {
        super(par1, Material.ancient_metal, (new BlockConstants()).setNeverHidesAdjacentFaces().setNotAlwaysLegal());
    }

    @Override
    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        Random random = new Random();
        int quantity_dropped;
        int id_dropped = CreationItem.rawAncientMetalNugget.itemID;
        quantity_dropped = 7 + random.nextInt(3) + random.nextInt(3);
        boolean suppress_fortune = BitHelper.isBitSet(info.getMetadata(), 1);
        float chance = suppress_fortune ? 0.5F : 0.5F + (float) info.getHarvesterFortune() * 0.1F;
        this.dropXpOnBlockBreak(info.world, info.x, info.y, info.z, (int) (6 * chance));
        return dropBlockAsEntityItem(info, id_dropped, 0, quantity_dropped, chance);
    }
}
