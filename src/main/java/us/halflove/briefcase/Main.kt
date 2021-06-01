package us.halflove.briefcase

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import us.halflove.briefcase.commands.BriefcaseCmd

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

class Main : JavaPlugin() {

    override fun onEnable(){

        if(!Bukkit.getServer().pluginManager.isPluginEnabled("ProtocolLib")){
            logger.severe("Error loading Briefcase plugin; This plugin requires ProtocolLib to work!")
            Bukkit.getServer().pluginManager.disablePlugin(this)
        }else logger.info("Briefcase v" + description.version + " enabled successfully.")

        getCommand("briefcase")?.setExecutor(BriefcaseCmd)

    }

    override fun onDisable(){
        logger.info("Briefcase plugin v" + description.version + " disabled successfully.")
    }

}