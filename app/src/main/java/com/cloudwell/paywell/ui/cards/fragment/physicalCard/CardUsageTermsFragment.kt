package com.cloudwell.paywell.ui.cards.fragment.physicalCard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.card_usage_terms_layout.view.*

class CardUsageTermsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.card_usage_terms_layout, container, false)


        view.card_usage_terms_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                CardCreatePinFragment(),
                activity?.supportFragmentManager,
                R.id.Cards_container
            )
        })


        return view
    }
}

