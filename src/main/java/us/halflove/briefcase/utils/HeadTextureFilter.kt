package us.halflove.briefcase.utils

import org.bukkit.inventory.ItemStack

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object HeadTextureFilter {

    //Returns with the specific custom head item stack from the HeadTexture enum depending on the number specified
    fun customHead(number: Int): ItemStack {

        return when(number){
            0 -> CustomHead.getCustomHead(HeadTexture.head0.urlValue, number.toString())
            1 -> CustomHead.getCustomHead(HeadTexture.head1.urlValue, number.toString())
            2 -> CustomHead.getCustomHead(HeadTexture.head2.urlValue, number.toString())
            3 -> CustomHead.getCustomHead(HeadTexture.head3.urlValue, number.toString())
            4 -> CustomHead.getCustomHead(HeadTexture.head4.urlValue, number.toString())
            5 -> CustomHead.getCustomHead(HeadTexture.head5.urlValue, number.toString())
            6 -> CustomHead.getCustomHead(HeadTexture.head6.urlValue, number.toString())
            7 -> CustomHead.getCustomHead(HeadTexture.head7.urlValue, number.toString())
            8 -> CustomHead.getCustomHead(HeadTexture.head8.urlValue, number.toString())
            9 -> CustomHead.getCustomHead(HeadTexture.head9.urlValue, number.toString())
            else -> CustomHead.getCustomHead(HeadTexture.headUnknown.urlValue, number.toString())
        }
    }

}