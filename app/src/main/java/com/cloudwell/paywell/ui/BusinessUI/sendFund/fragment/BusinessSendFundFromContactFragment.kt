package com.cloudwell.paywell.ui.BusinessUI.sendFund.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import com.example.nbtk.slider.ScreenUtils
import com.example.nbtk.slider.SliderAdapter
import com.example.nbtk.slider.SliderLayoutManager
import kotlinx.android.synthetic.main.business_send_fund_fromcontact_layout.view.*
import kotlinx.android.synthetic.main.send_money.view.send_money_back_btn

class BusinessSendFundFromContactFragment : Fragment() {


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


        data.add("300")
        data.add("500")
        data.add("1000")
        data.add("1500")
        data.add("2000")
        data.add("2500")
        data.add("3000")
        setTvSelectedItem(view)
        setHorizontalPicker(view)

        view.business_send_money_submit.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                BusinessSendFundConfirmationFragment(),
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


    private fun setTvSelectedItem(view: View) {
        tvSelectedItem = view.findViewById(R.id.amount_et)
    }

    private fun setHorizontalPicker(view: View) {
        rvHorizontalPicker = view.findViewById(R.id.rv_horizontal_picker)

        // Setting the padding such that the items will appear in the middle of the screen
//        val padding: Int = ScreenUtils.getScreenWidth(view.context) / 2 - ScreenUtils.dpToPx(view.context, 40)
        val padding: Int =
            ScreenUtils.getScreenWidth(view.context) / 2 - ScreenUtils.dpToPx(view.context, 40)
        rvHorizontalPicker.setPadding(padding, 0, padding, 0)


        // Setting layout manager
        rvHorizontalPicker.layoutManager = SliderLayoutManager(view.context).apply {
            callback = object : SliderLayoutManager.OnItemSelectedListener {
                override fun onItemSelected(layoutPosition: Int) {
                    tvSelectedItem.setText(data[layoutPosition])
                }
            }
        }

        // Setting Adapter
        rvHorizontalPicker.adapter = SliderAdapter(view.context).apply {
            setData(data)
            callback = object : SliderAdapter.Callback {
                override fun onItemClicked(view: View) {
                    rvHorizontalPicker.smoothScrollToPosition(
                        rvHorizontalPicker.getChildLayoutPosition(
                            view
                        )
                    )
                }
            }
        }
    }


}
