package us.halflove.briefcase.item

import org.bukkit.entity.Item
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.inventory.ItemStack

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object ThrowItemEvent : Listener {

    val droppedItem: HashMap<Player, ItemStack> = HashMap<Player, ItemStack>()

    @EventHandler
    fun dropItem(event: PlayerDropItemEvent){
       if((event.itemDrop.itemStack).type == BriefcaseItem.briefcaseLockedItemStack().type){
           droppedItem[event.player] = event.itemDrop.itemStack
       }
    }

}