package com.cloudwell.paywell.uiBusiness.control.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.control.adapter.BuControllPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.bu_manage_profile_layout.view.*


class BuProfileManageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.bu_manage_profile_layout, container, false)

        val sectionsPagerAdapter = BuControllPagerAdapter(
            requireActivity().applicationContext,
            requireActivity().supportFragmentManager
        )
        val viewPager: ViewPager = root.findViewById(R.id.controll_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = root.findViewById(R.id.controll_tab)
        tabs.setupWithViewPager(viewPager)



        root.bu_profile_image.setOnClickListener(View.OnClickListener {

            showBottomSheetDialog()

        })




        root.manage_profile_back.setOnClickListener(View.OnClickListener {
            activity?.finish()  // FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })


        return root

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