package com.litewolf101.magicmayhem.client.render;

import codechicken.lib.render.CCModel;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.buffer.BakingVertexBuffer;
import codechicken.lib.vec.Translation;
import codechicken.lib.vec.Vector3;
import codechicken.lib.vec.uv.IconTransformation;
import com.litewolf101.magicmayhem.block.IBioluminescence;
import de.kitsunealex.silverfish.client.render.ModelCache;
import de.kitsunealex.silverfish.client.render.RenderingRegistry;
import de.kitsunealex.silverfish.client.render.SimpleBakedModel;
import de.kitsunealex.silverfish.client.render.block.IBlockRenderingHandler;
import de.kitsunealex.silverfish.util.BlockUtils;
import de.kitsunealex.silverfish.util.ItemUtils;
import de.kitsunealex.silverfish.util.ModelUtils;
import de.kitsunealex.silverfish.util.RenderUtils;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderBlockSpecial implements IBlockRenderingHandler {

    //TODO: this should probably be moved into Silverfish...

    public static EnumBlockRenderType RENDER_TYPE;

    static {
        RENDER_TYPE = RenderingRegistry.getNextAvailableBlockType();
        RenderingRegistry.register(new RenderBlockSpecial());
    }

    @Override
    public boolean renderBlock(IBlockAccess world, BlockPos pos, IBlockState state, BufferBuilder buffer) {
        CCModel[] model = ModelUtils.generate(BlockUtils.getRenderBounds(world, pos, state));

        if(state.getBlock() instanceof IBioluminescence) {
            IBioluminescence iface = (IBioluminescence)state.getBlock();
            CCRenderState renderState = CCRenderState.instance();
            renderState.reset();
            renderState.bind(buffer);

            for(int i = 0; i < model.length; i++) {
                for(int j = 0; j < 6; j++) {
                    int index = i * 100 + j;

                    if(iface.shouldGlow(world, pos, state, index)) {
                        renderState.brightness = 0x00F000F0;
                    }

                    TextureAtlasSprite texture = BlockUtils.getTexture(world, pos, state, index);
                    renderState.baseColour = BlockUtils.getColorMultiplier(world, pos, state, index);
                    model[i].copy().apply(new Translation(Vector3.fromBlockPos(pos))).render(renderState, j * 4, j * 4 + 4, new IconTransformation(texture));
                }
            }

            return true;
        }
        else {
            String key = BlockUtils.getRenderKey(world, pos, state);

            if(!ModelCache.contains(key)) {
                CCRenderState renderState = CCRenderState.instance();
                BakingVertexBuffer parentBuffer = BakingVertexBuffer.create();
                parentBuffer.begin(GL11.GL_QUADS, DefaultVertexFormats.ITEM);
                renderState.reset();
                renderState.bind(parentBuffer);

                for(int i = 0; i < model.length; i++) {
                    for(int j = 0; j < 6; j++) {
                        int index = i * 100 + j;
                        TextureAtlasSprite texture = BlockUtils.getTexture(world, pos, state, index);
                        renderState.baseColour = BlockUtils.getColorMultiplier(world, pos, state, index);
                        model[i].render(renderState, j * 4, j * 4 + 4, new IconTransformation(texture));
                    }
                }

                parentBuffer.finishDrawing();
                ModelCache.put(key, new SimpleBakedModel(parentBuffer.bake()));
            }

            return RenderUtils.renderModel(ModelCache.get(key), world, pos, state, buffer);
        }
    }

    @Override
    public void handleRenderBlockDamage(IBlockAccess world, BlockPos pos, IBlockState state, TextureAtlasSprite texture, BufferBuilder buffer) {
        CCModel[] model = ModelUtils.generate(BlockUtils.getRenderBounds(world, pos, state));
        CCRenderState renderState = CCRenderState.instance();

        for(int i = 0; i < model.length; i++) {
            model[i].copy().apply(new Translation(Vector3.fromBlockPos(pos))).render(renderState, new IconTransformation(texture));
        }
    }

    @Override
    public void renderItem(ItemStack stack, ItemCameraTransforms.TransformType transformType) {
        CCModel[] model = ModelUtils.generate(ItemUtils.getRenderBounds(stack));

        if(Block.getBlockFromItem(stack.getItem()) instanceof IBioluminescence) {
            IBioluminescence iface = (IBioluminescence)Block.getBlockFromItem(stack.getItem());
            BufferBuilder buffer = Tessellator.getInstance().getBuffer();
            CCRenderState renderState = CCRenderState.instance();
            GlStateManager.pushMatrix();
            buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.ITEM);
            renderState.reset();
            renderState.bind(buffer);

            for(int i = 0; i < model.length; i++) {
                for(int j = 0; j < 6; j++) {
                    int index = i * 100 + j;

                    if(iface.shouldGlow(stack, index)) {
                        renderState.brightness = 0x00F000F0;
                        renderState.pushLightmap();
                    }

                    TextureAtlasSprite texture = ItemUtils.getTexture(stack, index);
                    renderState.baseColour = ItemUtils.getColorMultiplier(stack, index);
                    model[i].render(renderState, j * 4, j * 4 + 4, new IconTransformation(texture));
                }
            }

            Tessellator.getInstance().draw();
            GlStateManager.popMatrix();
        }
        else {
            String key = ItemUtils.getRenderKey(stack);

            if(!ModelCache.contains(key)) {
                CCRenderState renderState = CCRenderState.instance();
                BakingVertexBuffer parentBuffer = BakingVertexBuffer.create();
                parentBuffer.begin(GL11.GL_QUADS, DefaultVertexFormats.ITEM);
                renderState.reset();
                renderState.bind(parentBuffer);

                for(int i = 0; i < model.length; i++) {
                    for(int j = 0; j < 6; j++) {
                        int index = i * 100 + j;
                        TextureAtlasSprite texture = ItemUtils.getTexture(stack, index);
                        renderState.baseColour = ItemUtils.getColorMultiplier(stack, index);
                        model[i].render(renderState, j * 4, j * 4 + 4, new IconTransformation(texture));
                    }
                }

                parentBuffer.finishDrawing();
                ModelCache.put(key, new SimpleBakedModel(parentBuffer.bake()));
            }

            GlStateManager.pushMatrix();
            GlStateManager.translate(0.5D, 0.5D, 0.5D);
            RenderUtils.renderModel(ModelCache.get(key), stack);
            GlStateManager.popMatrix();
        }
    }

    @Override
    public EnumBlockRenderType getRenderType() {
        return RENDER_TYPE;
    }

}
