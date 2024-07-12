package mod.mitecreation.block;

import mod.mitecreation.item.CreationItem;
import net.minecraft.*;

public class BlockAncientRelict extends BlockOre {

    public BlockAncientRelict(int par1) {
        super(par1, Material.ancient_metal, 2);
    }

    @Override
    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        int metadata_dropped = -1;
        int quantity_dropped = 1;
        int id_dropped = 0;
        if (info.wasExploded()) {
            id_dropped = CreationItem.rawAncientMetalNugget.itemID;
        } else {
            if (info.wasHarvestedByPlayer() && info.getResponsiblePlayer().worldObj.areSkillsEnabled() && !info.getResponsiblePlayer().hasSkill(Skill.MINING)) {
                return super.dropBlockAsEntityItem(info);
            }
        }
        if (metadata_dropped == -1) {
            metadata_dropped = id_dropped == this.blockID ? this.getItemSubtype(info.getMetadata()) : 0;
        }

        boolean suppress_fortune = id_dropped == this.blockID && BitHelper.isBitSet(info.getMetadata(), 1);
        if (id_dropped != -1 && info.getMetadata() == 0) {
            DedicatedServer.incrementTournamentScoringCounter(info.getResponsiblePlayer(), Item.getItem(id_dropped));
        }

        float chance = suppress_fortune ? 1.0F : 1.0F + (float) info.getHarvesterFortune() * 0.1F;
        return super.dropBlockAsEntityItem(info, id_dropped, metadata_dropped, quantity_dropped, chance);
    }
}
