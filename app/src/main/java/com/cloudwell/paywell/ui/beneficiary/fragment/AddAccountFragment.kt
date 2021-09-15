package com.cloudwell.paywell.ui.beneficiary.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.beneficiary.viewModel.BeneficeryViewModel
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.addaccount_layout.view.*

class AddAccountFragment : Fragment() {

    private lateinit var beneficeryViewModel: BeneficeryViewModel


    var country = arrayOf("Select Country", "Bangladesh", "India", "USA", "China", "Japan", "Other")
    var district = arrayOf("Select District","Dhaka", "Barisal")



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.addaccount_layout, container, false)

        view.address_btn.setOnClickListener(View.OnClickListener {

            val done =
                BeneficeryDone()
            val manager = activity?.supportFragmentManager
            val transaction = manager?.beginTransaction()
            transaction?.replace(R.id.beneficery_host_container, done)
            transaction?.addToBackStack(null)
            transaction?.commit()
        })

//        beneficeryViewModel =
//            ViewModelProviders.of(this).get(BeneficeryViewModel::class.java)
//        val binding : AddaccountLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.addaccount_layout, container, false)
//        binding.beneficeryViewModelxml = beneficeryViewModel
//        binding.lifecycleOwner = this
//        return binding.root


        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext()!!, android.R.layout.simple_spinner_item, country)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        view.division_sp?.setAdapter(aa);

        val aa1: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext()!!, android.R.layout.simple_spinner_item, district)
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        view.district_sp?.setAdapter(aa1);


        view.add_account_back_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })

        return view
    }


}
