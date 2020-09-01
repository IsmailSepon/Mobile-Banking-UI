package com.cloudwell.paywell.uiBusiness.cards.cardOrder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.business_card_order_layout.view.*

class BusinessCardOrderTermsFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_card_order_layout, container, false)


        view.card_continue_btn.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                CreateBusinessCardFragment(),
                requireActivity().supportFragmentManager,
                R.id.bu_Cards_container
            )


        })

        return view
    }

}
