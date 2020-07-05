package com.cloudwell.paywell.ui.addMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.addMoney.viewModel.AddMoneyViewModel
import kotlinx.android.synthetic.main.add_card_topup_done_layout.view.*

class AddCardTopupDoneFragment : Fragment() {


    private lateinit var addMoneyViewmodel: AddMoneyViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_card_topup_done_layout, container, false)

        view.done.setOnClickListener(View.OnClickListener {
           activity?.finish()
        })



        return view
    }


}
