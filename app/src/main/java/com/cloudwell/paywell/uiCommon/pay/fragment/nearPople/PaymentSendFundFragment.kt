package com.cloudwell.paywell.consumer.ui.requestMoney.fragment.nearMe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiBusiness.sendFund.utility.HorizontalPicker
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.payment_send_fund_layout.view.*

class PaymentSendFundFragment : Fragment() {


    private lateinit var rvHorizontalPicker: RecyclerView
    private lateinit var tvSelectedItem: EditText

    private val data: ArrayList<String> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.payment_send_fund_layout, container, false)




        data.add("\u09F3"+"300")
        data.add("\u09F3"+"500")
        data.add("\u09F3"+"1,000")
        data.add("\u09F3"+"1,500")
        data.add("\u09F3"+"2,000")
        data.add("\u09F3"+"2,500")
        data.add("\u09F3"+"3,000")
        data.add("\u09F3"+"3,500")
        data.add("\u09F3"+"4,000")
        data.add("\u09F3"+"4,500")
        data.add("\u09F3"+"5,000")
        data.add("\u09F3"+"10,000")
        data.add("\u09F3"+"20,000")
        setTvSelectedItem(view)


        view.payment_send_fund_amount_rv.addData(data)

        view.payment_send_fund_amount_rv.setOnScrollStopListener(object : HorizontalPicker.onScrollStopListener{
            override fun selectedView(view: View?) {
                if (view is TextView) {
                    //textView.setText(view.text.toString())
                    // tvSelectedItem.text = view.text.toString() as Editable?

                    tvSelectedItem.setText(view.text.toString())
                } else {
                    // textView.setText(view.javaClass.toString())
                }
            }
        })

        view.payment_send_money_submit.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                RequestNearDoneFragment(),
                requireActivity().supportFragmentManager,
                R.id.payment_container
            )
        })



//        beneficeryViewModel =
//            ViewModelProviders.of(this).get(BeneficeryViewModel::class.java)
//        val binding : AddaccountLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.addaccount_layout, container, false)
//        binding.beneficeryViewModelxml = beneficeryViewModel
//        binding.lifecycleOwner = this
//        return binding.root

        view.paymentsend_money_back_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })
        return view
    }


    fun getListString(): List<String>? {
        val listString: MutableList<String> =
            java.util.ArrayList()
        for (i in 0..29) {
            listString.add("" + (i + 1))
        }
        return listString
    }



    private fun setTvSelectedItem(view: View) {
        tvSelectedItem = view.findViewById(R.id.payment_amount_et)
    }

}
