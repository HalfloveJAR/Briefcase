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

    //Called when the briefcase is burning, returns a "revealed code/unlocked" briefcase to the player who threw it into fire
    @EventHandler
    fun itemBurn(event: EntityCombustEvent){
        if(event.entityType == EntityType.DROPPED_ITEM) {

            //Casts the dropped item entity into an item
            var droppedItem: Item = event.entity as Item

            //Tests if the dropped item type is the same as the briefcase item type
            if(droppedItem.itemStack.type == BriefcaseItem.briefcaseLockedItemStack().type){

                //Gives the new item to the player who threw the briefcase into fire
                for(player in Bukkit.getServer().onlinePlayers){
                    if(ThrowItemEvent.droppedItem.containsKey(player)) {
                        if (ThrowItemEvent.droppedItem[player]?.type == droppedItem.itemStack.type) {
                            BriefcaseItem.getBriefcaseItem(player, false)
                            player.location.world!!.playSound(player.location, Sound.ENTITY_ITEM_PICKUP, 1f, 1f)
                            ThrowItemEvent.droppedItem.remove(player)
                        }
                    }
                }

            }

        }
    }

}