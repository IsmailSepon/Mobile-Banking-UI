package com.cloudwell.paywell.ui.linkedAccount.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.linkedAccount.adapter.LinkedBankAdapter
import com.cloudwell.paywell.ui.linkedAccount.model.BankListPojo
import com.cloudwell.paywell.ui.vaults.adapter.VaultAdapter
import com.cloudwell.paywell.ui.vaults.vaultPOjo.VaulttPojo
import com.cloudwell.paywell.utils.FragmentHelper
import com.yanzhenjie.recyclerview.SwipeRecyclerView
import kotlinx.android.synthetic.main.linkedac_bank_list_layout.view.*
import kotlinx.android.synthetic.main.vault_main_layout.view.*
import kotlinx.android.synthetic.main.vault_main_layout.view.vault_recycler

class LinkedACBankListFragment : Fragment(),
    LinkedBankAdapter.BankListItemClickListener {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View =
            inflater.inflate(R.layout.linkedac_bank_list_layout, container, false)

        var   banklistrecyclerview : RecyclerView = view.bankList_recyclerview
        setBankListRecycler(view, banklistrecyclerview)


        view.bank_list_back_btn.setOnClickListener(View.OnClickListener {
            requireActivity().finish()
        })




        return view
    }

    private fun setBankListRecycler(view: View, banklistrecyclerview: RecyclerView) {

        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )
        banklistrecyclerview.layoutManager = linearLayoutManager

        var pojo = BankListPojo()
        pojo.name = "BRAC Bank"
        pojo.icon = R.drawable.brack


        var pojo1 = BankListPojo()
        pojo1.name = "The Ctiy Bank"
        pojo1.icon = R.drawable.city


        var list = ArrayList<BankListPojo>()
        list.add(pojo)
        list.add(pojo)
        list.add(pojo)
        list.add(pojo)
        list.add(pojo)
        list.add(pojo)
        list.add(pojo)
        list.add(pojo)
        list.add(pojo)
        list.add(pojo1)
        list.add(pojo1)
        list.add(pojo1)
        list.add(pojo1)
        list.add(pojo1)
        list.add(pojo1)


        val banklistAdapter : LinkedBankAdapter = LinkedBankAdapter(requireContext(), list)
        banklistrecyclerview.adapter = banklistAdapter
        banklistAdapter.setClickListener(this)
    }

    override fun onBanklistClick(bankListPojo: BankListPojo?) {

        FragmentHelper.replaceFragment(LinkedPermissionFragment(), requireActivity().supportFragmentManager, R.id.linked_account_container)
    }


}