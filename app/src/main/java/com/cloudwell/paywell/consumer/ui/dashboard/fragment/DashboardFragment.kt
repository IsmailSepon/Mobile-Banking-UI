package com.cloudwell.paywell.consumer.ui.dashboard.fragment

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.databinding.FragmentDashboardBinding
import com.cloudwell.paywell.consumer.ui.dashboard.ProfileHostActivity
import com.cloudwell.paywell.consumer.ui.dashboard.viewmodel.DashboardViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)

        val binding: FragmentDashboardBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        binding.dashboardViewModel = dashboardViewModel
        binding.lifecycleOwner = this

        binding.root.textViewDFUsername.setOnClickListener(View.OnClickListener {
            showDialog()
        })
        return binding.root
    }

    private fun showDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.profile_popup)
        val body = dialog.findViewById(R.id.manage_account) as TextView
        body.setOnClickListener {
            dialog.dismiss()
            Intent(context, ProfileHostActivity::class.java).also {
                startActivity(it)
            }
        }
        dialog.show()
    }
}
