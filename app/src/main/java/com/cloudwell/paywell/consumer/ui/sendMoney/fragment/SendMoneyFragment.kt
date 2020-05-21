package com.cloudwell.paywell.consumer.ui.sendMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.consumer.R
import com.example.nbtk.slider.ScreenUtils
import com.example.nbtk.slider.SliderAdapter
import com.example.nbtk.slider.SliderLayoutManager
import kotlinx.android.synthetic.main.send_money.view.*

class SendMoneyFragment : Fragment() {

    private lateinit var rvHorizontalPicker: RecyclerView
    private lateinit var tvSelectedItem: TextView

    private val data = (1..10).toList().map { it.toString() } as ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.send_money, container, false)

        setTvSelectedItem(view)
        setHorizontalPicker(view)

        view.send_money_submit.setOnClickListener(View.OnClickListener {
            val done =
                SendMoneyDoneFragment()
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
