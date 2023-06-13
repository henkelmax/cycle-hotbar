package de.maxhenkel.cyclehotbar;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public class KeyEvents {

    private static final Minecraft mc = Minecraft.getInstance();

    public static KeyMapping CYCLE;

    public static void init() {
        CYCLE = KeyBindingHelper.registerKeyBinding(new KeyMapping("key.cyclehotbar.cycle", GLFW.GLFW_KEY_Z, "key.categories.misc"));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (CYCLE.consumeClick()) {
                if (mc.player != null) {
                    cycleHotbar();
                }
            }
        });
    }

    public static void cycleHotbar() {
        for (int i = 0; i < 9; i++) {
            ItemMover.sendSlotClick(ItemMover.translateSlot(i));
            ItemMover.sendSlotClick(ItemMover.translateSlot(i + 9));
            ItemMover.sendSlotClick(ItemMover.translateSlot(i + 18));
            ItemMover.sendSlotClick(ItemMover.translateSlot(i + 27));
            ItemMover.sendSlotClick(ItemMover.translateSlot(i));
        }
    }
}
