package com.cloudwell.paywell.ui.cards.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.security_layout.view.*

class CardsSecurityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.security_layout, container, false)



        view.security_card_back.setOnClickListener(View.OnClickListener {
            activity?.finish()
        })


        return view
    }
}

