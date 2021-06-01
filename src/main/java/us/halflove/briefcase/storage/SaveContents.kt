package us.halflove.briefcase.storage

import org.bukkit.Material
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
            if (contents[slot] != null) {

                if(contents[slot].type == Material.WRITTEN_BOOK){

                }else {
                    BriefcaseStorage.addDataToFile("contents.$slot.type", contents[slot].type.toString())
                    BriefcaseStorage.addDataToFile("contents.$slot.amount", contents[slot].amount)
                    BriefcaseStorage.addDataToFile("contents.$slot.enchants", contents[slot].itemMeta?.enchants.toString())
                    BriefcaseStorage.addDataToFile("contents.$slot.name", contents[slot].itemMeta?.displayName.toString())
                }
            }else{
                BriefcaseStorage.addDataToFile("contents.$slot", null)
            }
        }
    }

}