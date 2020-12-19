package com.cloudwell.paywell.ui.budget.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.broooapps.graphview.CurveGraphConfig
import com.broooapps.graphview.CurveGraphView
import com.broooapps.graphview.models.GraphData
import com.broooapps.graphview.models.PointMap
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.addMoney.viewModel.AddMoneyViewModel
import com.cloudwell.paywell.ui.budget.BudgetHostActivity
import com.cloudwell.paywell.ui.budget.adapter.BudgetAdapter
import com.cloudwell.paywell.ui.budget.adapter.BudgetPagerAdapter
import com.cloudwell.paywell.ui.budget.layoutManager.BudgetLayoutManager
import com.cloudwell.paywell.ui.budget.model.BudgetPOjo
import com.example.nbtk.slider.ScreenUtils
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.budget_main_layout.*
import kotlinx.android.synthetic.main.budget_main_layout.view.*

class BudgetMainFragment : Fragment() {

    private lateinit var addMoneyViewmodel: AddMoneyViewModel
    private lateinit var rvHorizontalPicker: RecyclerView
    private lateinit var tvSelectedItem: TextView
    private lateinit var sliderAdapter: BudgetAdapter

    var selection = arrayOf("All", "Week", "Month")

    private val data: ArrayList<String> = ArrayList()
    private val slidedata: ArrayList<BudgetPOjo> = ArrayList()


    var curveGraphView: CurveGraphView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.budget_main_layout, container, false)


        view.selection_spinner.onItemSelectedListener
        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(
            requireContext(),
            R.layout.budget_spinner_tem,
            selection
        )
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


        curveGraphView = view.budget_graphview
        setBudgetGraph()





        val beneficiaryDetailsPagerAdapter = BudgetPagerAdapter(
            requireActivity().applicationContext,
            requireActivity().supportFragmentManager
        )
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

            val intent: Intent = Intent(requireContext(), BudgetHostActivity::class.java)
            intent.putExtra("budget", 1)
            requireContext().startActivity(intent)


        })



        view.imageView320.setOnClickListener(View.OnClickListener {

            val intent: Intent = Intent(requireContext(), BudgetHostActivity::class.java)
            intent.putExtra("budget", 2)
            requireContext().startActivity(intent)


//            requireContext().startActivity(Intent(requireContext(), BudgetHostActivity::class.java))
//
//            FragmentHelper.replaceFragment(BudgetSpendingFragment(), requireActivity().supportFragmentManager, R.id.budget_container)

        })

        return view
    }

    private fun setBudgetGraph() {


        curveGraphView!!.configure(
            CurveGraphConfig.Builder(requireContext())
                .setAxisColor(R.color.keypad_text_clr)             // Set number of values to be displayed in X ax
                .setVerticalGuideline(7)                // Set number of background guidelines to be shown.
                //  .setHorizontalGuideline(2)
                .setGuidelineColor(R.color.Red)         // Set color of the visible guidelines.
                .setNoDataMsg(" No Data ")              // Message when no data is provided to the view.
                .setxAxisScaleTextColor(R.color.Black)  // Set X axis scale text color.
                .setyAxisScaleTextColor(R.color.Black) // Set Y axis scale text color
                .setAnimationDuration(2000)             // Set Animation Duration
                .build()
        )


        val pointMap = PointMap()
        pointMap.addPoint(0, 200)
        pointMap.addPoint(1, 200)
        pointMap.addPoint(2, 200)
        pointMap.addPoint(3, 400)
        pointMap.addPoint(4, 100)
        pointMap.addPoint(5, 600)


        val gd = GraphData.builder(requireContext())
            .setPointMap(pointMap)
            .setGraphStroke(R.color.Black)
            .setGraphGradient(R.color.keypad_text_clr, R.color.keypad_text_clr)
            .animateLine(true)
            .setPointColor(R.color.Red)
            .setPointRadius(5)
            .build()

        val p2 = PointMap()
        p2.addPoint(0, 440)
        p2.addPoint(1, 0)
        p2.addPoint(2, 100)
        p2.addPoint(3, 0)
        p2.addPoint(4, 400)
        p2.addPoint(5, 200)

        val gd2 = GraphData.builder(requireContext())
            .setPointMap(p2)
            .setGraphStroke(R.color.colorPrimaryDark)
            .setGraphGradient(R.color.colorPrimaryDark, R.color.Orange)
            .animateLine(true)
            .build()

        Handler().postDelayed({ curveGraphView!!.setData(5, 1000, gd, gd2) }, 250)
    }


    private fun setHorizontalPicker(view: View) {
        rvHorizontalPicker = view.findViewById(R.id.budget_picker)

        // Setting the padding such that the items will appear in the middle of the screen
        val padding: Int = ScreenUtils.getScreenWidth(view.context) / 2  - ScreenUtils.dpToPx(
            view.context,
            100
        )

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
