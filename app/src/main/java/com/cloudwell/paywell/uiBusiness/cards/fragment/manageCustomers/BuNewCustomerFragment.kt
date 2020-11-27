package com.cloudwell.paywell.uiBusiness.cards.fragment.manageCustomers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.newcustomer_fragment.view.*

class BuNewCustomerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.newcustomer_fragment, container, false)


        view.new_customers_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                BuProductsFragment(), requireActivity().supportFragmentManager, R.id.bu_Cards_container
            )
        })




        view.newcustomer_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })


        return view
    }
}