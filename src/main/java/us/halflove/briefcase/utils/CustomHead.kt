package us.halflove.briefcase.utils

import com.mojang.authlib.GameProfile
import com.mojang.authlib.properties.Property
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.util.UUID
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta


/*
*
* @author Tango_ on Bukkit.org
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object CustomHead {

    //Creates a custom skull from a defined texture using NBT data
    fun getCustomHead(urlValue: String, name: String): ItemStack {

        val head = ItemStack(Material.PLAYER_HEAD)
        if (urlValue.isEmpty()) return head
        val skullMeta = head.itemMeta as SkullMeta?
        val profile = GameProfile(UUID.randomUUID(), null)
        profile.properties.put("textures", Property("textures", urlValue))
        try {
            val mtd: Method = skullMeta!!.javaClass.getDeclaredMethod("setProfile", GameProfile::class.java)
            mtd.isAccessible = true
            mtd.invoke(skullMeta, profile)
        } catch (ex: IllegalAccessException) {
            ex.printStackTrace()
        } catch (ex: InvocationTargetException) {
            ex.printStackTrace()
        } catch (ex: NoSuchMethodException) {
            ex.printStackTrace()
        }
        skullMeta?.setDisplayName(name)
        head.itemMeta = skullMeta
        return head
    }

}