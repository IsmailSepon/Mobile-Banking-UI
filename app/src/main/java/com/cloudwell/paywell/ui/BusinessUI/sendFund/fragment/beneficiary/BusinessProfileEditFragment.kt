package com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.beneficiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R

class BusinessProfileEditFragment : Fragment() {


    private var addNoFlag = 0
    private var paywellAClayouy :LinearLayout?= null
    private var inf: LayoutInflater? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_profile_edit_layout, container, false)


        paywellAClayouy = view.findViewById(R.id.paywell_ac_layout)
        inf = layoutInflater

        addpaywell_Ac()

        return view
    }
    
    private fun addpaywell_Ac() {
        ++addNoFlag
        var paywellACview: View = inf!!.inflate(R.layout.paywell_account_item, null)


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
