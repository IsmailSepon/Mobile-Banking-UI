package com.cloudwell.paywell.uiBusiness.control.fragment.expenceManagment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.department_item.view.*
import kotlinx.android.synthetic.main.organize_chart_fragment.view.*

class OrginizeChartFragment : Fragment() {

    private var addNoFlag = 0
    private var paywellAClayouy : LinearLayout?= null

    private var expence_catagory_flag = 0
    private var expence_catagorylayouy : LinearLayout?= null

    private var liabilitiesFlag = 0
    private var liabilities_layout : LinearLayout?= null


    private var inf: LayoutInflater? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.organize_chart_fragment, container, false)


        inf = layoutInflater



        paywellAClayouy = view.findViewById(R.id.department_layout)
        expence_catagorylayouy = view.findViewById(R.id.expence_catagory_layout)
        liabilities_layout = view.findViewById(R.id.liabilities_layout)


        val department_list = arrayOf("Sales", "Marketing", "HR", "Accounts", "IT")
        for (item in department_list.indices) {
            val name : String = department_list[item]
            addpaywell_Ac(name, "50051")
        }

        val expence_list = arrayOf("Travel/fuel", "Lodging", "Medical", "Entertainment", "Office stationary")
        for (item in expence_list.indices) {
            val name : String = expence_list[item]
            expenceCatagory(name, "60051")
        }

        val liabilities_list = arrayOf("Cash a/c", "PayWell a/c", "Islami Bank a/c", "BRAC Bank a/c", "City Bank a/c", "AB Bank a/c", "Community Bank..", "bKash a/c", "Rocket a/c", "Nagad a/c")
        for (item in liabilities_list.indices) {
            val name : String = liabilities_list[item]
            liabilities(name, "70051")
        }


        addpaywell_Ac("", "")
        expenceCatagory("", "")
        liabilities("", "")


        view.add_department_view.setOnClickListener(View.OnClickListener {

            addpaywell_Ac("", "")
        })


        view.add_expence_catagory_view.setOnClickListener(View.OnClickListener {

            expenceCatagory("", "")
        })


        view.add_liabilities_view.setOnClickListener(View.OnClickListener {

            liabilities("", "")
        })


        view.save_organogram_btn.setOnClickListener(View.OnClickListener {

            val parent = activity as NewExpenceActivity?
            parent?.setPagerFrg(1)

        })



        return view
    }

    private fun liabilities(name : String, code : String) {
        ++liabilitiesFlag
        val liabilitiesCview: View = inf!!.inflate(R.layout.department_item, null)


        if (!name.equals("")){
            liabilitiesCview.department_name.setText(name)
            liabilitiesCview.department_code.setText(code)
            liabilitiesCview.department_checkbox.isChecked = true

        }

        liabilities_layout?.addView(liabilitiesCview)
    }

    private fun expenceCatagory(name : String, code : String) {
        ++expence_catagory_flag
        val expenceview: View = inf!!.inflate(R.layout.department_item, null)

        if (!name.equals("")){
            expenceview.department_name.setText(name)
            expenceview.department_code.setText(code)
            expenceview.department_checkbox.isChecked = true

        }


        expence_catagorylayouy?.addView(expenceview)
    }


    private fun addpaywell_Ac(name : String, code : String) {
        ++addNoFlag
        val departmentview: View = inf!!.inflate(R.layout.department_item, null)

        if (!name.equals("")){
            departmentview.department_name.setText(name)
            departmentview.department_code.setText(code)
            departmentview.department_checkbox.isChecked = true

        }


        paywellAClayouy?.addView(departmentview)
    }
}