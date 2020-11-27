package com.cloudwell.paywell.uiBusiness.cards.fragment.expence

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.claim_your_expence_layout.view.*

class BuCardClaimExpenceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.claim_your_expence_layout, container, false)


        view.take_pic_0f_expence.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                ExpenceDetailsFragment(),
                requireActivity().supportFragmentManager,
                R.id.bu_Cards_container
            )

        })

        view.imageView257.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        return view
    }
}

