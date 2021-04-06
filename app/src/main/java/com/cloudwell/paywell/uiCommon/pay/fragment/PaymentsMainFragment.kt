package com.cloudwell.paywell.uiCommon.pay.fragment

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.menu.AirTicketMenuActivity
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.menu.BusTicketMenuActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.analytics.AnalyticsManager
import com.cloudwell.paywell.analytics.AnalyticsParameters
import com.cloudwell.paywell.data.preferences.AppStorageBox
import com.cloudwell.paywell.uiCommon.PaymentMainActivity
import com.cloudwell.paywell.uiCommon.contact.ContactActivity
import com.cloudwell.paywell.uiCommon.contact.PhoneContact
import com.cloudwell.paywell.uiCommon.pay.adapter.PayAdapter
import com.cloudwell.paywell.uiCommon.pay.adapter.PaymentAdapter
import com.cloudwell.paywell.uiCommon.pay.model.MyPaymentPOjo
import com.cloudwell.paywell.uiCommon.pay.model.PaytoPOjo
import kotlinx.android.synthetic.main.payments_main_layout.view.*


class PaymentsMainFragment : Fragment(), PaymentAdapter.PaymentClickListener {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.payments_main_layout, container, false)




        setDemoRecycler(view)

        initillizeView(view)


        return view
    }

    private fun setDemoRecycler(view: View) {

        val layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        val layoutManager1 =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

        val recycler = view.horizental_payto_recycler
        recycler.layoutManager = layoutManager


        val recycler1 = view.mypayment_recycler
        recycler1.layoutManager = layoutManager1


        val pojo : PaytoPOjo = PaytoPOjo()
        pojo.name = "Amzad Hossain"


        val list = ArrayList<PaytoPOjo>()
        list.add(pojo)
        list.add(pojo)
        list.add(pojo)


        recycler.adapter  = activity?.applicationContext?.let { PayAdapter(it, list) }


        val payment : MyPaymentPOjo = MyPaymentPOjo()
        payment.name = "Bus ticket"
        payment.icon = R.drawable.bus_ticket_ic

        val payment1 : MyPaymentPOjo = MyPaymentPOjo()
        payment1.name = "Air ticket"
        payment1.icon = R.drawable.air_ticket

        val payment2 : MyPaymentPOjo = MyPaymentPOjo()
        payment2.name = "Shopping"
        payment2.icon = R.drawable.shopping_ic

        val payment3 : MyPaymentPOjo = MyPaymentPOjo()
        payment3.name = "Visa fee"
        payment3.icon = R.drawable.visa_fee

        val payment4 : MyPaymentPOjo = MyPaymentPOjo()
        payment4.name = "Water bill"
        payment4.icon = R.drawable.water_bill_ic

        val payment5 : MyPaymentPOjo = MyPaymentPOjo()
        payment5.name = "GAS"
        payment5.icon = R.drawable.gas_ic


        val paymentlist = ArrayList<MyPaymentPOjo>()
        paymentlist.add(payment)
        paymentlist.add(payment1)
        paymentlist.add(payment2)
        paymentlist.add(payment3)
        paymentlist.add(payment4)
        paymentlist.add(payment5)

        val adapter= PaymentAdapter(requireContext(), paymentlist)
        recycler1.adapter  = adapter //activity?.applicationContext?.let { PaymentAdapter(it, paymentlist) }
        adapter.setClickListener(this)

    }

    private fun initillizeView(view: View) {

        view.username_txt.setOnClickListener(View.OnClickListener {
            val intent = Intent(view.context, PaymentMainActivity::class.java)
            intent.putExtra("payments", "1")
            view.context.startActivity(intent)

        })


        view.search_location.setOnClickListener(View.OnClickListener {
            val intent = Intent(view.context, PaymentMainActivity::class.java)
            intent.putExtra("payments", "2")
            view.context.startActivity(intent)

        })


        view.recurinng_billpay.setOnClickListener(View.OnClickListener {
            val intent = Intent(view.context, PaymentMainActivity::class.java)
            intent.putExtra("payments", "3")
            view.context.startActivity(intent)

        })






        view.utility_btn.setOnClickListener(View.OnClickListener {
            val intent = Intent(view.context, PaymentMainActivity::class.java)
            intent.putExtra("payments", "4")
            view.context.startActivity(intent)

        })


        view.card_emi.setOnClickListener(View.OnClickListener {
            val intent = Intent(view.context, PaymentMainActivity::class.java)
            intent.putExtra("payments", "5")
            view.context.startActivity(intent)

        })




        view.whoto_pay.setOnClickListener(View.OnClickListener {
            val intent = Intent(view.context, PaymentMainActivity::class.java)
            intent.putExtra("payments", "6")
            view.context.startActivity(intent)

        })


        view.ticket_btn.setOnClickListener(View.OnClickListener {

            val intent = Intent(view.context, PaymentMainActivity::class.java)
            intent.putExtra("payments", "7")
            view.context.startActivity(intent)

        })



        view.top_up_btn.setOnClickListener(View.OnClickListener {

            //getContactList()
             getlocalContact()

        })


    }

    private fun getlocalContact() {

      //  FragmentHelper.replaceFragment(LocalContactFragment(), requireActivity().supportFragmentManager, R.id.pre_psp_auth_container)


      //  val intent = Intent(requireContext(), LocalContactActivity::class.java)
      //  val intent = Intent(requireContext(), PhoneContact::class.java)
        val intent = Intent(requireContext(), ContactActivity::class.java)
        startActivity(intent)




    }

    private fun getContactList() {


        val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
        intent.type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
       // startActivityForResult(intent, (topUpView.getTag() as Int))
        startActivityForResult(intent, 1)

    }

    override fun onPaymentClick(pojo: MyPaymentPOjo, view: View, position: Int) {

        if (pojo.name.equals("Bus ticket")){

            AppStorageBox.put(requireContext(), AppStorageBox.Key.IS_BUS_Ticket_USER_FLOW, true)
            AnalyticsManager.sendScreenView(AnalyticsParameters.KEY_BUS_TICKET)
            startActivity(Intent(requireContext(), BusTicketMenuActivity::class.java))

        }else if (pojo.name.equals("Air ticket")){
             val mainIntent = Intent(requireContext(), AirTicketMenuActivity::class.java)
            this.startActivity(mainIntent)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1){
            val phones: Cursor = data!!.data?.let {
                requireActivity().getContentResolver()
                    .query(it, null, null, null, null)
            }!!
            while (phones.moveToNext()) {
              val   phoneNumOne = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

                Log.e("Contact", phoneNumOne.toString())

            }
            phones.close()

        }
    }

}