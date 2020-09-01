package com.cloudwell.paywell.uiBusiness.sendFund.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.sendFund.fragment.dialog.BankFinancialDialog
import com.cloudwell.paywell.uiBusiness.sendFund.fragment.dialog.MobileFinancialDialog
import kotlinx.android.synthetic.main.business_send_new_beneficiry_layout.view.*


class BusinessSendFundnewBeneficiryFragment : Fragment() {

    var selection: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_send_new_beneficiry_layout, container, false)


        view.create_company.setOnClickListener(View.OnClickListener {
            if (selection == 1){


                val dialog: BankFinancialDialog = BankFinancialDialog()
                activity?.supportFragmentManager?.let { it1 -> dialog.show(it1, "BankFinancialDialog") }


            }else if (selection == 2){

                val dialog: MobileFinancialDialog = MobileFinancialDialog()
                activity?.supportFragmentManager?.let { it1 -> dialog.show(it1, "MobileFinancial") }

            }else{
                Toast.makeText(activity, "Please select", Toast.LENGTH_LONG).show()

            }

        })

        view.transfertype_radiogroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when (checkedId) {
                    R.id.bank -> {
                        selection = 1
                        view.mobile_finincial_layout.visibility = View.GONE
                        view.bank_layout.visibility = View.VISIBLE
                        loadBankData(view)
                    }
                    R.id.mobile_finincial -> {
                        selection = 2
                        view.mobile_finincial_layout.visibility = View.VISIBLE
                        view.bank_layout.visibility = View.GONE
                    }
                }
            }
        })
       // loadBankData(view)

        return view
    }

    private fun loadBankData(view: View) {
        var country = arrayOf("Mutual Trust Bank", "City Bank", "Brack Bank")

        view.banklist_sp.onItemSelectedListener
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), android.R.layout.simple_spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        requireView().banklist_sp.adapter = aa

        view.banklist_sp?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                getBranchData()
            }

        }

    }

    private fun getBranchData() {
        var branch = arrayOf("Kalabagan", "Gulshan", "Framgate")

        requireView().spinner.onItemSelectedListener
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), android.R.layout.simple_spinner_item, branch)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        requireView().spinner.adapter = aa

    }


}
