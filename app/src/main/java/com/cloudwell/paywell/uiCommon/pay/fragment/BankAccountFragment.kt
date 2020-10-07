package com.cloudwell.paywell.uiCommon.pay.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudwell.paywell.R
import com.cloudwell.paywell.ui.beneficiary.fragment.ChooseTransferTypeFragment
import com.cloudwell.paywell.uiCommon.pay.adapter.BankAccountListAdapter
import com.cloudwell.paywell.uiCommon.pay.model.PaywellFriendPOjo
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.all_bank_account_layout.view.*

class BankAccountFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.all_bank_account_layout, container, false)

        val layoutManager1 =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

        val recycler1 = view.bank_ac_recycler
        recycler1.layoutManager = layoutManager1



        val pojo1 : PaywellFriendPOjo = PaywellFriendPOjo()
        pojo1.name = "Anisul Islam - BDT"
        pojo1.mail = "Account number: 0346546478"
        val list1 = ArrayList<PaywellFriendPOjo>()

        list1.add(pojo1)

        recycler1.adapter  = activity?.applicationContext?.let { BankAccountListAdapter(it, list1) }



        view.add_new_bank.setOnClickListener(View.OnClickListener {
            val fg : ChooseTransferTypeFragment = ChooseTransferTypeFragment()
            val bundle = Bundle()
            bundle.putInt("chooseTransferType", 2)
            fg.arguments  = bundle
            FragmentHelper.replaceFragment(fg, requireActivity().supportFragmentManager, R.id.payment_container)

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
        fun newInstance(sectionNumber: Int): BankAccountFragment {
            return BankAccountFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}
