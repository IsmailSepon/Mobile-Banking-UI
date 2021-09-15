package com.cloudwell.paywell.ui.requestMoney.fragment.creat_link

import android.R.attr
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.consumer.ui.requestMoney.fragment.creat_link.RequestLinkMessageFragment
import com.cloudwell.paywell.utils.FragmentHelper
import kotlinx.android.synthetic.main.request_money_create_link_layout.view.*
import android.widget.Toast

import android.provider.ContactsContract

import android.content.Intent
import android.net.Uri
import android.content.ContentResolver
import android.database.Cursor
import android.util.Log
import androidx.core.app.ActivityCompat.startActivityForResult
import android.app.Activity
import androidx.loader.content.CursorLoader
import com.cloudwell.paywell.utils.ToastHelper
import android.R.attr.data
import android.annotation.SuppressLint
import android.widget.TextView
import kotlinx.android.synthetic.main.request_money_create_link_layout.*


class RequestMoneyCreatLinkFragment : Fragment() {

    lateinit var  _contacttext :TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.request_money_create_link_layout, container, false)

        view.request_btn.setOnClickListener(View.OnClickListener {


            FragmentHelper.replaceFragment(
                RequestLinkMessageFragment(),
                activity?.supportFragmentManager,
                R.id.request_money_container
            )
        })



        view.req_money_back_btn.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(activity?.supportFragmentManager)
        })


        _contacttext = view.findViewById(R.id.textView255)
        _contacttext.setOnClickListener(View.OnClickListener {

            val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            startActivityForResult(intent, 1)
        })

        view.imageView125.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            startActivityForResult(intent, 1)

        })

        return view
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == Activity.RESULT_OK) {

                val contactData = data!!.data

                val loader = CursorLoader(requireContext(), contactData!!, null, null, null, null)
                val c: Cursor = loader.loadInBackground()!!
                if (c.moveToFirst()) {
                    val name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                    val number = c.getString(c.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))
                    Toast.makeText(requireContext(), name.toString(), Toast.LENGTH_SHORT).show()
                    _contacttext.setText(name +" \n"+ number)
                }
            }
        }
    }



}
