package us.halflove.briefcase.storage

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object GetCode {

    fun code(): String = BriefcaseStorage.data.get("code").toString()

}