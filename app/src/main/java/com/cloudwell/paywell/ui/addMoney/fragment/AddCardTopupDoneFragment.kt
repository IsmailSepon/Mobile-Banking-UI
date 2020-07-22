package com.cloudwell.paywell.ui.addMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.databinding.AddCardTopupDoneLayoutBinding
import com.cloudwell.paywell.ui.addMoney.view.IaddCardtopupDoneVIew
import com.cloudwell.paywell.ui.addMoney.viewModel.AddCardTopupDoneViewModel

class AddCardTopupDoneFragment : Fragment(), IaddCardtopupDoneVIew {

    private lateinit var addCardTopupDoneViewModel: AddCardTopupDoneViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addCardTopupDoneViewModel =
            ViewModelProviders.of(this).get(AddCardTopupDoneViewModel::class.java)
        val binding: AddCardTopupDoneLayoutBinding =
            DataBindingUtil.inflate(inflater, R.layout.add_card_topup_done_layout, container, false)
        addCardTopupDoneViewModel.setView(this)
        binding.addCardTopupDoneXml = addCardTopupDoneViewModel
        binding.lifecycleOwner = this


        return binding.root
    }

    override fun doneonclick() {
        activity?.finish()
    }

    override fun noInternetConnectionFound() {
        TODO("Not yet implemented")
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    override fun hiddenProgress() {
        TODO("Not yet implemented")
    }

    override fun onFailure(message: String?) {
        TODO("Not yet implemented")
    }


}
