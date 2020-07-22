package com.cloudwell.paywell.ui.addMoney.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.databinding.AddMoneyBinding
import com.cloudwell.paywell.ui.addMoney.view.IaddMoneyVIew
import com.cloudwell.paywell.ui.addMoney.viewModel.AddMoneyViewModel
import com.cloudwell.paywell.utils.FragmentHelper
import com.example.nbtk.slider.ScreenUtils
import com.example.nbtk.slider.SliderAdapter
import com.example.nbtk.slider.SliderLayoutManager

class AddMoneyFragment : Fragment(), IaddMoneyVIew {

    private lateinit var addMoneyViewmodel: AddMoneyViewModel
    private lateinit var rvHorizontalPicker: RecyclerView
    private lateinit var tvSelectedItem: TextView

    private val data: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addMoneyViewmodel = ViewModelProviders.of(this).get(AddMoneyViewModel::class.java)
        val binding: AddMoneyBinding =
            DataBindingUtil.inflate(inflater, R.layout.add_money, container, false)
        addMoneyViewmodel.setView(this)
        binding.addmoneyView = addMoneyViewmodel
        binding.lifecycleOwner = this

        data.add("300")
        data.add("500")
        data.add("1000")
        data.add("1500")
        data.add("2000")
        data.add("2500")
        data.add("3000")

        setTvSelectedItem(binding.root)
        setHorizontalPicker(binding.root)


        return binding.root
    }

    override fun addMoneySubmit() {
        Toast.makeText(activity, "click", Toast.LENGTH_LONG).show()
    }

    override fun type_change() {
        FragmentHelper.replaceFragment(
            AddMoneySelectionFragment(), activity?.supportFragmentManager,
            R.id.add_money_container
        )
    }

    override fun add_money_back_btn() {
        activity?.finish()
    }

    override fun noInternetConnectionFound() {

    }

    override fun showProgress() {
    }

    override fun hiddenProgress() {
    }

    override fun onFailure(message: String?) {
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
