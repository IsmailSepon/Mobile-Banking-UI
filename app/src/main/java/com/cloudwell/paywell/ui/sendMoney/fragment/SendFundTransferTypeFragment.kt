package com.cloudwell.paywell.ui.sendMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.beneficiary.fragment.AddAccountFragment
import com.cloudwell.paywell.ui.beneficiary.fragment.AddCardAccountFragment
import com.cloudwell.paywell.ui.beneficiary.fragment.AddCompanyAccountFragment
import com.cloudwell.paywell.ui.beneficiary.fragment.ChooseTransferTypeFragment
import com.cloudwell.paywell.ui.beneficiary.viewModel.ChooseTransferViewModel
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.choose_transfertype_layout.view.*
import kotlinx.android.synthetic.main.choose_transfertype_layout.view.back_btn
import kotlinx.android.synthetic.main.choose_transfertype_layout.view.transferBtn
import kotlinx.android.synthetic.main.choose_transfertype_layout.view.transfertype_radiogroup
import kotlinx.android.synthetic.main.sendfund_transfer_type.view.*


class SendFundTransferTypeFragment : Fragment() {

    private lateinit var chooseViewModel: ChooseTransferViewModel
    var select: Int = 1


    fun newInstance(): SendFundTransferTypeFragment? {
        return SendFundTransferTypeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.sendfund_transfer_type, container, false)


//        continers = requireArguments().getInt("chooseTransferType")


//        val selected = view.transfertype_radiogroup.checkedRadioButtonId
//        view.transfertype_radiogroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->  })

        view.sendfund_transfertype_radiogroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId -> // checkedId is the RadioButton selected
            when (checkedId) {
                R.id.radiomyselt -> {
                    select = 1
                }
                R.id.radioanother_person -> {
                    select = 2
                }
                R.id.radio_business -> {
                    select = 3
                }
                R.id.radio_card -> {
                    select = 4
                }
            }
        })
        view.sendfund_transferBtn.setOnClickListener(View.OnClickListener {
            when (select) {
                1 -> {
                    val myself = AddAccountFragment()
                    setFragment(myself)
                }
                2 -> {
                    val myself1 = AddAccountFragment()
                    setFragment(myself1)
                }
                3 -> {
                    val company = AddCompanyAccountFragment()
                    setFragment(company)
                }
                4 -> {
                    val card = AddCardAccountFragment()
                    setFragment(card)
                }
            }
        })

//
//        chooseViewModel =
//            ViewModelProviders.of(this).get(ChooseTransferViewModel::class.java)
//        val binding : ChooseTransfertypeLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.choose_transfertype_layout, container, false)
//        binding.chooseViewmodelXml = chooseViewModel
//        binding.lifecycleOwner = this
//        return binding.root


        view.send_trxback_btn.setOnClickListener(View.OnClickListener {
            activity?.finish()
        })

        return view
    }

    fun setFragment(fragment: Fragment) {

        FragmentHelper.replaceFragment(fragment, requireActivity().supportFragmentManager, R.id.beneficery_host_container)

    }
}
