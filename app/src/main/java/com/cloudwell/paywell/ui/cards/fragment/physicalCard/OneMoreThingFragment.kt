package com.cloudwell.paywell.ui.cards.fragment.physicalCard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.one_more_thing_layout.view.*

class OneMoreThingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.one_more_thing_layout, container, false)


        view.one_more_thing_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                AllowCardLocationFragment(),
                activity?.supportFragmentManager,
                R.id.Cards_container
            )
        })


        return view
    }
}

