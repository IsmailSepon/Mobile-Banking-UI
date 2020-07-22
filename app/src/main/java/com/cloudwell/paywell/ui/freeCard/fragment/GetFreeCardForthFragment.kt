package com.cloudwell.paywell.ui.freeCard.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.get_free_card_forth_fragment.view.*

class GetFreeCardForthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.get_free_card_forth_fragment, container, false)

        view.buttonSendInviteGFCF1.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                GetFreeCardFifthFragment(),
                activity?.supportFragmentManager,
                R.id.free_card_host_container
            )
        })

        return view
    }
}