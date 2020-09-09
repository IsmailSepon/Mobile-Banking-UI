package com.cloudwell.paywell.uiBusiness.control.fragment.expenceManagment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
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



        addpaywell_Ac()


        expenceCatagory()

       liabilities()


        view.add_department_view.setOnClickListener(View.OnClickListener {

            addpaywell_Ac()
        })



        view.add_expence_catagory_view.setOnClickListener(View.OnClickListener {

            expenceCatagory()
        })



        view.add_liabilities_view.setOnClickListener(View.OnClickListener {

            liabilities()
        })


        view.save_organogram_btn.setOnClickListener(View.OnClickListener {

            val parent = activity as NewExpenceActivity?
            parent?.setPagerFrg(1)

        })



        return view
    }

    private fun liabilities() {
        ++liabilitiesFlag
        val paywellACview: View = inf!!.inflate(R.layout.department_item, null)


        liabilities_layout?.addView(paywellACview)
    }

    private fun expenceCatagory() {
        ++expence_catagory_flag
        val paywellACview: View = inf!!.inflate(R.layout.department_item, null)


        expence_catagorylayouy?.addView(paywellACview)
    }


    private fun addpaywell_Ac() {
        ++addNoFlag
        val paywellACview: View = inf!!.inflate(R.layout.department_item, null)


        paywellAClayouy?.addView(paywellACview)
    }
}