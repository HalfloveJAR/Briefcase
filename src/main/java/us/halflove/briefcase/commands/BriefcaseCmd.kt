package us.halflove.briefcase.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import us.halflove.briefcase.gui.Hopper
import us.halflove.briefcase.math.CodeGenerator

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object BriefcaseCmd : CommandExecutor{

    override fun onCommand(sender: CommandSender, cmd: Command, label: String, args: Array<out String>): Boolean {

        if(args.isEmpty()){
            CmdHelpFunction.helpCommand(sender)
            return true
        }

        when (args[0]) {
            "newcode" -> sender.sendMessage(CodeGenerator.generateCode().toString())
            "modify" -> Hopper.openHopper(sender as Player)
            "help" -> CmdHelpFunction.helpCommand(sender)
            else -> {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUnknown argument, try /briefcase help"))
            }
        }

        return true
    }

}