package com.litewolf101.magicmayhem.block;

import codechicken.lib.vec.Cuboid6;
import com.google.common.collect.Lists;
import com.litewolf101.magicmayhem.client.render.RenderBlockSpecial;
import com.litewolf101.magicmayhem.util.Constants;
import com.litewolf101.magicmayhem.util.EnumTreeType;
import de.kitsunealex.silverfish.block.IRenderBoundsProvider;
import de.kitsunealex.silverfish.util.ISubtypeHolder;
import de.kitsunealex.silverfish.util.MathUtils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;
import java.util.List;

public class BlockMMLeaves extends BlockLeavesBase implements ISubtypeHolder, IRenderBoundsProvider {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[][] texture;

    public BlockMMLeaves() {
        super("leaves");
    }

    @Override
    public String[] getSubNames() {
        return Arrays.stream(EnumTreeType.values()).map(EnumTreeType::getName).toArray(String[]::new);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(TextureMap map) {
        texture = new TextureAtlasSprite[getSubNames().length][2];

        for(int i = 0; i < texture.length; i++) {
            String name = String.format("blocks/%s_%s", getBlockName(), getSubNames()[i]);

            if(isLayered(i)) {
                texture[i][0] = map.registerSprite(new ResourceLocation(Constants.MODID, String.format("%s_inner", name)));
                texture[i][1] = map.registerSprite(new ResourceLocation(Constants.MODID, String.format("%s_outer", name)));
            }
            else {
                texture[i][0] = map.registerSprite(new ResourceLocation(Constants.MODID, name));
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getTexture(int meta, int side) {
        return isLayered(meta) ? texture[meta][side / 100] : texture[meta][0];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public List<Cuboid6> getRenderBounds(int meta) {
        if(isLayered(meta)) {
            return Lists.newArrayList(new Cuboid6(1D, 1D, 1D, 15D, 15D, 15D), new Cuboid6(0D, 0D, 0D, 16D, 16D, 16D));
        }
        else {
            return Lists.newArrayList(MathUtils.FULL);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return RenderBlockSpecial.RENDER_TYPE;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean canRenderInLayer(IBlockState state, BlockRenderLayer layer) {
        return layer == BlockRenderLayer.TRANSLUCENT;
    }

    @SideOnly(Side.CLIENT)
    private boolean isLayered(int meta) {
        return meta == 0 || meta == 3;
    }

}
