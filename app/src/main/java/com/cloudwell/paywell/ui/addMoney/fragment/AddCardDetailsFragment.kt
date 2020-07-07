package com.cloudwell.paywell.ui.addMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.databinding.AddCardDetailsLayoutBinding
import com.cloudwell.paywell.ui.addMoney.view.IaddCardDetailsVIew
import com.cloudwell.paywell.ui.addMoney.viewModel.AddCardDetailsViewModel
import com.cloudwell.paywell.utils.FragmentHelper

class AddCardDetailsFragment : Fragment(), IaddCardDetailsVIew {


    private lateinit var addCardDetailsViewmodel: AddCardDetailsViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addCardDetailsViewmodel =
            ViewModelProviders.of(this).get(AddCardDetailsViewModel::class.java)
        val binding: AddCardDetailsLayoutBinding =
            DataBindingUtil.inflate(inflater, R.layout.add_card_details_layout, container, false)
        addCardDetailsViewmodel.setView(this)
        binding.addCardDetilsXml = addCardDetailsViewmodel
        binding.lifecycleOwner = this


        return binding.root

    }

    override fun card_details_done_btn() {
        FragmentHelper.replaceFragment(
            AddCardDetailsDoneFragment(),
            activity?.supportFragmentManager,
            R.id.add_money_container
        )
    }

    override fun card_detils_back_btn() {
        FragmentHelper.removeFragment(activity?.supportFragmentManager)
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
