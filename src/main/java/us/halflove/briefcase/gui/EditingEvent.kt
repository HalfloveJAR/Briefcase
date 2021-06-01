package us.halflove.briefcase.gui

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import java.util.*

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

class EditingEvent : Listener{

    @EventHandler
    fun inventoryEditEvent(event: InventoryCloseEvent){
        var player: Player = event.player as Player
        if(event.view.title == "Briefcase"){

            //Save when closed

        }
    }

}