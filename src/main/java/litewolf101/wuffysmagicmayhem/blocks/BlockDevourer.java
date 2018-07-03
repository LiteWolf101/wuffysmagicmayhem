package litewolf101.wuffysmagicmayhem.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by LiteWolf101 on 6/19/2018.
 */
public class BlockDevourer extends Block {
    public BlockDevourer(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setSoundType(SoundType.ANVIL);
        setTickRandomly(true);
        setBlockUnbreakable();
    }
    @Override
    public int tickRate(World worldIn) {
        return 10;
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        world.scheduleUpdate(pos, this, 10);
        randomDisplayTick(state, world, pos, rand);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        world.scheduleUpdate(pos, this, 10);
    }
    @Override
    public void randomDisplayTick(IBlockState state, World world, BlockPos pos, Random rand) {
        double d0 = (double)pos.getX();
        double d1 = (double)pos.getY();
        double d2 = (double)pos.getZ();
        Random random = new Random();
        double randomX = random.nextInt(10);
        double randomY = random.nextInt(10);
        double randomZ = random.nextInt(10);
        double randdoubX = random.nextInt(20);
        double randdoubY = random.nextInt(20);
        double randdoubZ = random.nextInt(20);
        pos = new BlockPos(d0 + randdoubX - 10, d1 + randdoubY - 10, d2 +randdoubZ - 10);
        world.setBlockToAir(pos);
        world.playSound(null, d0 + randdoubX - 10, d1 + randdoubY - 10, d2 +randdoubZ - 10, SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.MASTER, 0.5F, 1.0F);

        world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0 + (randomX / 10), d1 + (randomY / 10), d2 + (randomZ / 10), 0.0D, 0.1D, 0.0D);
        world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d0 + randdoubX - 10 + 0.5, d1 + randdoubY - 10 + 0.5, d2 +randdoubZ - 10 + 0.5, 0.0D, 0.0D, 0.0D, 100);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_ENDERDRAGON_GROWL, SoundCategory.MASTER, 0.5F, 0.1F);

        Side fmlside = FMLCommonHandler.instance().getEffectiveSide();

        if (fmlside == Side.CLIENT) {
            sendWarning(placer);
        }
        //add advancement: Title:"WHY WOULD YOU PUT THIS DOWN?!" Desc: "U CRAZY BRO"
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.RED + "WARNING: " + TextFormatting.DARK_RED + "This block is very destructive!");
    }

    @SideOnly(Side.CLIENT)
    public void sendWarning(EntityLivingBase player) {
        player.sendMessage(new TextComponentTranslation(TextFormatting.RED + "WARNING: " + TextFormatting.DARK_RED + "This block is very destructive!"));
    }
}
