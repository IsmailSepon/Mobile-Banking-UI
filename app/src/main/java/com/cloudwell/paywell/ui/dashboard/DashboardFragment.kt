package com.cloudwell.paywell.ui.dashboard

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.databinding.FragmentDashboardBinding
import com.cloudwell.paywell.ui.authentication.UserAuthenticationHostActivity
import com.cloudwell.paywell.ui.freeCard.FreeCardHostActivity
import com.cloudwell.paywell.ui.help.UserHelpHostActivity
import com.cloudwell.paywell.ui.profile.ProfileHostActivity
import com.cloudwell.paywell.ui.profile.ProfileHostSecondActivity
import com.cloudwell.paywell.ui.switchAccount.SwitchAccountHostActivity
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
        binding.root.imageView6.setOnClickListener(View.OnClickListener {
            Intent(context, UserHelpHostActivity::class.java).also {
                startActivity(it)
            }
        })

        binding.root.textView17.setOnClickListener(View.OnClickListener {
            Intent(context, FreeCardHostActivity::class.java).also {
                startActivity(it)
            }
        })

        binding.root.textView18.setOnClickListener(View.OnClickListener {
            Intent(context, UserAuthenticationHostActivity::class.java).also {
                startActivity(it)
            }
        })

        return binding.root
    }

    private fun showDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.profile_popup)
        val manageAcc = dialog.findViewById(R.id.manage_account) as TextView
        manageAcc.setOnClickListener {
            dialog.dismiss()
            Intent(context, ProfileHostActivity::class.java).also {
                startActivity(it)
            }
        }

        val upgrdAcc = dialog.findViewById(R.id.textViewPP1) as TextView
        upgrdAcc.setOnClickListener {
            dialog.dismiss()
            Intent(context, ProfileHostSecondActivity::class.java).also {
                startActivity(it)
            }
        }

        val switchAcc = dialog.findViewById(R.id.textViewPP2) as TextView
        switchAcc.setOnClickListener {
            dialog.dismiss()
            Intent(context, SwitchAccountHostActivity::class.java).also {
                startActivity(it)
            }
        }

        val signOut = dialog.findViewById(R.id.textViewPP3) as TextView
        signOut.setOnClickListener {
            dialog.dismiss()
            showSignOutDialog()
        }
        dialog.show()
    }

    private fun showSignOutDialog() {
        val dialogBuilder = AlertDialog.Builder(requireContext())

        dialogBuilder.setMessage("Are you sure you want to logout from all accounts?")
            .setPositiveButton("Log out", DialogInterface.OnClickListener { dialog, id ->
                dialog.dismiss()
            })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                dialog.dismiss()
            })

        val alert = dialogBuilder.create()
        alert.show()
        alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(
            ContextCompat.getColor(requireContext(),
            R.color.text_clr_blue))
        alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(ContextCompat.getColor(requireContext(),
            R.color.text_clr_blue))
    }
}
