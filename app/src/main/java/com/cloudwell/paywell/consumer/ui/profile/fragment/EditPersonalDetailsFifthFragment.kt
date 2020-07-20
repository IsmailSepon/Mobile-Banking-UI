package com.cloudwell.paywell.consumer.ui.profile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import com.cloudwell.paywell.consumer.utils.FragmentHelper
import kotlinx.android.synthetic.main.edit_personal_details_fifth.view.*
import kotlinx.android.synthetic.main.edit_personal_details_third.view.*

class EditPersonalDetailsFifthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.edit_personal_details_fifth, container, false)

        view.email_verify_done_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                DetailPersonalProfileFragment(),
                activity?.supportFragmentManager,
                R.id.profile_host_container
            )
        })

        return view
    }

}