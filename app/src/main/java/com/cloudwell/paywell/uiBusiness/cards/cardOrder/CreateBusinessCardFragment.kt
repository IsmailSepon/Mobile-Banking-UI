package com.cloudwell.paywell.uiBusiness.cards.cardOrder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.create_business_card_layout.view.*

class CreateBusinessCardFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.create_business_card_layout, container, false)


        view.create_bu_crd_btn.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                BusinessSpecifyDeliveryAddressFragment(),
                requireActivity().supportFragmentManager,
                R.id.bu_Cards_container
            )

        })

        return view
    }

}
