package com.cloudwell.paywell.ui.budget.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.budget_catagory_layout.view.*

class AddNewCatagoryFragment : Fragment() {


    private val data: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.budget_catagory_layout, container, false)






        view.addnew_catagory.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(MonthlySuccessFragment(), requireActivity().supportFragmentManager, R.id.budget_container)

        })

        return view
    }


}
