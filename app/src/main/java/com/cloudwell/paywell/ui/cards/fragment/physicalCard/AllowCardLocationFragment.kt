package com.cloudwell.paywell.ui.cards.fragment.physicalCard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.allow_card_location_layout.view.*

class AllowCardLocationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.allow_card_location_layout, container, false)


        view.allow_location_access.setOnClickListener(View.OnClickListener {
            activity?.finish()
        })


        return view
    }
}

