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

object GetContents {

    //Builds and returns the requested item (slot) stored in the data.yml
    fun getBriefcaseItemStack(slot: Int): ItemStack{

        var selectedItem: ItemStack = ItemStack(
            Material.valueOf(BriefcaseStorage.data.get("contents.$slot.type").toString()),
            BriefcaseStorage.data.get("contents.$slot.amount") as Int
        )

        if(selectedItem.type == Material.WRITTEN_BOOK){

        }

        if(BriefcaseStorage.data.get("contents.$slot.enchants") != "{}"){
            //set enchants
        }

        if(BriefcaseStorage.data.get("contents.$slot.name") != ""){
            //set display name
        }

        return selectedItem
    }

}