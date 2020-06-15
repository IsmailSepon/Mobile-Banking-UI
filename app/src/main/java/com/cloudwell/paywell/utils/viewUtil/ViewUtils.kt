package com.cloudwell.paywell.utils.viewUtil

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-09-03.
 */

fun Context.toast(message:String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}


fun View.snackbar(message: String){
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).also { s ->
        s.setAction("Ok"){
            s.dismiss()
        }
    }
}