package us.halflove.briefcase.item

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import us.halflove.briefcase.storage.GetCode

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object BriefcaseItem {

    fun getBriefcaseItem(player: Player, locked: Boolean){
        if(locked) {
            player.inventory.addItem(briefcaseLockedItemStack())
        }else{
            player.inventory.addItem(briefcaseUnlockedItemStack())
        }
    }

    fun briefcaseLockedItemStack(): ItemStack{
        var briefcase: ItemStack = ItemStack(Material.CHEST_MINECART, 1)
        var briefcaseMeta: ItemMeta? = briefcase.itemMeta
        var briefcaseLore: ArrayList<String> = ArrayList<String>()
        briefcaseLore.add("")
        briefcaseLore.add(ChatColor.translateAlternateColorCodes('&', "&7Written on the side it reads:"))
        briefcaseLore.add(ChatColor.translateAlternateColorCodes('&', "&7&o'The flames burn holes in secrets'"))
        briefcaseLore.add("")
        briefcaseMeta?.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fBriefcase"))
        briefcaseMeta?.lore = briefcaseLore
        briefcase.itemMeta = briefcaseMeta
        return briefcase
    }

    fun briefcaseUnlockedItemStack(): ItemStack{
        var briefcase: ItemStack = ItemStack(Material.CHEST_MINECART, 1)
        var briefcaseMeta: ItemMeta? = briefcase.itemMeta
        var briefcaseLore: ArrayList<String> = ArrayList<String>()
        briefcaseLore.add("")
        briefcaseLore.add(ChatColor.translateAlternateColorCodes('&', "&7Written on the side it reads:"))
        briefcaseLore.add(ChatColor.translateAlternateColorCodes('&', "&7&o${GetCode.code()}"))
        briefcaseLore.add("")
        briefcaseMeta?.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fBriefcase"))
        briefcaseMeta?.lore = briefcaseLore
        briefcase.itemMeta = briefcaseMeta
        return briefcase
    }

}