package com.litewolf101.magicmayhem.block;

import codechicken.lib.vec.Cuboid6;
import com.google.common.collect.Lists;
import com.litewolf101.magicmayhem.client.render.RenderBlockSpecial;
import com.litewolf101.magicmayhem.network.GuiHandler;
import com.litewolf101.magicmayhem.tile.TileEntityTotemUpgradeBase;
import com.litewolf101.magicmayhem.util.Constants;
import de.kitsunealex.silverfish.block.IRenderBoundsProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class BlockTotemUpgradeBase extends BlockMM<TileEntityTotemUpgradeBase> implements IRenderBoundsProvider {

    @SideOnly(Side.CLIENT)
    private TextureAtlasSprite[] texture;

    public BlockTotemUpgradeBase() {
        super("totem_upgrade_base", Material.WOOD);
        setHardness(1.3F);
        setResistance(1.4F);
    }

    @Nullable
    @Override
    public TileEntityTotemUpgradeBase createNewTileEntity(World world, int meta) {
        return new TileEntityTotemUpgradeBase();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        player.openGui(Constants.MODID, GuiHandler.TOTEM_UPGRADE_BASE, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(TextureMap map) {
        texture = new TextureAtlasSprite[2];
        texture[0] = map.registerSprite(new ResourceLocation(Constants.MODID, String.format("blocks/%s_inner", getBlockName())));
        texture[1] = map.registerSprite(new ResourceLocation(Constants.MODID, String.format("blocks/%s_outer", getBlockName())));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getTexture(int meta, int side) {
        return texture[side / 100];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public List<Cuboid6> getRenderBounds(int meta) {
        return Lists.newArrayList(new Cuboid6(1D, 1D, 1D, 15D, 15D, 15D), new Cuboid6(0D, 0D, 0D, 16D, 16D, 16D));
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

    @SuppressWarnings("deprecation")
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isFullCube(IBlockState state) {
        return false;
    }

}
