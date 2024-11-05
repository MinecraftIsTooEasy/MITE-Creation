package mod.mitecreation.client.event.listener;

import mod.mitecreation.init.RegistryInit;
import moddedmite.rustedironcore.api.event.listener.IFurnaceUpdateListener;
import net.minecraft.TileEntityFurnace;

public class FurnaceListener implements IFurnaceUpdateListener {

    @Override
    public int onFurnaceCookTimeIncreaseModify(TileEntityFurnace tileEntityFurnace, int original) {
        int item_id = (tileEntityFurnace.getInputItemStack()).itemID;
        int heat_level = tileEntityFurnace.heat_level;
        int speed_bonus = 1;
        if (heat_level == 2 && item_id == RegistryInit.rawGoldNugget.itemID ||
                heat_level == 2 && item_id == RegistryInit.rawCopperNugget.itemID ||
                heat_level == 2 && item_id == RegistryInit.rawSilverNugget.itemID)
            speed_bonus = 2;

        if (heat_level == 3 && item_id == RegistryInit.rawGoldNugget.itemID ||
                heat_level == 3 && item_id == RegistryInit.rawCopperNugget.itemID ||
                heat_level == 3 && item_id == RegistryInit.rawSilverNugget.itemID)
            speed_bonus = 4;

        if (heat_level == 4 && item_id == RegistryInit.rawGoldNugget.itemID ||
                heat_level == 4 && item_id == RegistryInit.rawCopperNugget.itemID ||
                heat_level == 4 && item_id == RegistryInit.rawSilverNugget.itemID)
            speed_bonus = 8;

        if (heat_level == 5 && item_id == RegistryInit.rawGoldNugget.itemID ||
                heat_level == 5 && item_id == RegistryInit.rawCopperNugget.itemID ||
                heat_level == 5 && item_id == RegistryInit.rawSilverNugget.itemID)
            speed_bonus = 16;


        if (heat_level == 3 && item_id == RegistryInit.rawRustedIronNugget.itemID ||
                heat_level == 3 && item_id == RegistryInit.rustedIronNugget.itemID ||
                heat_level == 3 && item_id == RegistryInit.rawAncientMetalNugget.itemID)
            speed_bonus = 2;

        if (heat_level == 4 && item_id == RegistryInit.rawRustedIronNugget.itemID ||
                heat_level == 4 && item_id == RegistryInit.rustedIronNugget.itemID ||
                heat_level == 4 && item_id == RegistryInit.rawAncientMetalNugget.itemID)
            speed_bonus = 4;

        if (heat_level == 5 && item_id == RegistryInit.rawRustedIronNugget.itemID ||
                heat_level == 5 && item_id == RegistryInit.rustedIronNugget.itemID ||
                heat_level == 5 && item_id == RegistryInit.rawAncientMetalNugget.itemID)
            speed_bonus = 8;


        if (heat_level == 4 && item_id == RegistryInit.rawMithrilNugget.itemID)
            speed_bonus = 2;

        if (heat_level == 5 && item_id == RegistryInit.rawMithrilNugget.itemID)
            speed_bonus = 4;


        if (heat_level == 5 && item_id == RegistryInit.rawAdamantiumNugget.itemID)
            speed_bonus = 2;
        original *= speed_bonus;
        return original;
    }

}
