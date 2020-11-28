package com.cloudwell.paywell.uiCommon.pay.fragment.utility

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.adapter.ElectricityAdapter
import com.cloudwell.paywell.uiCommon.pay.adapter.GasListAdapter
import com.cloudwell.paywell.uiCommon.pay.adapter.UtilityAdapter
import com.cloudwell.paywell.uiCommon.pay.adapter.UtilityAdapter.ItemClickListener
import com.cloudwell.paywell.uiCommon.pay.adapter.WatrtListAdapter
import com.cloudwell.paywell.uiCommon.pay.fragment.utility.TopUp.TopupDetailsFragment
import com.cloudwell.paywell.uiCommon.pay.fragment.utility.electricity.desco.DescoDetailsFragment
import com.cloudwell.paywell.uiCommon.pay.fragment.utility.electricity.dpdc.DpdcDetailsFragment
import com.cloudwell.paywell.uiCommon.pay.fragment.utility.electricity.polliBiddut.PolliDetailsFragment
import com.cloudwell.paywell.uiCommon.pay.fragment.utility.electricity.westZone.WestZoneDetailsFragment
import com.cloudwell.paywell.uiCommon.pay.fragment.utility.gas.GasDetailsFragment
import com.cloudwell.paywell.uiCommon.pay.fragment.utility.water.WaterDetailsFragment
import com.cloudwell.paywell.uiCommon.pay.model.UtilityPOjo
import com.cloudwell.paywell.utils.FragmentHelper
import com.google.gson.Gson
import kotlinx.android.synthetic.main.utlity_pay_layout.view.*


