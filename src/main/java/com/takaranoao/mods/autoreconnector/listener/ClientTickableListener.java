package com.takaranoao.mods.autoreconnector.listener;

import com.takaranoao.mods.autoreconnector.AutoConnector;
import net.minecraft.client.Minecraft;
import org.dimdev.rift.listener.client.ClientTickable;

public class ClientTickableListener implements ClientTickable {
    @Override
    public void clientTick(Minecraft client) {
        AutoConnector.clientTick();
    }
}
