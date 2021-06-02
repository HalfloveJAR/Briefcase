package us.halflove.briefcase.storage

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BookMeta
import org.bukkit.inventory.meta.ItemMeta


/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

class WrittenBooks {

    var title: String = ""
    var author: String = ""
    var currentPage: String = ""
    var numPages: Int = 0
    var numLines: Int = 0

    fun createBook() {

        var bookItem: ItemStack = ItemStack(Material.WRITTEN_BOOK, 1)
        var itemMeta: ItemMeta? = bookItem.itemMeta
        var bookMeta: BookMeta? = bookItem.itemMeta as BookMeta

        bookMeta?.author.apply { author }
        bookMeta?.pageCount.apply{ numPages }
        bookMeta?.title.apply{ title }
        bookItem.itemMeta = itemMeta

        bookMeta?.addPage(currentPage)
        ++numPages


    }

}