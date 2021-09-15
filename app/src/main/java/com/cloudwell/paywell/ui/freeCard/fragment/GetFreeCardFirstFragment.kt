package com.cloudwell.paywell.ui.freeCard.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.get_free_card_first_fragment.view.*

class GetFreeCardFirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.get_free_card_first_fragment, container, false)

        view.buttonStartInviteGFCF1.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                GetFreeCardSecondFragment(),
                activity?.supportFragmentManager,
                R.id.profile_host_container
            )
        })

        return view
    }
}