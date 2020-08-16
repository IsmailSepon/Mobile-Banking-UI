package com.cloudwell.paywell.ui.BusinessUI.cards.fragment.transaction

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.consumer.ui.account.pendingPopupDialog.DeliveryTrackingDialog
import com.cloudwell.paywell.ui.BusinessUI.cards.adapter.SpinnerAdapter
import com.cloudwell.paywell.ui.BusinessUI.cards.dialog.StatmentDialog
import com.cloudwell.paywell.ui.BusinessUI.cards.dialog.trxProfileDialog
import com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment.dialog.BankFinancialDialog
import kotlinx.android.synthetic.main.business_card_transaction_layout.view.*


class BusinessCardTransactionFragment : Fragment(), AdapterView.OnItemSelectedListener {

    var selectedItem = -1
    var alltxt : TextView? = null
    var acActivitytxt : TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_card_transaction_layout, container, false)


        view.statment_txt.setOnClickListener(View.OnClickListener {
            view.constraintLayout26.visibility = View.GONE
            view.constraintLayout28.visibility = View.GONE
            view.no_transcation_ly.visibility = View.VISIBLE
        })

        view.get_txt.setOnClickListener(View.OnClickListener {
            view.constraintLayout26.visibility = View.VISIBLE
            view.constraintLayout28.visibility = View.VISIBLE
            view.no_transcation_ly.visibility = View.GONE
        })

        var country =  arrayOf("All", "Card", "ATM", "Refund")
        val spinner : Spinner = view.findViewById(R.id.tr_spinner)
        val adapter : SpinnerAdapter = SpinnerAdapter(requireActivity().applicationContext, country)
        spinner.adapter = adapter
        spinner.setOnItemSelectedListener(this);
        alltxt = view.findViewById(R.id.all_txt)
        view.all_txt.setOnClickListener(View.OnClickListener {

            spinner.performClick()
        })

        view.constraintLayout26.setOnClickListener(View.OnClickListener {

            val dialog: trxProfileDialog = trxProfileDialog()
            dialog.show(activity?.supportFragmentManager!!, "trxProfileDialog")

        })



        var acActivity = arrayOf("  Start of account acitivity","Thist month                    1--2", "May", "April")
        val spinner1 : Spinner = view.findViewById(R.id.ac_activity_spinner)
        spinner1.prompt = "Start of account acitivity"
        val adapter1 : SpinnerAdapter = SpinnerAdapter(requireActivity().applicationContext, acActivity)
        spinner1.adapter = adapter1
        view.ac_activity_txt.setOnClickListener(View.OnClickListener {

            spinner1.performClick()
        })


        view.statment_txt.setOnClickListener(View.OnClickListener {
            val dialog: StatmentDialog = StatmentDialog()
            dialog.show(activity?.supportFragmentManager!!, "StatmentDialog")

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
        fun newInstance(sectionNumber: Int): BusinessCardTransactionFragment {
            return BusinessCardTransactionFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        val item = parent!!.getItemAtPosition(position).toString()
        alltxt?.text = item
    }

}
