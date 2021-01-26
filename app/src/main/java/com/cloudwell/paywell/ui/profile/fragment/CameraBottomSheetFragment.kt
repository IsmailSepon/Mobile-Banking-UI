package com.cloudwell.paywell.ui.profile.fragment

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CameraBottomSheetFragment : BottomSheetDialogFragment() {

    fun CameraBottomSheetFragment() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        //Code here
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.personal_details_action_bottom_sheet, container, false)

        return view
    }

}