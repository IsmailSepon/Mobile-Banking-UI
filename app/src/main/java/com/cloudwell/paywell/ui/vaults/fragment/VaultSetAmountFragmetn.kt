package com.cloudwell.paywell.ui.vaults.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.base.adapter.AmountPickerAdapter
import com.cloudwell.paywell.ui.scheduledTransfer.fragment.schedule.ScheduleDateSelectionFragment
import com.cloudwell.paywell.utils.FragmentHelper
import com.cloudwell.paywell.utils.sendMoneyUtils.ScreenUtils
import com.cloudwell.paywell.utils.sendMoneyUtils.SliderLayoutManager
import kotlinx.android.synthetic.main.vault_setamount_layout.view.*

class VaultSetAmountFragmetn : Fragment() {


    private lateinit var rvHorizontalPicker: RecyclerView
    private lateinit var tvSelectedItem: TextView
    private lateinit var sliderAdapter: AmountPickerAdapter

    private val data: ArrayList<String> = ArrayList()
    //var tag : String? =  null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.vault_setamount_layout, container, false)

        val tag : String = requireArguments().getString("VaultSetAmountFragmetn", "")
        if (tag == "PersonilizeVaultFragmetn"){
            view.textView753.text = "How much would you like to put aside\n"+"each week / month?"
            view.note_txt.visibility = View.VISIBLE
        }else{
            view.textView753.text = "How much would you like\n" + "to save?"
            view.note_txt.visibility = View.GONE
        }

        tvSelectedItem = view.vault_amount
        data.add("300")
        data.add("500")
        data.add("1000")
        data.add("1500")
        data.add("2000")
        data.add("2500")
        data.add("3000")

        setPicker(view)

        view.vault_amount_btn.setOnClickListener(View.OnClickListener {

            if (tag == "PersonilizeVaultFragmetn"){

                val fg : ScheduleDateSelectionFragment = ScheduleDateSelectionFragment()
                val bundle = Bundle()
                bundle.putInt("ScheduleDateSelectionFragment", 2)
                fg.arguments  = bundle
                FragmentHelper.replaceFragment(fg, requireActivity().supportFragmentManager, R.id.vault_intro_container)

            }else{

                FragmentHelper.replaceFragment(VaultSpareFragmetn(), requireActivity().supportFragmentManager, R.id.vault_intro_container)
            }

        })


        view.vault_amount_back.setOnClickListener(View.OnClickListener {

            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })


        return view
    }



    private fun setPicker(view: View) {
        rvHorizontalPicker = view.findViewById(R.id.vault_amount_picker)

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