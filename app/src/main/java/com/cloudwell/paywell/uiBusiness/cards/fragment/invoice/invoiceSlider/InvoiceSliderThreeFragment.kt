package com.cloudwell.paywell.uiBusiness.cards.fragment.invoice.invoiceSlider

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.invoice_slider_three_layout.view.*

class InvoiceSliderThreeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.invoice_slider_three_layout, container, false)



        view.invoice_three.setOnClickListener(View.OnClickListener {


        })


        return view
    }
}