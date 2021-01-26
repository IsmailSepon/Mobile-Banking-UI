package com.cloudwell.paywell.uiBusiness.cards.fragment.invoice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.cards.dialog.IssuedInvoiceDialog
import com.cloudwell.paywell.uiBusiness.cards.dialog.NewCustomerDialog
import com.cloudwell.paywell.uiBusiness.cards.dialog.NewItemDialog
import kotlinx.android.synthetic.main.new_invoice_details_layout.view.*

class NewInvoiceDetailsFragment : Fragment() {


    private var addexpirFlag = 0
    private var expairelayouy : LinearLayout?= null

    private var addlineItemFlag = 0
    private var lineItemlayouy : LinearLayout?= null

    private var inf: LayoutInflater? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.new_invoice_details_layout, container, false)



        expairelayouy = view.new_customers_layout
        lineItemlayouy = view.add_line_item_layout
        inf = layoutInflater




        addCustomer()

        addLineItem()



        view.add_customer_btn.setOnClickListener(View.OnClickListener {
            addCustomer()
        })


        view.add_line_item_txt.setOnClickListener(View.OnClickListener {
            addLineItem()
        })



        view.issued_btn.setOnClickListener(View.OnClickListener {
            val dialog: IssuedInvoiceDialog = IssuedInvoiceDialog()
            dialog.show(activity?.supportFragmentManager!!, "IssuedInvoiceDialog")


        })


        view.save_btn.setOnClickListener(View.OnClickListener {
            val dialog: NewCustomerDialog = NewCustomerDialog()
            dialog.show(activity?.supportFragmentManager!!, "NewCustomerDialog")

        })


        view.cancel_btn.setOnClickListener(View.OnClickListener {

            val dialog: NewItemDialog = NewItemDialog()
            dialog.show(activity?.supportFragmentManager!!, "NewItemDialog")
        })



        view.newinvoice_back.setOnClickListener(View.OnClickListener {
            activity?.finish()  //  FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        return view
    }


    private fun addCustomer() {
        ++addexpirFlag
        val paywellACview: View = inf!!.inflate(R.layout.addcustomlayout, null)

        val sp : Spinner = paywellACview.findViewById(R.id.add_customer_sp)

        val country = arrayOf("Benham Pharmaceuticals", "5 days before expiry date", "14 days after issued date")
        sp.onItemSelectedListener
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), R.layout.spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp.adapter = aa
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            }
        }

        expairelayouy?.addView(paywellACview)
    }


    private fun addLineItem() {
        ++addlineItemFlag
        val paywellACview: View = inf!!.inflate(R.layout.line_item_layout, null)

        val sp : Spinner = paywellACview.findViewById(R.id.line_item_sp)

        val country = arrayOf("Item description", "Item description")
        sp.onItemSelectedListener
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), R.layout.spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sp.adapter = aa
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            }
        }

        lineItemlayouy?.addView(paywellACview)
    }
}