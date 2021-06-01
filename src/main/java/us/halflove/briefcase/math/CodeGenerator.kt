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

    fun generateCode(){
        var code: Int = kotlin.random.Random.nextInt(10000, 99999)
        BriefcaseStorage.data.set("code", code)
        BriefcaseStorage.saveDataFile()
        Bukkit.getServer().logger.info("The new code is: $code")
    }

}