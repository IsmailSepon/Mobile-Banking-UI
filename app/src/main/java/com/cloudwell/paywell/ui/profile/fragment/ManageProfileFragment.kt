package com.cloudwell.paywell.ui.profile.fragment

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.databinding.FragmentManageAccProfileBinding
import com.cloudwell.paywell.ui.profile.viewmodel.ManageProfileViewModel
import com.cloudwell.paywell.utils.FragmentHelper

class ManageProfileFragment : Fragment() {

    private lateinit var manageProfileViewModel: ManageProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        manageProfileViewModel = ViewModelProviders.of(this).get(ManageProfileViewModel::class.java)
        val binding: FragmentManageAccProfileBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_manage_acc_profile,
                container,
                false
            )

        binding.manageProfileViewModel = manageProfileViewModel
        binding.lifecycleOwner = this

        binding.usernameMA1.setOnClickListener(View.OnClickListener {
            val done =
                ManageAccountDetailsFragment()
            val manager = activity?.supportFragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.profile_host_container, done)
            transaction?.addToBackStack(null)
            transaction?.commit()
        })

        binding.textViewMA1.setOnClickListener(View.OnClickListener {
            val done =
                DetailPersonalProfileFragment()
            val manager = activity?.supportFragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.profile_host_container, done)
            transaction?.addToBackStack(null)
            transaction?.commit()
        })

        binding.textViewMA2.setOnClickListener(View.OnClickListener {
            val done =
                VirtualAccountDetailsFragment()
            val manager = activity?.supportFragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.profile_host_container, done)
            transaction?.addToBackStack(null)
            transaction?.commit()
        })

        binding.textViewMA3.setOnClickListener(View.OnClickListener {
            val done =
                ManageTopupLimitFragment()
            val manager = activity?.supportFragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.profile_host_container, done)
            transaction?.addToBackStack(null)
            transaction?.commit()
        })

        binding.textViewMA4.setOnClickListener(View.OnClickListener {
            val done =
                ManageSubscriptionPlanFragment()
            val manager = activity?.supportFragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.profile_host_container, done)
            transaction?.addToBackStack(null)
            transaction?.commit()
        })

        binding.textViewMA5.setOnClickListener(View.OnClickListener {
            val done =
                ManageDocFragment()
            val manager = activity?.supportFragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.profile_host_container, done)
            transaction?.addToBackStack(null)
            transaction?.commit()
        })

        binding.textViewMA6.setOnClickListener(View.OnClickListener {
            val done =
                ChangePasscodeFragment()
            val manager = activity?.supportFragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.profile_host_container, done)
            transaction?.addToBackStack(null)
            transaction?.commit()
        })

        binding.textViewMA7.setOnClickListener(View.OnClickListener {
            val done =
                ManageUserPrivacyFragment()
            val manager = activity?.supportFragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.profile_host_container, done)
            transaction?.addToBackStack(null)
            transaction?.commit()
        })

        binding.textViewMA14.setOnClickListener(View.OnClickListener {
            val done =
                CloseUserAccountFragment()
            val manager = activity?.supportFragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.profile_host_container, done)
            transaction?.addToBackStack(null)
            transaction?.commit()
        })

        binding.textViewMA15.setOnClickListener(View.OnClickListener {
            showLogOutDialog()
        })

        binding.backBtnMAP.setOnClickListener(View.OnClickListener {
//            FragmentHelper.removeFragment(activity?.supportFragmentManager)
            activity?.finish()
        })

    return binding.root
}

    private fun showLogOutDialog() {
        val dialogBuilder = AlertDialog.Builder(requireContext())

        dialogBuilder.setMessage("Are you sure you want to logout?")
            .setPositiveButton("Log out", DialogInterface.OnClickListener {
                    dialog, id -> dialog.dismiss()
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                    dialog, id -> dialog.dismiss()
            })

        val alert = dialogBuilder.create()
        alert.show()

        alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(
            ContextCompat.getColor(requireContext(),
                R.color.text_clr_blue))
        alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(
            ContextCompat.getColor(requireContext(),
            R.color.text_clr_blue))
    }
}