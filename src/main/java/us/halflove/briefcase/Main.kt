package us.halflove.briefcase

import org.bukkit.Bukkit
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import us.halflove.briefcase.commands.BriefcaseCmd
import us.halflove.briefcase.gui.EditingEvent
import us.halflove.briefcase.math.CodeGenerator
import us.halflove.briefcase.storage.BriefcaseStorage

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

        //Checks to see if you have ProtocolLib installed
        if(!Bukkit.getServer().pluginManager.isPluginEnabled("ProtocolLib")){
            logger.severe("Error loading Briefcase plugin; This plugin requires ProtocolLib to work!")
            Bukkit.getServer().pluginManager.disablePlugin(this)
        }else logger.info("Briefcase v" + description.version + " enabled successfully.")

        //Registers commands and events
        getCommand("briefcase")?.setExecutor(BriefcaseCmd)
        Bukkit.getPluginManager().registerEvents(EditingEvent(), this)

        //Checks and creates data.yml
        BriefcaseStorage.createDataFile(this)

        //Checks and creates initial briefcase code
        CodeGenerator.checkForCode()

    }

    override fun onDisable(){
        logger.info("Briefcase plugin v" + description.version + " disabled successfully.")
    }

}
