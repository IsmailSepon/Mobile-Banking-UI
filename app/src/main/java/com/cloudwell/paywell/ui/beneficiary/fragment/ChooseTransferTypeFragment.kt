package com.cloudwell.paywell.ui.beneficiary.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.beneficiary.viewModel.ChooseTransferViewModel
import kotlinx.android.synthetic.main.choose_transfertype_layout.view.*


class ChooseTransferTypeFragment : Fragment() {

    private lateinit var chooseViewModel: ChooseTransferViewModel
    var select: Int = 1

    fun newInstance(): ChooseTransferTypeFragment? {
        return ChooseTransferTypeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.choose_transfertype_layout, container, false)

//        val selected = view.transfertype_radiogroup.checkedRadioButtonId
//        view.transfertype_radiogroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->  })
        view.transfertype_radiogroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId -> // checkedId is the RadioButton selected
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
        view.transferBtn.setOnClickListener(View.OnClickListener {
            when (select) {
                1 -> {
                    val myself =
                        AddAccountFragment()
                    setFragment(myself)
                }
                2 -> {
                    val myself1 =
                        AddAccountFragment()
                    setFragment(myself1)
                }
                3 -> {
                    val company =
                        AddCompanyAccountFragment()
                    setFragment(company)
                }
                4 -> {
                    val card =
                        AddCardAccountFragment()
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


        return view
    }

    fun setFragment(fragment: Fragment) {
        val manager = activity?.supportFragmentManager
        val transaction = manager?.beginTransaction()
        transaction?.replace(R.id.beneficery_host_container, fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }
}
