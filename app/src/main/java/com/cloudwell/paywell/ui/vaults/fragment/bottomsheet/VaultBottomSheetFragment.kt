package com.cloudwell.paywell.ui.vaults.fragment.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ContextThemeWrapper
import androidx.databinding.DataBindingUtil.setContentView
import com.cloudwell.paywell.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class VaultBottomSheetFragment : BottomSheetDialogFragment() {




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //super(context, R.style.CustomDialogTheme);
        val view = inflater.inflate(R.layout.vault_bottom_sheet_layout, container, false)




        return view
    }



}