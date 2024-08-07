package mod.mitecreation.tileentity;

import net.minecraft.EntityPlayer;
import net.minecraft.IInventory;
import net.minecraft.ItemStack;
import net.minecraft.TileEntity;

import java.util.Arrays;

public class ReforgeTileEntity extends TileEntity implements IInventory {

    private final ItemStack[] reforgeContents = new ItemStack[7];


    @Override
    public int getSizeInventory() {
        return this.reforgeContents.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return this.reforgeContents[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {
        if (this.reforgeContents[i] != null) {
            ItemStack var3;

            if (this.reforgeContents[i].stackSize <= j) {
                var3 = this.reforgeContents[i];
                this.reforgeContents[i] = null;
            } else {
                var3 = this.reforgeContents[i].splitStack(j);

                if (this.reforgeContents[i].stackSize == 0) {
                    this.reforgeContents[i] = null;
                }

            }
            this.onInventoryChanged();
            return var3;
        } else {
            return null;
        }
    }


    @Override
    public ItemStack getStackInSlotOnClosing(int i) {
        if (this.reforgeContents[i] != null) {
            ItemStack var2 = this.reforgeContents[i];
            this.reforgeContents[i] = null;
            return var2;
        } else {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemStack) {
        this.reforgeContents[i] = itemStack;

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
            itemStack.stackSize = this.getInventoryStackLimit();
        }

        this.onInventoryChanged();
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) == this
                && entityPlayer.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openChest() {}

    @Override
    public void closeChest() {}

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        return true;
    }

    @Override
    public void destroyInventory() {
        Arrays.fill(this.reforgeContents, null);
    }
}
