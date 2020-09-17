package com.cloudwell.paywell.uiBusiness.cards.fragment.manageCustomers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.products_details_edit_fragment.view.*

class ProductsDetailsEditFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.products_details_edit_fragment, container, false)


        view.product_details_gotit_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                NewProductsFragment(), requireActivity().supportFragmentManager, R.id.bu_Cards_container
            )
        })
//
//




        return view
    }





}