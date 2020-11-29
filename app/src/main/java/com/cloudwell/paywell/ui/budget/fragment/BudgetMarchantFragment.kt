package com.cloudwell.paywell.ui.budget.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.addMoney.viewModel.AddMoneyViewModel
import com.cloudwell.paywell.ui.budget.adapter.BudgetAdapter
import com.cloudwell.paywell.ui.budget.layoutManager.BudgetLayoutManager
import com.cloudwell.paywell.ui.budget.model.BudgetPOjo
import com.example.nbtk.slider.ScreenUtils

class BudgetMarchantFragment : Fragment() {


    private lateinit var addMoneyViewmodel: AddMoneyViewModel
    private lateinit var rvHorizontalPicker: RecyclerView
    private lateinit var tvSelectedItem: TextView
    private lateinit var sliderAdapter: BudgetAdapter
    private val slidedata: ArrayList<BudgetPOjo> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.budget_marchent_layout, container, false)




        val p  = BudgetPOjo()
        p.amount = "৳0"
        p.month = "This month"

        slidedata.add(p)
        slidedata.add(p)
        slidedata.add(p)
        slidedata.add(p)
        slidedata.add(p)
        slidedata.add(p)
        slidedata.add(p)
        slidedata.add(p)
        slidedata.add(p)
        slidedata.add(p)


        setHorizontalPicker(view)


        return view
    }


    private fun setHorizontalPicker(view: View) {
        rvHorizontalPicker = view.findViewById(R.id.marchentbudget_picker)

        // Setting the padding such that the items will appear in the middle of the screen
        val padding: Int = ScreenUtils.getScreenWidth(view.context) / 2  - ScreenUtils.dpToPx(view.context, 100)

        rvHorizontalPicker.setPadding(padding, 0, padding, 0)
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        rvHorizontalPicker.layoutManager = layoutManager
        // Setting layout manager
        rvHorizontalPicker.layoutManager = BudgetLayoutManager(view.context).apply {
            callback = object : BudgetLayoutManager.OnItemSelectedListener {
                override fun onItemSelected(layoutPosition: Int) {
//                    tvSelectedItem.text = data[layoutPosition]
                    sliderAdapter.setSelectedItem(layoutPosition)
                }
            }
        }

        // Setting Adapter
        sliderAdapter = BudgetAdapter(requireContext())
        sliderAdapter.setSelectedItem(0)
        rvHorizontalPicker.adapter = sliderAdapter.apply {
            setData(slidedata)
            callback = object : BudgetAdapter.Callback {
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



    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): BudgetMarchantFragment {
            return BudgetMarchantFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}
