package litewolf101.wuffysmagicmayhem.commands;

import litewolf101.wuffysmagicmayhem.Reference;
import net.minecraft.command.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;


import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by LiteWolf101 on 6/9/2018.
 */
public class CommandWuffysMagicMayhem extends CommandBase {
    private final String name = "wuffysmagicmayhem";
    private final List<String> commands = new ArrayList<String>();

    public CommandWuffysMagicMayhem() {
        commands.add("data");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "wuffysmagicmayhem <command>\n"
            + "data: Displays The mod name, current version of mod and current version of minecraft.";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (!(sender instanceof EntityPlayerMP)) {
            throw new WrongUsageException("message.command.onlyInGame");
        }
        EntityPlayerMP player = (EntityPlayerMP) sender;
        WorldServer world = player.getServerWorld();
        if (args.length != 1) {
            throw new WrongUsageException(getUsage(sender));
        }
        if (args[0].equals("data")) {
            sender.sendMessage(new TextComponentString(TextFormatting.BLUE + "\u2605" + "MOD: " + TextFormatting.RESET + Reference.NAME + "\n" + TextFormatting.BLUE + "\u2605" + "VERSION: " + TextFormatting.RESET + Reference.VERSION + "\n" + TextFormatting.BLUE + "\u2605" + "MINECRAFT VERSION: " + TextFormatting.RESET + Reference.ACCEPTED_MINECRAFT_VERSIONS));
        }
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return args.length == 1 ? commands : Collections.<String> emptyList();
    }
}
