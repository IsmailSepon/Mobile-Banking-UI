package com.cloudwell.paywell.uiCommon.pay.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.uiCommon.pay.adapter.BankAccountListAdapter
import com.cloudwell.paywell.uiCommon.pay.adapter.PaywellFriendListAdapter
import com.cloudwell.paywell.uiCommon.pay.fragment.bottomsheet.PayBottomSheetMenu
import com.cloudwell.paywell.uiCommon.pay.model.PaywellFriendPOjo
import kotlinx.android.synthetic.main.all_account_layout.view.*

class AllAccountFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.all_account_layout, container, false)



        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        val layoutManager1 =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

        val recycler = view.paywell_friends_recycler
        recycler.layoutManager = layoutManager


        val recycler1 = view.bank_accounts_recycler
        recycler1.layoutManager = layoutManager1





        val pojo : PaywellFriendPOjo = PaywellFriendPOjo()
        pojo.name = "Amzad Hossain"

        val pojo1 : PaywellFriendPOjo = PaywellFriendPOjo()
        pojo1.name = "Anisul Islam - BDT"
        pojo1.mail = "Account number: 0346546478"


        val list = ArrayList<PaywellFriendPOjo>()
        val list1 = ArrayList<PaywellFriendPOjo>()
        list.add(pojo)
        list.add(pojo)
        list.add(pojo)
        list1.add(pojo1)


        recycler.adapter  = activity?.applicationContext?.let { PaywellFriendListAdapter(it, list) }
        recycler1.adapter  = activity?.applicationContext?.let { BankAccountListAdapter(it, list1) }




        view.create_new_pay.setOnClickListener(View.OnClickListener {

            val bottomSheetFragment = PayBottomSheetMenu()
            bottomSheetFragment.show(
                (view.context as AppCompatActivity).supportFragmentManager,
                bottomSheetFragment.tag
            )
        })


        return view
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
        fun newInstance(sectionNumber: Int): AllAccountFragment {
            return AllAccountFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}
