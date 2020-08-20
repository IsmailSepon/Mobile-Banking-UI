package com.cloudwell.paywell.ui.BusinessUI.cards.cardOrder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.cards.adapter.SpinnerAdapter
import com.cloudwell.paywell.ui.BusinessUI.cards.dialog.BusinessCardTerminateDialog
import com.cloudwell.paywell.ui.BusinessUI.cards.dialog.MonthlyLimitDialog
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.business_card_order_layout.view.*
import kotlinx.android.synthetic.main.business_card_settings_layout.view.*
import kotlinx.android.synthetic.main.business_card_transaction_layout.view.*
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
