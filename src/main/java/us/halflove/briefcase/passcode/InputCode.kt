package us.halflove.briefcase.passcode

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.inventory.Inventory
import us.halflove.briefcase.gui.Hopper
import us.halflove.briefcase.storage.GetCode
import us.halflove.briefcase.utils.HeadTextureFilter


/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object InputCode : Listener {

    var enteringCode: HashMap<Player, String> = HashMap<Player, String>()

    fun startInputCode(player: Player){
        player.openInventory(getCodeGui())
        player.location.world!!.playSound(player.location, Sound.BLOCK_ANVIL_USE, 1f, 2f)
    }

    //Returns with the code input inventory/gui
    private fun getCodeGui(): Inventory{

        //Creates the code input GUI
        val gui: Inventory = Bukkit.createInventory(null, 18, "Enter The Passcode")

        //Sets the numbers in the input keyboard to their respective textures and slots
        var number = 0
        for(slot: Int in 2 until 7){
            gui.setItem(slot, HeadTextureFilter.customHead(number))
            number++
        }
        for(slot: Int in 11 until 16){
            gui.setItem(slot, HeadTextureFilter.customHead(number))
            number++
        }

        return gui
    }

    //Checks if a player clicked a number on the keypad and updates their passcode entry
    @EventHandler
    fun clickItem(event: InventoryClickEvent){
        val player: Player = event.whoClicked as Player

        if(event.view.title == "Enter The Passcode"){
            if(event.currentItem?.type != Material.AIR) {
                event.isCancelled = true
                if(event.currentItem?.type == Material.PLAYER_HEAD) {
                    event.currentItem!!.itemMeta?.let { codeEntryUpdate(player, it.displayName) }
                }
            }
        }
    }

    //Updates a player's passcode entry
    private fun codeEntryUpdate(player: Player, input: String){

        //Gets the player's current input
        val currentInput = if(enteringCode.containsKey(player)){
            enteringCode.getValue(player)
        }else ""

        //Updates the player's input
        enteringCode[player] = currentInput+input
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eCurrent Input: " + enteringCode.getValue(player)))
        player.location.world!!.playSound(player.location, Sound.BLOCK_NOTE_BLOCK_BIT, 1f, 0f)

        //Checks for a passcode match, clears their passcode input entry if no match is found
        if(enteringCode.getValue(player).length == GetCode.code.length){
            if(enteringCode.getValue(player) == GetCode.code){
                enteringCode.remove(player)
                Hopper.openHopper(player)
            }else{
                player.closeInventory()
                player.location.world!!.playSound(player.location, Sound.BLOCK_ANVIL_LAND, 1f, 2f)
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cIncorrect code!"))
            }
        }

    }

    //Remove player's passcode input when they close the code input gui
    @EventHandler
    fun closeMenu(event: InventoryCloseEvent){
        if(event.view.title == "Enter The Passcode"){
            if(enteringCode.containsKey(event.player)){
                enteringCode.remove(event.player)
            }
        }
    }

}