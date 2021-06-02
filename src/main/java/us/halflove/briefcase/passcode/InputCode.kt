package us.halflove.briefcase.passcode

import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerChatEvent
import us.halflove.briefcase.gui.Hopper
import us.halflove.briefcase.storage.GetCode


/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object InputCode : Listener {

    var enteringCode: HashMap<Player, Boolean> = HashMap<Player, Boolean>()

    fun startInputCode(player: Player){

        enteringCode[player] = true
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&lIt's locked!"))
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cEnter the passcode to open."))
        player.location.world!!.playSound(player.location, Sound.BLOCK_ANVIL_USE, 1f, 2f)

    }

    private fun inputCode(player: Player, input: String){
        if(enteringCode.containsKey(player) && enteringCode[player] == true){
            if(input.contains(GetCode.code())) Hopper.openHopper(player)
        }
    }

    private fun endInputCode(player: Player){
        enteringCode.remove(player)
    }

    @EventHandler
    fun playerChat(event: PlayerChatEvent){
        if(enteringCode.containsKey(event.player) && enteringCode[event.player] == true){
            inputCode(event.player, event.message)
            event.isCancelled = true
            event.player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aCorrect!"))
            event.player.location.world!!.playSound(event.player.location, Sound.BLOCK_CHEST_OPEN, 1f, 2f)
            endInputCode(event.player)
        }
    }

}