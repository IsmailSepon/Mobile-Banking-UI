package com.cloudwell.paywell.uiCommon.pay.fragment.utility.electricity.dpdc


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.dialog.ElectronicsConfirmDialog
import com.cloudwell.paywell.uiCommon.pay.model.ElectronicsDialogPOjo
import com.cloudwell.paywell.uiCommon.pay.model.UtilityPOjo
import com.google.gson.Gson
import kotlinx.android.synthetic.main.dpdc_details_layout.view.*
import kotlinx.android.synthetic.main.electronics_details_layout.view.set_electricity


class DpdcDetailsFragment : Fragment() {


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dpdc_details_layout, container, false)

        val pojo : String = requireArguments().getString("electronics", "")
        val gson = Gson()
        val utility : UtilityPOjo = gson.fromJson(pojo, UtilityPOjo::class.java)


        view.dpdc_details.text = "Your "+utility.name+" bill details"
        view.dpdc_ic.setImageResource(utility.icon!!)

        view.set_electricity.setOnClickListener(View.OnClickListener {


            val dpdcPojo : ElectronicsDialogPOjo = ElectronicsDialogPOjo()
            dpdcPojo.type = utility.name
            dpdcPojo.typeDetails = utility.name
            dpdcPojo.amount = "৳530"
            dpdcPojo.billNumber = "22255000051515"
            dpdcPojo.mobileNumber = "01612250477"

            val json = gson.toJson(dpdcPojo)
            val bundle  = Bundle()
            bundle.putString("electronics", json)


            val dialog: ElectronicsConfirmDialog = ElectronicsConfirmDialog()
            dialog.arguments = bundle
            dialog.show(activity?.supportFragmentManager!!, "DescoConfirmDialog")


//            val json = gson.toJson(dpdcPojo)
//            val bundle  = Bundle()
//            bundle.putString("electronics", json)
//
//            val dialog: DpdcConfirmDialog = DpdcConfirmDialog()
//            dialog.arguments = bundle
//            dialog.show(activity?.supportFragmentManager!!, "DpdcConfirmDialog")



        })

        val month = arrayOf("Select month", "January")
        val sp : Spinner = view.month_sp
        sp.onItemSelectedListener
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), R.layout.spinner_item, month)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp.adapter = aa
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            }
        }

        val year = arrayOf("2020", "2021")
        val sp1 : Spinner = view.year_sp
        sp.onItemSelectedListener
        val aa1: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), R.layout.spinner_item, year)
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp1.adapter = aa1
        sp1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            }
        }




        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 111) {



        }
    }


}
