package us.halflove.briefcase.math

import org.bukkit.Bukkit
import us.halflove.briefcase.storage.BriefcaseStorage

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object CodeGenerator {

    //Generates a code used to open the briefcase
    fun generateCode(){
        var code: Int = kotlin.random.Random.nextInt(10000, 99999)
        BriefcaseStorage.addDataToFile("code", code)
        Bukkit.getServer().logger.info("The new code is: $code")
    }

    //Called when the plugin first loads up, checks if a code needs to be made
    fun checkForCode(){
        if(!BriefcaseStorage.data.contains("code")) generateCode()
    }

}