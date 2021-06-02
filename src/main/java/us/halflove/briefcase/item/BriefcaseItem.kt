package us.halflove.briefcase.item

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object BriefcaseItem {

    private var briefcase: ItemStack = ItemStack(Material.CHEST_MINECART, 1)

    fun getBriefcaseItem(player: Player){
        var briefcaseMeta: ItemMeta? = briefcase.itemMeta
        briefcaseMeta?.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fBriefcase"))
        briefcase.itemMeta = briefcaseMeta
        player.inventory.addItem(briefcase)
    }

}