package fi.dy.masa.malilib.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.class_9779;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;

import fi.dy.masa.malilib.event.RenderEventHandler;

@Mixin(InGameHud.class)
public abstract class MixinInGameHud
{
    @Shadow @Final private MinecraftClient client;

    @Inject(method = "render", at = @At("RETURN"))
    private void onGameOverlayPost(DrawContext context, class_9779 arg, CallbackInfo ci)
    {
        // FIXME class_9779 --> partialTicks ?
        ((RenderEventHandler) RenderEventHandler.getInstance()).onRenderGameOverlayPost(context, this.client, arg);
    }
}
