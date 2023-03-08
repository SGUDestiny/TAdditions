package net.tadditions.mod.client.renderers.sky;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ISkyRenderHandler;
import net.tardis.mod.Tardis;
import net.tardis.mod.client.renderers.sky.Planet;
import org.lwjgl.opengl.GL11;

import java.util.Random;

@OnlyIn(Dist.CLIENT) //This is one of the few cases where we can be using OnlyIn - Vanilla uses this is a marker hack to strip bytecode from one side (server or client)
public class TagreaSkyRenderer implements ISkyRenderHandler {

    private VertexBuffer STAR_VBO;
    private VertexBuffer PLANET_VBO;
    private final ResourceLocation PLANET_TEXTURE = new ResourceLocation(Tardis.MODID, "textures/sky/blackhole.png");
    private final VertexFormat FORMAT = DefaultVertexFormats.POSITION_COLOR;
    private final VertexFormat FORMAT_PLANET = DefaultVertexFormats.POSITION_TEX;

    @Override
    public void render(int ticks, float partialTicks, MatrixStack matrixStack, ClientWorld world, Minecraft mc) {
        matrixStack.push();
        BufferBuilder bb = Tessellator.getInstance().getBuffer();

        /** Star Renderer */
        RenderSystem.disableTexture();

        //Disable stuff
        RenderSystem.depthMask(false);
        RenderSystem.disableFog();
        RenderSystem.disableAlphaTest();
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.shadeModel(7425);

        this.generateOrDrawStars(bb, matrixStack);

        RenderSystem.enableAlphaTest();
        RenderSystem.depthMask(true);
        RenderSystem.disableBlend();
        RenderSystem.shadeModel(7424);

        /** Star Renderer End */

        /** Planet Renderer */
        RenderSystem.enableTexture();
        RenderSystem.disableAlphaTest();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.depthMask(false);

        matrixStack.push();//Planet push
        matrixStack.rotate(Vector3f.ZP.rotation(world.getCelestialAngleRadians(partialTicks)));
        matrixStack.translate(-10, 60, 60);
        float scale = 1.125F;
        matrixStack.scale(scale, scale, scale);
        Minecraft.getInstance().getTextureManager().bindTexture(PLANET_TEXTURE);

        this.generatePlanets(bb, matrixStack);

        matrixStack.pop(); //Planet stack end

        RenderSystem.disableTexture();
        //Re enable properties
        RenderSystem.enableAlphaTest();
        RenderSystem.disableBlend();
        RenderSystem.depthMask(true);

        RenderSystem.enableFog();
        /** Planet Renderer End */

        matrixStack.pop();
    }

    /** Sets up Star VBO, renders and draws data*/
    private void generateOrDrawStars(BufferBuilder bufferbuilder, MatrixStack matrixStack){
        if (STAR_VBO == null) { //If the vbo is null (which it is when first called), initialise it and render our data onto it
            this.STAR_VBO = new VertexBuffer(this.FORMAT);
            this.renderSky(bufferbuilder, matrixStack);
            bufferbuilder.finishDrawing();
            this.STAR_VBO.upload(bufferbuilder);
        }
        if (STAR_VBO != null) { //Once our rendering is done, setup the buffer and send the quads to the gpu
            STAR_VBO.bindBuffer();
            FORMAT.setupBufferState(0L);
            STAR_VBO.draw(matrixStack.getLast().getMatrix(), GL11.GL_QUADS);
            VertexBuffer.unbindBuffer();
            FORMAT.clearBufferState();
        }

    }

    /** Sets up Planet VBO, renders and draws data*/
    private void generatePlanets(BufferBuilder bufferbuilder, MatrixStack matrixStack){
        if (PLANET_VBO == null) {
            this.PLANET_VBO = new VertexBuffer(this.FORMAT);
            this.renderPlanets(bufferbuilder, matrixStack);
            bufferbuilder.finishDrawing();
            this.PLANET_VBO.upload(bufferbuilder);
        }

        if(PLANET_VBO != null) {
            PLANET_VBO.bindBuffer();
            FORMAT_PLANET.setupBufferState(0L);
            PLANET_VBO.draw(matrixStack.getLast().getMatrix(), GL11.GL_QUADS);
            VertexBuffer.unbindBuffer();
            FORMAT_PLANET.clearBufferState();
        }
    }

    /** Renders Sun and Earth planets. Requires {@linkplain MatrixStack} context so that the buffer builder will be able to take our matrix stack transforms*/
    private void renderPlanets(BufferBuilder bb, MatrixStack ms) {
        bb.begin(GL11.GL_QUADS, FORMAT_PLANET);
        Matrix4f matrix4f = ms.getLast().getMatrix();
    }

    private void renderSky(BufferBuilder bb, MatrixStack ms) {
        bb.begin(GL11.GL_QUADS, FORMAT);
        Random rand = new Random(666L);
        int skySize = 190;
    }

