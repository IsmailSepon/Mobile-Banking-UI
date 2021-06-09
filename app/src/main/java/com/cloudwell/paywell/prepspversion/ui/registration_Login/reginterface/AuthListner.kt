package com.cloudwell.paywell.prepspversion.ui.registration_Login.reginterface


/**
 * Created by MD ISMAIL HOSSAIN SEPON on 04-Jun-21.
 * ismailhossainsepon@gmail.com
 */
interface AuthListner  {

    fun onAuthStart()
//    fun onSucsess(user : User)

    fun onFailur(msg : String)


}