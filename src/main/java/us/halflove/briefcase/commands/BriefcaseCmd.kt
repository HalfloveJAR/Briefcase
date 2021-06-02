package us.halflove.briefcase.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import us.halflove.briefcase.gui.Hopper
import us.halflove.briefcase.item.BriefcaseItem
import us.halflove.briefcase.math.CodeGenerator
import us.halflove.briefcase.passcode.InputCode

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

        //If there are no arguments used
        if(args.isEmpty()){
            CmdHelpFunction.helpCommand(sender)
            return true
        }

        //Switch/when statement that checks for specific arguments
        when (args[0]) {
            "newcode" -> {
                CodeGenerator.generateCode()
                sender.sendMessage("New code created, see console for details.")
            }
            "modify" -> Hopper.openHopper(sender as Player)
            "help" -> CmdHelpFunction.helpCommand(sender)
            "input" -> InputCode.startInputCode(sender as Player)
            "get" -> BriefcaseItem.getBriefcaseItem(sender as Player, true)
            else -> {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUnknown argument, try /briefcase help"))
            }
        }

        return true
    }

}