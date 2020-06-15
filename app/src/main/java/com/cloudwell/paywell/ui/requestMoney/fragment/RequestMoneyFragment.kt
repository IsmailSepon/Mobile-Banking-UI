package com.cloudwell.paywell.consumer.ui.requestMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.consumer.ui.requestMoney.fragment.creat_link.RequestMoneyCreatLinkFragment
import com.cloudwell.paywell.consumer.ui.requestMoney.fragment.nearMe.RequestNearDoneFragment
import com.cloudwell.paywell.utils.FragmentHelper
import com.example.nbtk.slider.ScreenUtils
import com.example.nbtk.slider.SliderAdapter
import com.example.nbtk.slider.SliderLayoutManager
import kotlinx.android.synthetic.main.request_money.view.*

class RequestMoneyFragment : Fragment() {

    private lateinit var rvHorizontalPicker: RecyclerView
    private lateinit var tvSelectedItem: TextView

    // private val data = (100..2000).toList().map { it.toString() } as ArrayList<String>
    private val data: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.request_money, container, false)

        val value = requireArguments().getString("activity")

        data.add("300")
        data.add("500")
        data.add("1000")
        data.add("1500")
        data.add("2000")
        data.add("2500")
        data.add("3000")

        setTvSelectedItem(view)
        setHorizontalPicker(view)



        view.request_amount_submit.setOnClickListener(View.OnClickListener {

            if (value.equals("create_link")) {
                FragmentHelper.replaceFragment(
                    RequestMoneyCreatLinkFragment(),
                    activity?.supportFragmentManager,
                    R.id.request_money_container
                )
            } else {
                FragmentHelper.replaceFragment(
                    RequestNearDoneFragment(),
                    activity?.supportFragmentManager,
                    R.id.request_money_container
                )
            }

        })

//        beneficeryViewModel =
//            ViewModelProviders.of(this).get(BeneficeryViewModel::class.java)
//        val binding : AddaccountLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.addaccount_layout, container, false)
//        binding.beneficeryViewModelxml = beneficeryViewModel
//        binding.lifecycleOwner = this
//        return binding.root

        return view
    }


    private fun setTvSelectedItem(view: View) {
        tvSelectedItem = view.findViewById(R.id.textView29)
    }

    private fun setHorizontalPicker(view: View) {
        rvHorizontalPicker = view.findViewById(R.id.rv_horizontal_picker)

        // Setting the padding such that the items will appear in the middle of the screen
        val padding: Int =
            ScreenUtils.getScreenWidth(view.context) / 2 - ScreenUtils.dpToPx(view.context, 40)
        rvHorizontalPicker.setPadding(padding, 0, padding, 0)

        // Setting layout manager
        rvHorizontalPicker.layoutManager = SliderLayoutManager(view.context).apply {
            callback = object : SliderLayoutManager.OnItemSelectedListener {
                override fun onItemSelected(layoutPosition: Int) {
                    tvSelectedItem.text = data[layoutPosition]
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
