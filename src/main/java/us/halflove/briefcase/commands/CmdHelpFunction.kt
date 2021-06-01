package us.halflove.briefcase.commands

import org.bukkit.ChatColor
import org.bukkit.command.CommandSender

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object CmdHelpFunction {

    fun helpCommand(sender: CommandSender){
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""))
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lBriefcase"))
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&oBy: Halflove For: KnightCobra"))
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""))
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/BCase NewCode"))
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Generate a new code for the briefcase"))
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""))
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/BCase Modify"))
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Edit the contents of the briefcase"))
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""))
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/BCase Get"))
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7Get the briefcase"))
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ""))
    }

}