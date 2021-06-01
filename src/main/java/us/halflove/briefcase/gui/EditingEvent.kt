package us.halflove.briefcase.gui

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.inventory.InventoryClickEvent
import java.util.*

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object EditingEvent : EventListener{

    @EventHandler
    fun inventoryEditEvent(event: InventoryClickEvent){
        var player: Player = event.whoClicked as Player
        if(event.view.title == "Briefcase"){
            if(event.slot !in 0..4) event.isCancelled = true
        }
    }

}