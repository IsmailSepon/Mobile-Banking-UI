package com.cloudwell.paywell.base

import android.os.Bundle
import androidx.fragment.app.DialogFragment

open class BaseDialog : DialogFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, 0)
    }
}