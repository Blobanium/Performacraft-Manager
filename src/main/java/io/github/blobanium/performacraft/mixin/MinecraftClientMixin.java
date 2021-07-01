package io.github.blobanium.performacraft.mixin;

import io.github.blobanium.performacraft.PerformacraftManager;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.SharedConstants;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Session;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    private static int windowTitleCount = 0;

    @Inject(at = @At(value = "RETURN"), method = "getWindowTitle", cancellable = true)
    private void getWindowTitle(CallbackInfoReturnable<String> cir){
        windowTitleCount = windowTitleCount + 1;
        PerformacraftManager.LOGGER.debug("Setting Window Title (" + windowTitleCount + ")");
        try {
            cir.setReturnValue("Minecraft " + SharedConstants.getGameVersion().getName() + " / Performacraft " + FabricLoader.getInstance().getModContainer("performacraft").get().getMetadata().getVersion() + " / " + MinecraftClient.getInstance().getSession().getUsername());
        } catch (NoClassDefFoundError e) {
            cir.setReturnValue("Minecraft " + SharedConstants.getGameVersion().getName() + " / Performacraft " + FabricLoader.getInstance().getModContainer("performacraft").get().getMetadata().getVersion());
        }
    }
}