class UtilityMainFragment : Fragment(), ItemClickListener,
    ElectricityAdapter.ElecItemClickListener, WatrtListAdapter.ElecItemClickListener,
    GasListAdapter.ElecItemClickListener {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.utlity_pay_layout, container, false)

        val topup_recycler : RecyclerView = view.findViewById(R.id.topup_recyclerview)
        val electronics_recyclerView : RecyclerView = view.findViewById(R.id.electricity_recyclerview)
        val water_recyclerView : RecyclerView = view.findViewById(R.id.water_recyclerview)
        val gas_recyclerView : RecyclerView = view.findViewById(R.id.gas_recyclerview)

        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val linearLayoutManager1: LinearLayoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val linearLayoutManager2: LinearLayoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        val linearLayoutManager3: LinearLayoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        topup_recycler.layoutManager = linearLayoutManager
        electronics_recyclerView.layoutManager = linearLayoutManager1
        water_recyclerView.layoutManager = linearLayoutManager2
        gas_recyclerView.layoutManager = linearLayoutManager3


        val pojo : UtilityPOjo = UtilityPOjo()
        pojo.name = "GP"
        pojo.icon = R.drawable.gp_ic


        val pojo1 : UtilityPOjo = UtilityPOjo()
        pojo1.name = "Robi"
        pojo1.icon = R.drawable.robi_ic

        val pojo2 : UtilityPOjo = UtilityPOjo()
        pojo2.name = "BL"
        pojo2.icon = R.drawable.banglalink_ic

        val pojo3 : UtilityPOjo = UtilityPOjo()
        pojo3.name = "Airtel"
        pojo3.icon = R.drawable.airtel_ic

        val pojo4 : UtilityPOjo = UtilityPOjo()
        pojo4.name = "Teletalk"
        pojo4.icon = R.drawable.teletalk_ic

        val pojo5 : UtilityPOjo = UtilityPOjo()
        pojo5.name = "Skitto"
        pojo5.icon = R.drawable.skitto

        val pojo6 : UtilityPOjo = UtilityPOjo()
        pojo6.name = "DESCO"
        pojo6.icon = R.drawable.desco_ic

        val pojo7 : UtilityPOjo = UtilityPOjo()
        pojo7.name = "DPDC"
        pojo7.icon = R.drawable.dpdc

        val pojo8 : UtilityPOjo = UtilityPOjo()
        pojo8.name = "West Zone"
        pojo8.icon = R.drawable.west_zone_large

        val pojo9 : UtilityPOjo = UtilityPOjo()
        pojo9.name = "Polli Biddyut"
        pojo9.icon = R.drawable.polli_biddut_ic

        val pojo10 : UtilityPOjo = UtilityPOjo()
        pojo10.name = "Dhaka WASA"
        pojo10.icon = R.drawable.wasa_ic

        val pojo11 : UtilityPOjo = UtilityPOjo()
        pojo11.name = "Karnafuli GAS"
        pojo11.icon = R.drawable.karnaphuli_gas


        val list = ArrayList<UtilityPOjo>()
        list.add(pojo)
        list.add(pojo1)
        list.add(pojo2)
        list.add(pojo3)
        list.add(pojo4)
        list.add(pojo5)


        val list2 = ArrayList<UtilityPOjo>()
        list2.add(pojo6)
        list2.add(pojo7)
        list2.add(pojo8)
        list2.add(pojo9)


        val list3 = ArrayList<UtilityPOjo>()
        list3.add(pojo10)


        val list4 = ArrayList<UtilityPOjo>()
        list4.add(pojo11)



        val topupAdapter : UtilityAdapter = UtilityAdapter(requireContext(), list)
        topup_recycler.adapter = activity?.applicationContext?.let { topupAdapter }
        topupAdapter.setClickListener(this)


        val elecAdapter : ElectricityAdapter = ElectricityAdapter(requireContext(), list2)
        electronics_recyclerView.adapter = elecAdapter
        elecAdapter.setClickListener(this)


        val waterAdapter : WatrtListAdapter = WatrtListAdapter(requireContext(), list3)
        water_recyclerView.adapter = waterAdapter
        waterAdapter.setClickListener(this)


        val gasAdapter : GasListAdapter = GasListAdapter(requireContext(), list4)
        gas_recyclerView.adapter = gasAdapter
        gasAdapter.setClickListener(this)





        view.imageView310.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        return view
    }

    override fun onClick(pojo: UtilityPOjo) {

        val fg = TopupDetailsFragment()
        val bundle  = Bundle()
        val gson = Gson()
        val json = gson.toJson(pojo)
        bundle.putString("topup", json)
        fg.arguments = bundle
        FragmentHelper.replaceFragment(
            fg, requireActivity().supportFragmentManager, R.id.payment_container
        )

    }

    override fun onElecClick(pojo: UtilityPOjo, position: Int) {

        val bundle  = Bundle()
        val gson = Gson()
        val json = gson.toJson(pojo)
        bundle.putString("electronics", json)

        if (position == 0){
            val desco = DescoDetailsFragment()
            desco.arguments = bundle
            FragmentHelper.replaceFragment(desco, requireActivity().supportFragmentManager, R.id.payment_container)
        }else if (position == 1){
            val frag = DpdcDetailsFragment()
            frag.arguments = bundle
            FragmentHelper.replaceFragment(frag, requireActivity().supportFragmentManager, R.id.payment_container)
        }else if (position == 2){
            val frag = WestZoneDetailsFragment()
            frag.arguments = bundle
            FragmentHelper.replaceFragment(frag, requireActivity().supportFragmentManager, R.id.payment_container)
        }else if (position == 3){
            val frag = PolliDetailsFragment()
            frag.arguments = bundle
            FragmentHelper.replaceFragment(frag, requireActivity().supportFragmentManager, R.id.payment_container)
        }



    }

    override fun onWaterClick(pojo: UtilityPOjo) {
        val fg = WaterDetailsFragment()
        val bundle  = Bundle()
        val gson = Gson()
        val json = gson.toJson(pojo)
        bundle.putString("water", json)
        fg.arguments = bundle
        FragmentHelper.replaceFragment(
            fg, requireActivity().supportFragmentManager, R.id.payment_container
        )

    }

    override fun onGasClick(pojo: UtilityPOjo) {
        val fg = GasDetailsFragment()
        val bundle  = Bundle()
        val gson = Gson()
        val json = gson.toJson(pojo)
        bundle.putString("gas", json)
        fg.arguments = bundle
        FragmentHelper.replaceFragment(
            fg, requireActivity().supportFragmentManager, R.id.payment_container
        )

    }


}
