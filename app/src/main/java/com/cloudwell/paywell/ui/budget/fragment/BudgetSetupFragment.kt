package com.cloudwell.paywell.ui.budget.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.adapter.AmountPickerAdapter
import com.cloudwell.paywell.ui.addMoney.viewModel.AddMoneyViewModel
import com.cloudwell.paywell.utils.FragmentHelper
import com.cloudwell.paywell.utils.sendMoneyUtils.ScreenUtils
import com.cloudwell.paywell.utils.sendMoneyUtils.SliderLayoutManager
import kotlinx.android.synthetic.main.budget_setup_layout.view.*

class BudgetSetupFragment : Fragment() {

    private lateinit var addMoneyViewmodel: AddMoneyViewModel
    private lateinit var rvHorizontalPicker: RecyclerView
    private lateinit var tvSelectedItem: TextView
    private lateinit var sliderAdapter: AmountPickerAdapter

    private val data: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.budget_setup_layout, container, false)

        data.add("300")
        data.add("500")
        data.add("1000")
        data.add("1500")
        data.add("2000")
        data.add("2500")
        data.add("3000")
        data.add("3000")
        data.add("3000")
        data.add("3000")
        data.add("3000")
        data.add("3000")
        data.add("3000")
        data.add("3000")
        data.add("3000")
        data.add("3000")
        data.add("3000")
        data.add("3000")
        data.add("3000")
        data.add("3000")

        setTvSelectedItem(view)
        //setHorizontalPicker(view)
        setPicker(view)

        view.budget_setup_btn.setOnClickListener(View.OnClickListener {

            FragmentHelper.replaceFragment(BudgetViewFragment(), requireActivity().supportFragmentManager, R.id.budget_container)
        })
        view.budgetsetup_back.setOnClickListener(View.OnClickListener {

            FragmentHelper.removeFragment( requireActivity().supportFragmentManager)
        })


        return view
    }



    private fun setTvSelectedItem(view: View) {
        tvSelectedItem = view.findViewById(R.id.selected_amount)
    }


    private fun setPicker(view: View) {
        //rvHorizontalPicker = view.findViewById(R.id.rv_horizontal_picker)
        rvHorizontalPicker = view.findViewById(R.id.budget_horizontal_picker)

        // Setting the padding such that the items will appear in the middle of the screen
        val padding: Int = ScreenUtils.getScreenWidth(requireContext()) / 2 - ScreenUtils.dpToPx(
            requireContext(),
            40
        )
        rvHorizontalPicker.setPadding(padding, 0, padding, 0)

        // Setting layout manager
        val layoutManager = SliderLayoutManager(requireContext())
        rvHorizontalPicker.layoutManager = layoutManager.apply {
            callback = object : SliderLayoutManager.OnItemSelectedListener {
                override fun onItemSelected(layoutPosition: Int) {
                    sliderAdapter.setSelectedItem(layoutPosition)
                    tvSelectedItem.text = data[layoutPosition]
                }
            }
        }


        // Setting Adapter
        sliderAdapter = AmountPickerAdapter()
        rvHorizontalPicker.adapter = sliderAdapter.apply {
            setData(data)
            callback = object : AmountPickerAdapter.Callback {
                override fun onItemClicked(view: View) {
                    rvHorizontalPicker.smoothScrollToPosition(
                        rvHorizontalPicker.getChildLayoutPosition(
                            view
                        )
                    )
                }
            }
        }


        layoutManager.callback?.onItemSelected(4)
        selectMiddleItem(4)

    }


    private fun selectMiddleItem(position : Int) {

        val centeredItemPosition: Int = ScreenUtils.getScreenWidth(requireContext()) / 2
        rvHorizontalPicker.smoothScrollToPosition(position)
        rvHorizontalPicker.setScrollY(centeredItemPosition)

    }


}
