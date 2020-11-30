package com.cloudwell.paywell.ui.vaults.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.vaults.activity.VaultAddActivity
import com.cloudwell.paywell.ui.vaults.adapter.VaultAdapter
import com.cloudwell.paywell.ui.vaults.vaultPOjo.VaulttPojo
import kotlinx.android.synthetic.main.vault_main_layout.view.*

class VaultViewFragment : Fragment() {


    private val data: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.vault_main_layout, container, false)



        var   vaultRecycler : RecyclerView = view.vault_recycler



        setVaultRecycler(view, vaultRecycler)




        view.add_vault_lay.setOnClickListener(View.OnClickListener {

            requireContext().startActivity(Intent(requireContext(), VaultAddActivity::class.java))
        })

        return view
    }


    private fun setVaultRecycler(view: View?, vaultRecycler: RecyclerView) {

        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        vaultRecycler.layoutManager = linearLayoutManager

        var pojo = VaulttPojo()
        pojo.name = "Savings"
        pojo.cost = "of ৳ 20,000"
        pojo.costAmount = "৳ 6,500"


        var pojo1 = VaulttPojo()
        pojo1.name = "India Trip"
        pojo1.cost = "of ৳ 20,000"
        pojo1.costAmount = "৳ 6,500"


        var list = ArrayList<VaulttPojo>()
        list.add(pojo)
        list.add(pojo1)

        vaultRecycler.adapter = VaultAdapter(requireContext(), list)

    }



}
