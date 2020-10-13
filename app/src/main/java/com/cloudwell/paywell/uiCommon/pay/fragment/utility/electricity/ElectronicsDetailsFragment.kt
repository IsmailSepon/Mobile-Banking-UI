package com.cloudwell.paywell.uiCommon.pay.fragment.utility.electricity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.dialog.ElectricityConfirmDialog
import com.cloudwell.paywell.uiCommon.pay.model.UtilityPOjo
import com.google.gson.Gson
import kotlinx.android.synthetic.main.electronics_details_layout.view.*
import kotlinx.android.synthetic.main.topup_details_layout.view.operator_ic


class ElectronicsDetailsFragment : Fragment() {


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.electronics_details_layout, container, false)

        val pojo : String = requireArguments().getString("electronics", "")
        val gson = Gson()

        val utility : UtilityPOjo = gson.fromJson(pojo, UtilityPOjo::class.java)


        view.elec_details.text = "Your "+utility.name+" bill details"

        view.operator_ic.setImageResource(utility.icon!!)
//
//        Toast.makeText(requireContext(), utility.name, Toast.LENGTH_SHORT).show()
//
//
//        view.offer_layout.setOnClickListener(View.OnClickListener {
//
//            val i = Intent(activity, TopUpOfferActivity::class.java)
//            //i.putExtra("helloString", "helloString")
//            this.startActivityForResult(i, 1)
//
//        })
//
//
//
        view.set_electricity.setOnClickListener(View.OnClickListener {


            val dialog: ElectricityConfirmDialog = ElectricityConfirmDialog()
            dialog.show(activity?.supportFragmentManager!!, "ElectricityConfirmDialog")

        })



        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 111) {



        }
    }


}
