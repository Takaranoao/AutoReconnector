package com.takaranoao.mods.autoreconnector;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiConnecting;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.multiplayer.ServerData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AutoConnector {
    public static ServerData lastestServerData;
    public static int disconnectTick = 0;
    public static final int MAX_TICK = 20*15;
    public static void onDoneLoading(){
        LogManager.getLogger().info("Loading Auto Reconnect");
    }
    public static void clientTick(){
        Minecraft mc = Minecraft.getInstance();
        if(mc.world != null && mc.getCurrentServerData() != null){
            lastestServerData = mc.getCurrentServerData();
        }
        if(mc.currentScreen instanceof GuiDisconnected){
            disconnectTick++;
            if(disconnectTick >= MAX_TICK && lastestServerData!=null){
                mc.displayGuiScreen(new GuiConnecting(new GuiMainMenu(), mc, lastestServerData));
            }
        }else{
            disconnectTick = 0;
        }
    }
}
