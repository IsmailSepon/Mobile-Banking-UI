package com.cloudwell.paywell.uiBusiness.sendFund.fragment

import android.app.Activity
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.business_send_fund_layout.*
import kotlinx.android.synthetic.main.business_send_fund_layout.view.*


class BusinessSendFundFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.business_send_fund_layout, container, false)


        FragmentHelper.addFirstFragment(
            BusinessSecondSendFundFragment(),
            requireActivity().supportFragmentManager,
            R.id.business_sendFund_container
        )


        view.bulk_payment_layout.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                BusinessBulkPaymentFragment(),
                requireActivity().supportFragmentManager,
                R.id.send_money_container
            )
        })

        view.add_new_beneficiary.setOnClickListener(View.OnClickListener {
            FragmentHelper.replaceFragment(
                BusinessSendFundnewBeneficiryFragment(),
                requireActivity().supportFragmentManager,
                R.id.send_money_container
            )
        })

        view.search_contact.visibility = View.GONE

        view.et_paywell_account.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                view.search_contact.visibility = View.VISIBLE
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                view.search_contact.text = view.et_paywell_account.text
                view.search_contact.setOnClickListener(View.OnClickListener {

                    FragmentHelper.replaceFragment(
                        BusinessSendFundAmountSelectionFragment(),
                        requireActivity().supportFragmentManager,
                        R.id.send_money_container
                    )
                })
            }
        })


        view.phone_contact.setOnClickListener(View.OnClickListener {

            val calContctPickerIntent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            calContctPickerIntent.type = Phone.CONTENT_TYPE
            startActivityForResult(calContctPickerIntent, 1)

        })


        return view
    }


    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            1 -> if (resultCode === Activity.RESULT_OK) {

                    var phoneNumOne: String? = null
                        val phones: Cursor = requireActivity()!!.contentResolver
                            .query(
                                data!!.data!!,
                                null,
                                null,
                                null,
                                null
                            )!!
                        while (phones.moveToNext()) {
                            phoneNumOne =
                                phones.getString(phones.getColumnIndex(Phone.NUMBER))
                        }
                        phones.close()
                        if (!phoneNumOne!!.isEmpty() && !phoneNumOne!!.contains("+") && !phoneNumOne!!.contains(
                                "-"
                            )
                            && !phoneNumOne!!.contains(" ") && !phoneNumOne!!.startsWith("88")
                        ) {
                            et_phone_address.setText(phoneNumOne)
                            goforsendFund(phoneNumOne)
                        } else {
                            if (phoneNumOne!!.contains("+")) {
                                phoneNumOne = phoneNumOne!!.replace("+", "")
                            }
                            if (phoneNumOne!!.contains("-")) {
                                phoneNumOne = phoneNumOne!!.replace("-", "")
                            }
                            if (phoneNumOne!!.contains(" ")) {
                                phoneNumOne = phoneNumOne!!.replace(" ", "")
                            }
                            if (phoneNumOne!!.startsWith("88")) {
                                phoneNumOne = phoneNumOne!!.replace("88", "")
                            }
                            et_phone_address.setText(phoneNumOne)
                            goforsendFund(phoneNumOne)
                        }



            }
        }

    }

    private fun goforsendFund(phoneNumOne: String) {
        FragmentHelper.replaceFragment(
            BusinessSendFundwithPhoneContactFragment(),
            requireActivity().supportFragmentManager,
            R.id.send_money_container
        )
    }



}
