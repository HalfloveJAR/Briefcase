package us.halflove.briefcase.storage

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.configuration.ConfigurationSection
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

object GetContents {

    //Builds and returns the requested item (slot) stored in the data.yml
    fun getSlotItemStack(slot: Int): ItemStack{

        //Creates initial itemstack
        var selectedItem: ItemStack = ItemStack(
            Material.valueOf(BriefcaseStorage.data.get("contents.$slot.type").toString()),
            BriefcaseStorage.data.get("contents.$slot.amount") as Int
        )

        //Checks if item is written book and applies applicable metadata
        if(selectedItem.type == Material.WRITTEN_BOOK){
            //Gets / creates book meta values
            var title: String = BriefcaseStorage.data.get("contents.$slot.title").toString()
            var author: String = BriefcaseStorage.data.get("contents.$slot.author").toString()
            var pages: ArrayList<String> = ArrayList<String>()

            //Sorts and applies page data from data.yml to the pages arraylist
            val pagesSection: ConfigurationSection? = BriefcaseStorage.data.getConfigurationSection("contents.$slot.pages")
            if (pagesSection != null) {
                for (key in pagesSection.getKeys(false)) {
                    pages.add(BriefcaseStorage.data.get("contents.$slot.pages.$key").toString())
                }
            }

            //Applies values to the itemstack's bookmeta/itemmeta
            var bookmeta: BookMeta = selectedItem.itemMeta as BookMeta
            bookmeta.author = author
            bookmeta.title = title
            bookmeta.pages = pages
            selectedItem.itemMeta = bookmeta

        }

        return selectedItem
    }

}