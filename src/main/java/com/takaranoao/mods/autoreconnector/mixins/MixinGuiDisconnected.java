package com.takaranoao.mods.autoreconnector.mixins;

import com.takaranoao.mods.autoreconnector.AutoConnector;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.resources.I18n;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiDisconnected.class)
public class MixinGuiDisconnected {
    @Shadow private int textHeight;
    @Inject(method = "render", at = @At("RETURN"))
    private void onRender (int p_render_1_, int p_render_2_, float p_render_3_, CallbackInfo ci){
        if(AutoConnector.lastestServerData == null)return;
        Minecraft mc = Minecraft.getInstance();
        FontRenderer fontRenderer = mc.fontRenderer;
        if( mc.currentScreen == null) return;
        int width = mc.currentScreen.width;
        int height = mc.currentScreen.height;
        mc.currentScreen.drawCenteredString(
                fontRenderer,
                I18n.format("autoReconnector.waitingTime", (AutoConnector.MAX_TICK - AutoConnector.disconnectTick)/20),
                width/2,
                height - this.textHeight / 2 - fontRenderer.FONT_HEIGHT * 2,
                0xffffff);
    }
}
