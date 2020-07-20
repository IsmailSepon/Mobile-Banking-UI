package com.cloudwell.paywell.ui.cards.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.paywell_cards_link_done_layout.view.*

class PaywellCardsLinkDoneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.paywell_cards_link_done_layout, container, false)


        view.card_link_done.setOnClickListener(View.OnClickListener {
            activity?.finish()
        })


        return view
    }

    override fun onResume() {
        super.onResume()
        Log.e("PaywellCardsLink", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("PaywellCardsLink", "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("PaywellCardsLink", "onDestroy")
    }
}