    private void renderPlanet(BufferBuilder bb, Matrix4f matrix4f, float x, float y, float z, float size, Planet planet) {
        //NORTH
        bb.pos(matrix4f, x, y, z).tex(planet.maxHU, planet.minHV).endVertex();
        bb.pos(matrix4f, x, y + size, z).tex(planet.maxHU, planet.maxHV).endVertex();
        bb.pos(matrix4f, x - size, y + size, z).tex(planet.minHU, planet.maxHV).endVertex();
        bb.pos(matrix4f, x - size, y, z).tex(planet.minHU, planet.minHV).endVertex();

        //UP
        bb.pos(matrix4f, x - size, y + size, z - size).tex(planet.minVU, planet.minVV).endVertex();
        bb.pos(matrix4f, x - size, y + size, z).tex(planet.minVU, planet.maxVV).endVertex();
        bb.pos(matrix4f, x, y + size, z).tex(planet.maxVU, planet.maxVV).endVertex();
        bb.pos(matrix4f, x, y + size, z - size).tex(planet.maxVU, planet.minVV).endVertex();

        //East
        bb.pos(matrix4f, x, y, z - size).tex(planet.minHU, planet.minHV).endVertex();
        bb.pos(matrix4f, x, y + size, z - size).tex(planet.minHU, planet.maxHV).endVertex();
        bb.pos(matrix4f, x, y + size, z).tex(planet.maxHU, planet.maxHV).endVertex();
        bb.pos(matrix4f, x, y, z).tex(planet.maxHU, planet.minHV).endVertex();

        //West
        bb.pos(matrix4f, x - size, y, z).tex(planet.minHU, planet.minHV).endVertex();
        bb.pos(matrix4f, x - size, y + size, z).tex(planet.minHU, planet.maxHV).endVertex();
        bb.pos(matrix4f, x - size, y + size, z - size).tex(planet.maxHU, planet.maxHV).endVertex();
        bb.pos(matrix4f, x - size, y, z - size).tex(planet.maxHU, planet.minHV).endVertex();

        //SOUTH
        bb.pos(matrix4f, x - size, y, z - size).tex(planet.minHU, planet.minHV).endVertex();
        bb.pos(matrix4f, x - size, y + size, z - size).tex(planet.minHU, planet.maxHV).endVertex();
        bb.pos(matrix4f, x, y + size, z - size).tex(planet.maxHU, planet.maxHV).endVertex();
        bb.pos(matrix4f, x, y, z - size).tex(planet.maxHU, planet.minHV).endVertex();

        //Down
        bb.pos(matrix4f, x, y, z - size).tex(planet.maxVU, planet.minVV).endVertex();
        bb.pos(matrix4f, x, y, z).tex(planet.maxVU, planet.maxVV).endVertex();
        bb.pos(matrix4f, x - size, y, z).tex(planet.minVU, planet.maxVV).endVertex();
        bb.pos(matrix4f, x - size, y, z - size).tex(planet.minVU, planet.minVV).endVertex();

    }

    private void renderStarUp(BufferBuilder bb, Matrix4f matrix4f, float x, float y, float z){
        float size = 0.5F;
        bb.pos(matrix4f, x, y, z).color(1F, 1, 1, 1).endVertex();
        bb.pos(matrix4f, x + size, y, z).color(1F, 1, 1, 1).endVertex();
        bb.pos(matrix4f, x + size, y, z + size).color(1F, 1, 1, 1).endVertex();
        bb.pos(matrix4f, x, y, z + size).color(1F, 1, 1, 1).endVertex();
    }

    private void renderStarSouth(BufferBuilder bb, Matrix4f matrix4f, float x, float y, float z){
        float size = 0.5F;
        bb.pos(matrix4f, x, y, z).color(1F, 1, 1, 1).endVertex();
        bb.pos(matrix4f, x, y + size, z).color(1F, 1, 1, 1).endVertex();
        bb.pos(matrix4f, x + size, y + size, z).color(1F, 1, 1, 1).endVertex();
        bb.pos(matrix4f, x + size, y, z).color(1F, 1, 1, 1).endVertex();
    }

    private void renderStarWest(BufferBuilder bb, Matrix4f matrix4f, float x, float y, float z){
        float size = 0.5F;
        bb.pos(matrix4f, x, y, z).color(1F, 1, 1, 1).endVertex();
        bb.pos(matrix4f, x, y, z - size).color(1F, 1, 1, 1).endVertex();
        bb.pos(matrix4f, x, y + size, z - size).color(1F, 1, 1, 1).endVertex();
        bb.pos(matrix4f, x, y + size, z).color(1F, 1, 1, 1).endVertex();
    }

    private void renderStarNorth(BufferBuilder bb, Matrix4f matrix4f, float x, float y, float z){
        float size = 0.5F;
        bb.pos(matrix4f, x, y, z).color(1F, 1, 1, 1).endVertex();
        bb.pos(matrix4f, x, y + size, z).color(1F, 1, 1, 1).endVertex();
        bb.pos(matrix4f, x - size, y + size, z).color(1F, 1, 1, 1).endVertex();
        bb.pos(matrix4f, x - size, y, z).color(1F, 1, 1, 1).endVertex();
    }

    private void renderStarEast(BufferBuilder bb, Matrix4f matrix4f, float x, float y, float z){
        float size = 0.5F;
        bb.pos(matrix4f, x, y, z).color(1F, 1, 1, 1).endVertex();
        bb.pos(matrix4f, x, y + size, z).color(1F, 1, 1, 1).endVertex();
        bb.pos(matrix4f, x, y + size, z - size).color(1F, 1, 1, 1).endVertex();
        bb.pos(matrix4f, x, y, z - size).color(1F, 1, 1, 1).endVertex();
    }

    private void renderStarDown(BufferBuilder bb, Matrix4f matrix4f, float x, float y, float z){
        float size = 0.5F;
        bb.pos(matrix4f, x, y, z).color(1F, 1, 1, 1).endVertex();
        bb.pos(matrix4f, x, y, z + size).color(1F, 1, 1, 1).endVertex();
        bb.pos(matrix4f, x + size, y, z + size).color(1F, 1, 1, 1).endVertex();
        bb.pos(matrix4f, x + size, y, z).color(1F, 1, 1, 1).endVertex();
    }

}


