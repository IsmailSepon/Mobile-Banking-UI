package com.cloudwell.paywell.consumer.ui.home.ui.send_money

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.consumer.R
import kotlinx.android.synthetic.main.send_money.view.*

class SendMoneyFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.send_money, container, false)

        view.np.minValue = 0
        val values = arrayOf("100", "200", "300", "500", "1000", "2000")
        view.np.maxValue = values.size - 1
        view.np.displayedValues = values
        view.np.wrapSelectorWheel = true
        view.np.setOnValueChangedListener(NumberPicker.OnValueChangeListener { picker, oldVal, newVal ->

            view.textView29.text = values[newVal]

        })

        view.send_money_submit.setOnClickListener(View.OnClickListener {
            val done = SendMoneyDoneFragment()
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

        return view
    }

}
