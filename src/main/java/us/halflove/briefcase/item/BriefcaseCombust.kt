package us.halflove.briefcase.item

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.block.Block
import org.bukkit.entity.EntityType
import org.bukkit.entity.Item
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityCombustEvent
import org.bukkit.inventory.ItemStack

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

class BriefcaseCombust : Listener {

    @EventHandler
    fun itemBurn(event: EntityCombustEvent){
        if(event.entityType == EntityType.DROPPED_ITEM) {
            var locationBlock: Block = event.entity.location.block
            var droppedItem: Item = event.entity as Item
            var droppedItemStack = ItemStack(Material.valueOf(droppedItem.itemStack.type.toString()), 1)
            Bukkit.broadcastMessage("" + droppedItem.thrower)
            if(droppedItem.itemStack.type == BriefcaseItem.briefcaseLockedItemStack().type){
                for(player in Bukkit.getServer().onlinePlayers){
                    if(player.uniqueId == droppedItem.thrower){
                        BriefcaseItem.getBriefcaseItem(player, false)
                        player.location.world!!.playSound(player.location, Sound.ENTITY_ITEM_PICKUP, 1f, 1f)
                    }
                }
            }
        }
    }

}