package com.cloudwell.paywell.ui.budget.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.addMoney.viewModel.AddMoneyViewModel
import com.cloudwell.paywell.ui.budget.BudgetHostActivity
import com.cloudwell.paywell.ui.budget.adapter.BudgetAdapter
import com.cloudwell.paywell.ui.budget.adapter.BudgetPagerAdapter
import com.cloudwell.paywell.ui.budget.layoutManager.BudgetLayoutManager
import com.cloudwell.paywell.ui.budget.model.BudgetPOjo
import com.example.nbtk.slider.ScreenUtils
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.budget_main_layout.view.*

class BudgetMainFragment : Fragment() {

    private lateinit var addMoneyViewmodel: AddMoneyViewModel
    private lateinit var rvHorizontalPicker: RecyclerView
    private lateinit var tvSelectedItem: TextView
    private lateinit var sliderAdapter: BudgetAdapter

    var selection = arrayOf("All", "All", "All")

    private val data: ArrayList<String> = ArrayList()
    private val slidedata: ArrayList<BudgetPOjo> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.budget_main_layout, container, false)


        view.selection_spinner.onItemSelectedListener
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), R.layout.budget_spinner_tem, selection)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        view.selection_spinner.adapter = aa

        data.add("300")
        data.add("500")
        data.add("1000")
        data.add("1500")
        data.add("2000")
        data.add("2500")
        data.add("3000")


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




        val beneficiaryDetailsPagerAdapter = BudgetPagerAdapter(requireActivity().applicationContext,requireActivity().supportFragmentManager)
        val viewPager: ViewPager = view.findViewById(R.id.budget_view_pager)
        viewPager.adapter = beneficiaryDetailsPagerAdapter
        val tabs: TabLayout = view.findViewById(R.id.budget_tab)
        tabs.setupWithViewPager(viewPager)


//        view.beneficiary_profile_edit_btn.setOnClickListener(View.OnClickListener {
//            FragmentHelper.replaceFragment(
//                BusinessProfileEditFragment(),
//                requireActivity().supportFragmentManager,
//                R.id.send_money_container
//            )
//        })




        view.add_budget.setOnClickListener(View.OnClickListener {

         requireContext().startActivity(Intent(requireContext(), BudgetHostActivity::class.java))


        })




        return view
    }


    private fun setHorizontalPicker(view: View) {
        rvHorizontalPicker = view.findViewById(R.id.budget_picker)

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

}
