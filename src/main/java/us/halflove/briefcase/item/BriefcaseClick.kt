package us.halflove.briefcase.item

import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.player.PlayerInteractEvent
import us.halflove.briefcase.gui.Hopper
import us.halflove.briefcase.passcode.InputCode

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

class BriefcaseClick : Listener {

    //Called when a player right clicks with the briefcase item, begins code input event
    @EventHandler
    fun clickBriefcase(event: PlayerInteractEvent) {
        if ((event.action == Action.RIGHT_CLICK_AIR || event.action == Action.RIGHT_CLICK_BLOCK)
            && (event.item == (BriefcaseItem.briefcaseLockedItemStack()) || event.item == (BriefcaseItem.briefcaseUnlockedItemStack())))
            InputCode.startInputCode(event.player)
    }

}