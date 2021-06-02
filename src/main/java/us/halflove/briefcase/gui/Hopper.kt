package us.halflove.briefcase.gui

import org.bukkit.Bukkit
import org.bukkit.Sound
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
    fun openHopper(player: Player) {
        player.openInventory(getHopper())
        player.location.world!!.playSound(player.location, Sound.ENTITY_PLAYER_LEVELUP, 1f, 2f)
    }

    //Creates hopper GUI from data.yml
    private fun getHopper(): Inventory{

        //Creates the briefcase GUI
        val gui: Inventory = Bukkit.createInventory(null, InventoryType.HOPPER, "Briefcase")

        //Gets the configuration section "contents" in the data.yml (contents of the briefcase)
        val contentsSection: ConfigurationSection? = BriefcaseStorage.data.getConfigurationSection("contents")

        if (contentsSection != null) {

            //Iterates through the contents stored and sets them in their respective places when the GUI is opened
            for (key in contentsSection.getKeys(false)) {
                gui.setItem(key.toInt(), GetContents.getSlotItemStack(key.toInt()))
            }

        }

        return gui
    }

}