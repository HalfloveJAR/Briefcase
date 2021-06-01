package us.halflove.briefcase.gui

import org.bukkit.Bukkit
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.Inventory
import us.halflove.briefcase.storage.BriefcaseStorage
import us.halflove.briefcase.storage.GetContents


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
    fun openHopper(player: Player) = player.openInventory(getHopper())

    //Creates hopper GUI from data.yml
    fun getHopper(): Inventory{
        var gui: Inventory = Bukkit.createInventory(null, InventoryType.HOPPER, "Briefcase");

        val contentsSection: ConfigurationSection? = BriefcaseStorage.data.getConfigurationSection("contents")
        if (contentsSection != null) {
            for (key in contentsSection.getKeys(false)) {
                gui.setItem(key.toInt(), GetContents.getBriefcaseItemStack(key.toInt()))
            }
        }

        return gui
    }

}