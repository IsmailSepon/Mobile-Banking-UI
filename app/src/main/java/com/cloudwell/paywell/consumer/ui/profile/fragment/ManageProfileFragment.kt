package com.cloudwell.paywell.consumer.ui.profile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.databinding.FragmentBeneficiaryBinding
import com.cloudwell.paywell.consumer.databinding.FragmentManageAccProfileBinding
import com.cloudwell.paywell.consumer.ui.beneficiary.viewModel.BeneficeryViewModel
import com.cloudwell.paywell.consumer.ui.profile.viewmodel.ManageProfileViewModel

class ManageProfileFragment : Fragment() {

    private lateinit var manageProfileViewModel: ManageProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        manageProfileViewModel = ViewModelProviders.of(this).get(ManageProfileViewModel::class.java)
        val binding: FragmentManageAccProfileBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_manage_acc_profile, container, false)

        binding.manageProfileViewModel = manageProfileViewModel
        binding.lifecycleOwner = this

        return binding.root
    }


}