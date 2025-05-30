package com.kingpixel.cobblenotify.Model;

import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class VanishIntegration {

    public static boolean isVanished(@NotNull Entity entity) {
        try {
            Class<?> vanishManager = Class.forName("me.drex.vanish.util.VanishManager");
            return (boolean) vanishManager
                    .getMethod("isVanished", Entity.class)
                    .invoke(null, entity);
        } catch (Exception ignored) {
            return false;
        }
    }

    public static boolean isVanished(@NotNull MinecraftServer server, @NotNull UUID uuid) {
        try {
            Class<?> vanishManager = Class.forName("me.drex.vanish.util.VanishManager");
            return (boolean) vanishManager
                    .getMethod("isVanished", MinecraftServer.class, UUID.class)
                    .invoke(null, server, uuid);
        } catch (Exception ignored) {
            return false;
        }
    }
}
