package us.halflove.briefcase.gui

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.ItemStack
import us.halflove.briefcase.storage.BriefcaseStorage
import us.halflove.briefcase.storage.SaveContents

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

class EditingEvent : Listener{

    //Used to update the contents of the briefcase in the data.yml after the briefcase GUI is closed
    @EventHandler
    fun inventoryEditEvent(event: InventoryCloseEvent){
        if(event.view.title == "Briefcase") SaveContents.sortAndSaveContents(event.inventory.contents)
    }

}