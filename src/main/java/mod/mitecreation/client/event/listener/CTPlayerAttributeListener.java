package mod.mitecreation.client.event.listener;

import moddedmite.rustedironcore.api.event.listener.IPlayerAttributeListener;

public class CTPlayerAttributeListener implements IPlayerAttributeListener {
    @Override
    public int onLevelMinLimitModify(int original) {
        return -50;
    }
}
