package com.cloudwell.paywell.uiBusiness.sendFund.fragment.transcation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.sendFund.fragment.beneficiary.BusinessBeneficiaryDetailsFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.business_send_fund_beneficiary_layout.view.*

class BusinessSendFundBeneficiariesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_send_fund_beneficiary_layout, container, false)


        view.all_beneficiray_txt.setOnClickListener(View.OnClickListener {



        })


        view.beneficiry_item.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                BusinessBeneficiaryDetailsFragment(),
                requireActivity().supportFragmentManager,
                R.id.send_money_container
            )
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
        fun newInstance(sectionNumber: Int): BusinessSendFundBeneficiariesFragment {
            return BusinessSendFundBeneficiariesFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}
