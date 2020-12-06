package com.cloudwell.paywell.ui.linkedAccount.introFragment

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R


class LinkedIntroOneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.linkedac_intro_one_layout, container, false)







        return view
    }


    //OnBack press finish activity cz its first fragment in this activity

}