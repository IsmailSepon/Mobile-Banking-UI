package com.cloudwell.paywell.uiBusiness.cards.fragment.bulk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.marchent_payment_bulk_layout.view.*

class EnterBulkPaymentFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.marchent_payment_bulk_layout, container, false)

//
//        view.enter_details_btn.setOnClickListener(View.OnClickListener {
//            FragmentHelper.replaceFragment(
//                MarchentPaymentDoneFragment(),
//                requireActivity().supportFragmentManager,
//                R.id.bu_Cards_container
//            )
//
//        })

        
        view.bulk_back.setOnClickListener(View.OnClickListener {
            activity?.finish()  // FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })



        return view
    }


}
