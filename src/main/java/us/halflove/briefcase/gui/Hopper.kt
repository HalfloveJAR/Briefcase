package us.halflove.briefcase.gui

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.Inventory

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object Hopper {

    fun openHopper(player: Player) {
        var gui: Inventory = Bukkit.createInventory(null, InventoryType.HOPPER, "Briefcase");
        player.openInventory(gui)
    }

    fun editHopper(player: Player){
        Editor.allowEditing[player] = true
        var gui: Inventory = Bukkit.createInventory(null, InventoryType.HOPPER, "Briefcase");
        player.openInventory(gui)
    }

}