package com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.BusinessUI.sendFund.utility.HorizontalPicker
import com.cloudwell.paywell.utils.FragmentHelper
import com.example.nbtk.slider.ScreenUtils
import com.example.nbtk.slider.SliderAdapter
import com.example.nbtk.slider.SliderLayoutManager
import kotlinx.android.synthetic.main.business_send_fund_fromcontact_layout.view.*
import kotlinx.android.synthetic.main.send_money.view.send_money_back_btn

class BusinessSendFundAmountSelectionFragment : Fragment() {


    private lateinit var rvHorizontalPicker: RecyclerView
    private lateinit var tvSelectedItem: EditText

    // private val data = (1..10).toList().map { it.toString() } as ArrayList<String>
    private val data: ArrayList<String> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =
            inflater.inflate(R.layout.business_send_fund_fromcontact_layout, container, false)


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


            view.business_send_fund_amount_rv.addData(data)

            view.business_send_fund_amount_rv.setOnScrollStopListener(object : HorizontalPicker.onScrollStopListener{
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

        view.business_send_money_submit.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                BusinessSendFundSuccessfullFragment(),
                requireActivity().supportFragmentManager,
                R.id.send_money_container
            )
        })

        view.schedule_later_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                BusinessSendMoneyReviewFragment(),
                requireActivity().supportFragmentManager,
                R.id.send_money_container
            )
        })

//        beneficeryViewModel =
//            ViewModelProviders.of(this).get(BeneficeryViewModel::class.java)
//        val binding : AddaccountLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.addaccount_layout, container, false)
//        binding.beneficeryViewModelxml = beneficeryViewModel
//        binding.lifecycleOwner = this
//        return binding.root

        view.send_money_back_btn.setOnClickListener(View.OnClickListener {
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
        tvSelectedItem = view.findViewById(R.id.amount_et)
    }

}
