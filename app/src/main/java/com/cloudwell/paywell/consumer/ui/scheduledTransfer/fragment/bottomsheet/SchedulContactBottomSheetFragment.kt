package com.cloudwell.paywell.consumer.ui.scheduledTransfer.fragment.bottomsheet

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.databinding.ScheduleContactBottomSheetBinding
import com.cloudwell.paywell.consumer.ui.beneficiary.BeneficeryHostActivity
import com.cloudwell.paywell.consumer.ui.scheduledTransfer.fragment.addNewContact.ScheduleSelectContactFragment
import com.cloudwell.paywell.consumer.ui.scheduledTransfer.view.IscheduleTransferVIew
import com.cloudwell.paywell.consumer.ui.scheduledTransfer.viewModel.ScheduleBottomSheetViewModel
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SchedulContactBottomSheetFragment : BottomSheetDialogFragment(), IscheduleTransferVIew {

    private var beneficeryViewModel: ScheduleBottomSheetViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        beneficeryViewModel =
            ViewModelProviders.of(this).get(ScheduleBottomSheetViewModel::class.java)
        val binding: ScheduleContactBottomSheetBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.schedule_contact_bottom_sheet,
            container,
            false
        )
        beneficeryViewModel!!.setView(this)
        binding.contactBottomViewModel = beneficeryViewModel
        binding.lifecycleOwner = this

        return binding.root
    }


    override fun startBeneficeryChooseFragment() {
        this.dismiss()
        val intent = Intent(context, BeneficeryHostActivity::class.java)
        intent.putExtra(this.getString(R.string.beneficery_type), 3)
        this.startActivity(intent)
        // FragmentHelper.replaceFragment(ChooseTransferTypeFragment(), activity?.supportFragmentManager, R.id.schedule_transfer_container)
    }

    override fun startContactFragment() {

        FragmentHelper.replaceFragment(
            ScheduleSelectContactFragment(),
            activity?.supportFragmentManager,
            R.id.schedule_transfer_container
        )

    }


    override fun noInternetConnectionFound() {
    }

    override fun showProgress() {
    }

    override fun hiddenProgress() {
    }

    override fun onFailure(message: String?) {

    }

}