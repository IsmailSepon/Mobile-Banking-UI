package com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.beneficiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.business_profile_edit_layout.view.*

class BusinessProfileEditFragment : Fragment() {


    private var addNoFlag = 0
    private var paywellAClayouy :LinearLayout?= null

    private var addBankFlag = 0
    private var bankAClayouy :LinearLayout?= null

    private var addmobileFincFlag = 0
    private var mobileFinclayouy :LinearLayout?= null


    private var addewallet_acFlag = 0
    private var ewallet_aclayouy :LinearLayout?= null


    private var inf: LayoutInflater? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_profile_edit_layout, container, false)


        paywellAClayouy = view.findViewById(R.id.paywell_ac_layout)
        bankAClayouy = view.findViewById(R.id.bank_ac_layout)
        mobileFinclayouy = view.findViewById(R.id.mobile_fininc_layout)
        ewallet_aclayouy = view.findViewById(R.id.ewallet_ac_layout)

        inf = layoutInflater



        addpaywell_Ac()
        addBank_Ac()
        addmobileFinc()
        addewallet_Ac()

        // add paywell account
        view.add_paywell_ac_btn.setOnClickListener(View.OnClickListener {
            addpaywell_Ac()
        })

        view.add_bank_ac_btn.setOnClickListener(View.OnClickListener {
            addBank_Ac()
        })

        view.add_mobile_fininc_btn.setOnClickListener(View.OnClickListener {
            addmobileFinc()
        })

        view.ewallet_ac_btn.setOnClickListener(View.OnClickListener {
            addewallet_Ac()
        })

        view.beneficiary_save_btn.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(
                BusinessBeneficiaryCnfmCodeFragment(),
                requireActivity().supportFragmentManager,
                R.id.send_money_container
            )


        })




        return view
    }

    private fun addewallet_Ac() {
        ++addewallet_acFlag
        val eWalletAcView : View = inf!!.inflate(R.layout.ewallet_ac_item, null)



        ewallet_aclayouy?.addView(eWalletAcView)
    }

    private fun addmobileFinc() {
        ++addmobileFincFlag
        val mobileFincView : View = inf!!.inflate(R.layout.mobile_finince_item,  null)


        mobileFinclayouy?.addView(mobileFincView)
    }

    private fun addBank_Ac() {
        ++addBankFlag
        val paywellBankview: View = inf!!.inflate(R.layout.bank_account_item, null)


        bankAClayouy?.addView(paywellBankview)

    }

    private fun addpaywell_Ac() {
        ++addNoFlag
        val paywellACview: View = inf!!.inflate(R.layout.paywell_account_item, null)


        paywellAClayouy?.addView(paywellACview)

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
        fun newInstance(sectionNumber: Int): BusinessProfileEditFragment {
            return BusinessProfileEditFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}
