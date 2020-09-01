package com.cloudwell.paywell.uiBusiness.cards.cardOrder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.cards.fragment.physicalCard.AllowCardLocationFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.bu_one_more_thing_layout.view.*
import kotlinx.android.synthetic.main.one_more_thing_layout.view.card_way_back_btn

class BusinessOneMoreThingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bu_one_more_thing_layout, container, false)


        view.bu_one_more_thing_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                AllowCardLocationFragment(),
                activity?.supportFragmentManager,
                R.id.bu_Cards_container
            )
        })


        view.card_way_back_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })


        return view
    }
}

