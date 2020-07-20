package com.cloudwell.paywell.consumer.ui.profile.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import kotlinx.android.synthetic.main.manage_acc_profile_personal_details.view.*


class DetailPersonalProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.manage_acc_profile_personal_details, container, false)

        view.imageViewMAP1.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                EditPersonalDetailsFirstFragment(),
                activity?.supportFragmentManager,
                R.id.profile_host_container
            )
        })

        view.imageViewMAP2.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                EditPersonalDetailsSecondFragment(),
                activity?.supportFragmentManager,
                R.id.profile_host_container
            )
        })

        view.imageViewMAP3.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                EditPersonalDetailsThirdFragment(),
                activity?.supportFragmentManager,
                R.id.profile_host_container
            )
        })

        view.imageViewMAP4.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                EditPersonalDetailsForthFragment(),
                activity?.supportFragmentManager,
                R.id.profile_host_container
            )
        })

        view.cameraOrange.setOnClickListener(View.OnClickListener {
//            FragmentHelper.replaceFragment(
//                CameraBottomSheetFragment(),
//                activity?.supportFragmentManager,
//                R.id.profile_host_container
//            )

//            val bottomSheetFragment = CameraBottomSheetFragment()
//            bottomSheetFragment.show(
//                (view.context as AppCompatActivity).supportFragmentManager,
//                bottomSheetFragment.tag
//            )

            showBottomSheetDialog()
        })

        return view
    }

    fun showBottomSheetDialog() {
        val mBottomSheetDialog = Dialog(requireContext(), R.style.MaterialDialogSheetAnimation)
        mBottomSheetDialog.setContentView(R.layout.personal_details_action_bottom_sheet)

        mBottomSheetDialog.setCancelable(true)
        mBottomSheetDialog.window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        mBottomSheetDialog.window?.setGravity(Gravity.BOTTOM)
        mBottomSheetDialog.show()

//        val dialog = Dialog(requireContext())
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog.setCancelable(false)
//        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//        dialog.window!!.setGravity(Gravity.BOTTOM)
//        dialog.setContentView(R.layout.personal_details_action_bottom_sheet)
//
//        dialog.show()
    }


}