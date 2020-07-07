package com.cloudwell.paywell.ui.addMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.databinding.AddCardDetailsDoneLayoutBinding
import com.cloudwell.paywell.ui.addMoney.view.IaddCardDetailsDoneVIew
import com.cloudwell.paywell.ui.addMoney.viewModel.AddCardDetailsDoneViewModel
import com.cloudwell.paywell.utils.FragmentHelper

class AddCardDetailsDoneFragment : Fragment(), IaddCardDetailsDoneVIew {

    private lateinit var addCardDetailsDoneViewModel: AddCardDetailsDoneViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addCardDetailsDoneViewModel =
            ViewModelProviders.of(this).get(AddCardDetailsDoneViewModel::class.java)
        val binding: AddCardDetailsDoneLayoutBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.add_card_details_done_layout,
                container,
                false
            )
        addCardDetailsDoneViewModel.setView(this)
        binding.addCardDetailsDoneXml = addCardDetailsDoneViewModel
        binding.lifecycleOwner = this


        return binding.root

    }

    override fun gofortopup() {
        FragmentHelper.replaceFragment(
            AddCardTopupDoneFragment(),
            activity?.supportFragmentManager,
            R.id.add_money_container
        )
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
