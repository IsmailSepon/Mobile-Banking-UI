package com.cloudwell.paywell.uiBusiness.cards.fragment.expence

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R

class ExpenceSubmitePreviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.expence_submit_preview_layout, container, false)


//        view.capture_fdetails_btn.setOnClickListener(View.OnClickListener {
//
//            FragmentHelper.replaceFragment(
//                BusinessBeneficiaryProfileDetailsFragment(),
//                requireActivity().supportFragmentManager,
//                R.id.bu_Cards_container
//            )
//
//        })


        return view
    }
}

