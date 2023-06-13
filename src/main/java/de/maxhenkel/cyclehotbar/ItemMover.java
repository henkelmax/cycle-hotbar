package de.maxhenkel.cyclehotbar;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.InventoryMenu;

public class ItemMover {

    private static final Minecraft mc = Minecraft.getInstance();

    public static void move(int source, int dest) {
        if (source == dest) {
            return;
        }
        sendSlotClick(translateSlot(source));
        sendSlotClick(translateSlot(dest));
        sendSlotClick(translateSlot(source));
    }

    public static void sendSlotClick(int slot) {
        if (mc.gameMode == null || mc.player == null) {
            return;
        }

        if (!(mc.player.containerMenu instanceof InventoryMenu) && !(mc.player.containerMenu instanceof CreativeModeInventoryScreen.ItemPickerMenu)) { //TODO check
            return;
        }
        mc.gameMode.handleInventoryMouseClick(mc.player.containerMenu.containerId, slot, 0, ClickType.PICKUP, mc.player);
    }

    public static int translateSlot(int id) {
        if (id >= 0 && id < 9) {
            return id + Inventory.INVENTORY_SIZE;
        }
        if (id == Inventory.SLOT_OFFHAND) {
            return Inventory.INVENTORY_SIZE + 9;
        }
        return id;
    }
}
