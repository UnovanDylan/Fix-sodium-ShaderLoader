package com.coco.fixsodiumshaderloader.mixin;

import java.io.InputStream;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.caffeinemc.mods.sodium.client.gl.shader.ShaderLoader;

@Mixin(value = ShaderLoader.class, remap = false)
public class MixinShaderLoader {
    @Redirect(method = "getShaderSource(Lnet/minecraft/resources/ResourceLocation;)Ljava/lang/String;", at = @At(value = "INVOKE", target = "Ljava/lang/Class;getResourceAsStream(Ljava/lang/String;)Ljava/io/InputStream;"))
    private static InputStream redirectGetResourceAsStream(Class<?> clazz, String path) {
        return ShaderLoader.class.getClassLoader().getResourceAsStream(path);
    }
}
