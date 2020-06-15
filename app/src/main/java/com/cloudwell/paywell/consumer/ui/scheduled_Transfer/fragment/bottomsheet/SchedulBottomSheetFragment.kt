package com.cloudwell.paywell.consumer.ui.scheduled_Transfer.fragment.bottomsheet

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.databinding.ScheduleBottomSheetBinding
import com.cloudwell.paywell.consumer.ui.beneficiary.BeneficeryHostActivity
import com.cloudwell.paywell.consumer.ui.scheduled_Transfer.view.IscheduleTransferVIew
import com.cloudwell.paywell.consumer.ui.scheduled_Transfer.viewModel.ScheduleBottomSheetViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SchedulBottomSheetFragment : BottomSheetDialogFragment(), IscheduleTransferVIew {

    private var beneficeryViewModel: ScheduleBottomSheetViewModel? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        beneficeryViewModel =
            ViewModelProviders.of(this).get(ScheduleBottomSheetViewModel::class.java)
        val binding: ScheduleBottomSheetBinding =
            DataBindingUtil.inflate(inflater, R.layout.schedule_bottom_sheet, container, false)
        beneficeryViewModel!!.setView(this)
        binding.schedulebottomsheetModel = beneficeryViewModel
        binding.lifecycleOwner = this

        return binding.root
    }


    fun startActivity(type: Int) {
        val intent = Intent(context, BeneficeryHostActivity::class.java)
        intent.putExtra(this.getString(R.string.beneficery_type), type)
        this.startActivity(intent)
    }

    override fun startBeneficeryChooseFragment() {

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