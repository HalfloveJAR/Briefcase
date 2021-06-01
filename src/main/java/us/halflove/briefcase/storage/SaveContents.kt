package us.halflove.briefcase.storage

import org.bukkit.inventory.ItemStack

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object SaveContents {

    //Sorts through the contents array and saves their specific data individually
    fun sortAndSaveContents(contents: Array<ItemStack>) {
        for (slot in contents.indices) {
            if (contents[slot] != null && slot != null) BriefcaseStorage.addDataToFile(
                "contents.$slot.type",
                contents[slot].type.toString()
            )
        }
    }

}