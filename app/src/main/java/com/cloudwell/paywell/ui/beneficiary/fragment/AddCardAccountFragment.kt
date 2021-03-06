package com.cloudwell.paywell.ui.beneficiary.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.beneficiary.viewModel.BeneficeryViewModel
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.addaccount_layout.view.address_btn
import kotlinx.android.synthetic.main.addcardaccount_layout.view.*

class AddCardAccountFragment : Fragment() {

    private lateinit var beneficeryViewModel: BeneficeryViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.addcardaccount_layout, container, false)

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
//        val binding : FragmentBeneficiaryBinding = DataBindingUtil.inflate(inflater, R.layout.addcardaccount_layout, container, false)
//        binding.beneficeryViewModel = beneficeryViewModel
//        binding.lifecycleOwner = this
//        return binding.root

        view.card_detils_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })

        return view
    }
}
