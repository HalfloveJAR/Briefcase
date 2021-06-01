package us.halflove.briefcase.gui

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import us.halflove.briefcase.storage.BriefcaseStorage


/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object Hopper {

    //Opens hopper GUI
    fun openHopper(player: Player) {
        var gui: Inventory = Bukkit.createInventory(null, InventoryType.HOPPER, "Briefcase");
        player.openInventory(gui)
    }

    fun editHopper(player: Player){
        var gui: Inventory = Bukkit.createInventory(null, InventoryType.HOPPER, "Briefcase");
        player.openInventory(gui)
    }

}