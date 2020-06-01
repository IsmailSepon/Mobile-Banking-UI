package com.cloudwell.paywell.consumer.ui.addMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.consumer.R
import com.example.nbtk.slider.ScreenUtils
import com.example.nbtk.slider.SliderAdapter
import com.example.nbtk.slider.SliderLayoutManager
import kotlinx.android.synthetic.main.add_money.*
import kotlinx.android.synthetic.main.add_money.view.*
import kotlinx.android.synthetic.main.send_money.view.*

class AddMoneyBankSelectedFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_money_bankselected_layout, container, false)



        return view
    }


}
