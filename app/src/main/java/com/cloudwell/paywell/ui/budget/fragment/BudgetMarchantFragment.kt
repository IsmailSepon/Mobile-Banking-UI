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
import com.cloudwell.paywell.ui.budget.adapter.BudgetMarchentAdapter
import com.cloudwell.paywell.ui.budget.layoutManager.BudgetLayoutManager
import com.cloudwell.paywell.ui.budget.model.BudgetMachentPOjo
import com.cloudwell.paywell.ui.budget.model.BudgetPOjo
import com.example.nbtk.slider.ScreenUtils
import kotlinx.android.synthetic.main.budget_marchent_layout.view.*

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


      var   marchentRecycler : RecyclerView = view.marchent_recycler



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

        setmarchentRecycler(view, marchentRecycler)


        return view
    }

    private fun setmarchentRecycler(view: View?, marchentRecycler: RecyclerView) {

        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        marchentRecycler.layoutManager = linearLayoutManager

        var pojo = BudgetMachentPOjo()
        pojo.amount = "৳3000"
        pojo.persentage = "0%"
        pojo.title = "Other"
        pojo.transcation = "6 Transactions"
        pojo.icon = R.drawable.other_ic

        var pojo1 = BudgetMachentPOjo()
        pojo1.amount = "৳100.22"
        pojo1.persentage = "0%"
        pojo1.title = "Daraz"
        pojo1.transcation = "6 Transactions"
        pojo1.icon = R.drawable.d_shopping_ic

        var pojo2 = BudgetMachentPOjo()
        pojo2.amount = "৳100.22"
        pojo2.persentage = "0%"
        pojo2.title = "Food Panda"
        pojo2.transcation = "6 Transactions"
        pojo2.icon = R.drawable.foodpanda


        var pojo3 = BudgetMachentPOjo()
        pojo3.amount = "৳100.22"
        pojo3.persentage = "0%"
        pojo3.title = "Travel.com"
        pojo3.transcation = "6 Transactions"
        pojo3.icon = R.drawable.travle


        var pojo4 = BudgetMachentPOjo()
        pojo4.amount = "৳320"
        pojo4.persentage = "0%"
        pojo4.title = "Bikroy.com"
        pojo4.transcation = "6 Transactions"
        pojo4.icon = R.drawable.bikroy

        var list = ArrayList<BudgetMachentPOjo>()
        list.add(pojo)
        list.add(pojo1)
        list.add(pojo2)
        list.add(pojo3)
        list.add(pojo4)

        marchentRecycler.adapter = BudgetMarchentAdapter(requireContext(), list)

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
