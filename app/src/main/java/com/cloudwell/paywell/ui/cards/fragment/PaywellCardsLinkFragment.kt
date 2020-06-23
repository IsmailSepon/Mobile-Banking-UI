package com.cloudwell.paywell.ui.cards.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.paywell_cards_link_layout.view.*


class PaywellCardsLinkFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.paywell_cards_link_layout, container, false)


        view.card_link_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                PaywellCardsLinkDoneFragment(),
                activity?.supportFragmentManager,
                R.id.Cards_container
            )
        })


        view.close.setOnClickListener(View.OnClickListener {
            activity?.finish()
        })


        return view
    }


}

