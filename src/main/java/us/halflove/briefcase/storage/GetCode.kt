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

    //Gets and returns the passcode from the data.yml
    val code: String
        get() = BriefcaseStorage.data.get("code").toString()

}