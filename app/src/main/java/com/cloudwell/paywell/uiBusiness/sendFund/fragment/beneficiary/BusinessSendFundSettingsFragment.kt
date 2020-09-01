package com.cloudwell.paywell.uiBusiness.sendFund.fragment.beneficiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.sendFund.fragment.dialog.BeneficiaryDelateDialog
import kotlinx.android.synthetic.main.business_send_fund_setting_layout.view.*

class BusinessSendFundSettingsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_send_fund_setting_layout, container, false)


        view.delate_beneficiary.setOnClickListener(View.OnClickListener {

            val dialog: BeneficiaryDelateDialog = BeneficiaryDelateDialog()
            activity?.supportFragmentManager?.let { it1 -> dialog.show(it1, "MobileFinancial") }
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
        fun newInstance(sectionNumber: Int): BusinessSendFundSettingsFragment {
            return BusinessSendFundSettingsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}
