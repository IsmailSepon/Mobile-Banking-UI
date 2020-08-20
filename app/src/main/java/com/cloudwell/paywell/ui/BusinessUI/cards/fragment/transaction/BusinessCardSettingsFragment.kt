package com.cloudwell.paywell.ui.BusinessUI.cards.fragment.transaction

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
import kotlinx.android.synthetic.main.business_card_settings_layout.view.*
import kotlinx.android.synthetic.main.business_card_transaction_layout.view.*

class BusinessCardSettingsFragment : Fragment(), AdapterView.OnItemSelectedListener {



    var allwoed_country_txt : TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_card_settings_layout, container, false)


//            FragmentHelper.replaceFragment(
//                BusinessTransactionSettingFragment(),
//                requireActivity().supportFragmentManager,
//                R.id.bu_Cards_container
//            )

        view.monthly_limit.setOnClickListener(View.OnClickListener {


            val dialog: MonthlyLimitDialog = MonthlyLimitDialog()
            dialog.show(activity?.supportFragmentManager!!, "MonthlyLimitDialog")

        })


        view.location_based_security_status.setOnClickListener(View.OnClickListener {


            val dialog: BusinessCardTerminateDialog = BusinessCardTerminateDialog()
            dialog.show(activity?.supportFragmentManager!!, "BusinessCardTerminateDialog")

        })


        view.allwoed_country_spinner

        var country =  arrayOf("Domestic", "International")
        val spinner : Spinner = view.findViewById(R.id.allwoed_country_spinner)
        val adapter : SpinnerAdapter = SpinnerAdapter(requireActivity().applicationContext, country)
        spinner.adapter = adapter
        spinner.setOnItemSelectedListener(this);
        allwoed_country_txt = view.findViewById(R.id.allwoed_country_status)
        view.allwoed_country_status.setOnClickListener(View.OnClickListener {
            spinner.performClick()
        })


        return view
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): BusinessCardSettingsFragment {
            return BusinessCardSettingsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val item = parent!!.getItemAtPosition(position).toString()
        allwoed_country_txt?.text = item
    }

}
