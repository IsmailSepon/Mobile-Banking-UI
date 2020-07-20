package com.cloudwell.paywell.consumer.ui.profile.viewmodel

import android.view.View
import android.widget.Toast
import com.cloudwell.paywell.consumer.base.BaseViewModel
import com.cloudwell.paywell.consumer.data.repository.BaseRepository
import com.cloudwell.paywell.consumer.databinding.ActivityDashboardHostBinding
import com.cloudwell.paywell.consumer.databinding.ActivityProfileHostBinding
import com.cloudwell.paywell.consumer.ui.beneficiary.fragment.BottomSheetFragment

class ProfileHostViewModel(val repository: BaseRepository) : BaseViewModel() {
    val manageAccountProfileFragment = BottomSheetFragment()

    fun profileManageBtn(view: View) {
        Toast.makeText(view.context, "Clicked", Toast.LENGTH_SHORT).show();
    }
}