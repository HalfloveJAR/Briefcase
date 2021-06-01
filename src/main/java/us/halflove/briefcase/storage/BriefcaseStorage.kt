package us.halflove.briefcase.storage

import org.bukkit.Bukkit
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.Plugin
import java.io.File
import java.io.IOException


/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object BriefcaseStorage {

    lateinit var data: FileConfiguration
    lateinit var dataFile: File

    fun createDataFile(plugin: Plugin){

        if(!plugin.dataFolder.exists()) plugin.dataFolder.mkdir()
        dataFile = File(plugin.dataFolder, "data.yml")

        if (!dataFile.exists()) try {
            dataFile.createNewFile()
        } catch (e: IOException) {
            Bukkit.getServer().logger.severe("Could not create data.yml!")
        }

        data = YamlConfiguration.loadConfiguration(dataFile)

    }

    fun saveDataFile(){
        try {
            data.save(dataFile)
        } catch (e: IOException) {
            Bukkit.getServer().logger.severe("Could not save data.yml!")
        }
    }

    fun reloadDataFile(){
        data = YamlConfiguration.loadConfiguration(dataFile)
    }

}