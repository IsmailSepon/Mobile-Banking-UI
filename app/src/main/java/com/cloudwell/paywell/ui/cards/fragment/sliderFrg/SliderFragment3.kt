package com.cloudwell.paywell.ui.cards.fragment.sliderFrg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import kotlinx.android.synthetic.main.demo3.view.*

class SliderFragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.demo3, container, false)


        view.virtual_card.setOnClickListener(View.OnClickListener {
            Toast.makeText(activity?.applicationContext, "vitual", Toast.LENGTH_LONG).show()
        })
        view.physical_card.setOnClickListener(View.OnClickListener {
            Toast.makeText(activity?.applicationContext, "ohysical", Toast.LENGTH_LONG).show()
        })


        return view
    }
}

