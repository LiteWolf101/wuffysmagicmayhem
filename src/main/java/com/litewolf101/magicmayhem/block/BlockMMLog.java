package com.litewolf101.magicmayhem.block;

import com.litewolf101.magicmayhem.util.Constants;
import com.litewolf101.magicmayhem.util.EnumTreeType;
import de.kitsunealex.silverfish.util.ISubtypeHolder;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

public class BlockMMLog extends BlockLogBase implements ISubtypeHolder {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[][] texture;

    public BlockMMLog() {
        super("log", Material.WOOD);
        setHardness(1.5F);
        setResistance(1.2F);
    }

    @Override
    public String[] getSubNames() {
        return Arrays.stream(EnumTreeType.values()).map(EnumTreeType::getName).toArray(String[]::new);
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(this, 1, getMetaFromState(state) >> 2 & 0x3);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(TextureMap map) {
        texture = new TextureAtlasSprite[getSubNames().length][2];

        for(int i = 0; i < texture.length; i++) {
            String name = String.format("blocks/%s_%s", getBlockName(), getSubNames()[i]);
            texture[i][0] = map.registerSprite(new ResourceLocation(Constants.MODID, String.format("%s_side", name)));
            texture[i][1] = map.registerSprite(new ResourceLocation(Constants.MODID, String.format("%s_top", name)));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getTexture(int meta, int side) {
        return side < 2 ? texture[meta][1] : texture[meta][0];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getTexture(IBlockAccess world, BlockPos pos, IBlockState state, int side) {
        int meta = getMetaFromState(state);
        int variant = meta >> 2 & 0x3;
        int rotation = meta & 0x3;

        if(rotation == 0) {
            return side == 4 || side == 5 ? texture[variant][1] : texture[variant][0];
        }
        else if(rotation == 2) {
            return side == 2 || side == 3 ? texture[variant][1] : texture[variant][0];
        }
        else {
            return side < 2 ? texture[variant][1] : texture[variant][0];
        }
    }

}
