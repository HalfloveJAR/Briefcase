package us.halflove.briefcase.storage

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BookMeta

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

                //Written book specific values to store
                if (contents[slot].type == Material.WRITTEN_BOOK) {
                    BriefcaseStorage.addDataToFile("contents.$slot.title", (contents[slot].itemMeta as BookMeta).title.toString())
                    BriefcaseStorage.addDataToFile("contents.$slot.author", (contents[slot].itemMeta as BookMeta).author.toString())

                    //Saves each page individually
                    for(pageNum: Int in 1 until (contents[slot].itemMeta as BookMeta).pageCount +1){
                        BriefcaseStorage.addDataToFile("contents.$slot.pages.$pageNum", (contents[slot].itemMeta as BookMeta).getPage(pageNum))
                    }
                }

                //Common values to store
                BriefcaseStorage.addDataToFile("contents.$slot.type", contents[slot].type.toString())
                BriefcaseStorage.addDataToFile("contents.$slot.amount", contents[slot].amount)
                BriefcaseStorage.addDataToFile("contents.$slot.enchants", contents[slot].itemMeta?.enchants.toString())
                BriefcaseStorage.addDataToFile("contents.$slot.name", contents[slot].itemMeta?.displayName.toString())

            }else{

                //If an item is removed from the briefcase, this remove it from the data.yml
                BriefcaseStorage.addDataToFile("contents.$slot", null)

            }
        }
    }

}