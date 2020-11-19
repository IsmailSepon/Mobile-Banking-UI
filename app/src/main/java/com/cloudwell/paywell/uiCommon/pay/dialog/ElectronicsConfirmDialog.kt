package com.cloudwell.paywell.uiCommon.pay.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.BaseDialog
import com.cloudwell.paywell.uiCommon.pay.fragment.utility.electricity.ElectricitySuccessfulFragment
import com.cloudwell.paywell.uiCommon.pay.model.ElectronicsDialogPOjo
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.gson.Gson
import kotlinx.android.synthetic.main.electricity_confirm_dialog.view.*
import kotlinx.android.synthetic.main.topup_confirm_dialog.view.confirm_btn


class ElectronicsConfirmDialog : BaseDialog() {


    private var utility = ElectronicsDialogPOjo()
    private var typeTitle : TextView? = null
    private var typeDetails : TextView? = null
    private var billNumTitle : TextView? = null
    private var billNumber : TextView? = null
    private  var mobileNumber : TextView? = null
    private var mlocation : TextView? = null
    private var mMonth : TextView? = null

    private var mobile_lay : LinearLayout? = null
    private var amount_lay : LinearLayout? = null
    private var location_lay : LinearLayout? = null
    private var month_lay : LinearLayout? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.electricity_confirm_dialog, null)

        typeDetails = view.type_details_txt
        typeTitle = view.typeTitle
        billNumTitle = view.billNumTitle
        billNumber = view.billNumber
        mobileNumber = view.mobile_numver
        mlocation = view.elec_location
        mMonth = view.elec_month


        mobile_lay  = view.mobile_lay
        amount_lay = view.amount_layout
        location_lay = view.location_layout
        month_lay = view.month_layout




        val pojo : String = requireArguments().getString("electronics", "")
        val gson = Gson()

        utility  = gson.fromJson(pojo, ElectronicsDialogPOjo::class.java)


        val type = utility.type




        if (type.equals("DESCO")){

            showDescoType(utility)

        }else if (type.equals("DPDC")){

            showDPdCType(utility)

        }else if (type.equals("West Zone")){

            showWestType(utility)

        }else if (type.equals("Polli Biddyut")){

            showPolliType(utility)
        }



        view.confirm_btn.setOnClickListener(View.OnClickListener {
            dismiss()

            val json = gson.toJson(utility)
            val bundle  = Bundle()
            bundle.putString("electronics", json)

            val frag = ElectricitySuccessfulFragment()
            frag.arguments = bundle
            FragmentHelper.replaceFragment(frag, requireActivity().supportFragmentManager, R.id.payment_container)


        })










        return view
    }

    private fun showDescoType(utility: ElectronicsDialogPOjo) {

        typeDetails?.text = utility.typeDetails


        location_lay?.visibility = View.GONE
        month_lay?.visibility = View.GONE

    }

    private fun showDPdCType(utility: ElectronicsDialogPOjo) {
        typeDetails?.text = utility.typeDetails


    }

    private fun showPolliType(utility: ElectronicsDialogPOjo) {
        typeDetails?.text = utility.typeDetails
        billNumTitle?.text = utility.billNumbertitle



        location_lay?.visibility = View.GONE
        month_lay?.visibility = View.GONE
        mobile_lay?.visibility = View.GONE


    }

    private fun showWestType(utility: ElectronicsDialogPOjo) {

        typeDetails?.text = utility.typeDetails
        billNumTitle?.text = utility.billNumbertitle


        amount_lay?.visibility = View.GONE
        location_lay?.visibility = View.GONE

    }

}