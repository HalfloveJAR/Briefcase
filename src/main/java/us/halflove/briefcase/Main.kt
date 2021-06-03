package us.halflove.briefcase

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import us.halflove.briefcase.commands.BriefcaseCmd
import us.halflove.briefcase.gui.EditingEvent
import us.halflove.briefcase.item.BriefcaseClick
import us.halflove.briefcase.item.BriefcaseCombust
import us.halflove.briefcase.item.ThrowItemEvent
import us.halflove.briefcase.math.CodeGenerator
import us.halflove.briefcase.passcode.InputCode
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

        //Registers commands and events
        getCommand("briefcase")?.setExecutor(BriefcaseCmd)
        Bukkit.getPluginManager().registerEvents(EditingEvent(), this)
        Bukkit.getPluginManager().registerEvents(BriefcaseClick(), this)
        Bukkit.getPluginManager().registerEvents(BriefcaseCombust(), this)
        Bukkit.getPluginManager().registerEvents(ThrowItemEvent, this)
        Bukkit.getPluginManager().registerEvents(InputCode, this)

        //Checks and creates data.yml
        BriefcaseStorage.createDataFile(this)

        //Checks and creates initial briefcase code
        CodeGenerator.checkForCode()

    }

    override fun onDisable(){
        logger.info("Briefcase plugin v" + description.version + " disabled successfully.")
    }

}
