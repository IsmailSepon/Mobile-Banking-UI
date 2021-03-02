package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.transationLog

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.base.TransitionLogBaseActivity
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.booking.model.BookingList
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.booking.model.Datum
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.menu.AirTicketMenuActivity
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.transationLog.adapter.TransitionRVSectionAdapter
import com.cloudwell.paywell.R
import com.cloudwell.paywell.app.AppHandler
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.transationLog.viewBookingInfo.ViewBookingInfoActivity
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_transtionlog.*

open class AirThicketTranslationLogActivity : TransitionLogBaseActivity() {

    lateinit var tag: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transtionlog)

        setToolbar(getString(R.string.transaction_log))


        val bundle = intent.extras
        limit = bundle?.getInt(AirTicketMenuActivity.KEY_LIMIT) ?: 0

        //initViewModel(limit)

        mViewMode.responseList.observe(this, Observer {
            setupList(it)
        })



        mViewMode.getBookingStatus(isInternetConnection, limit)
    }


    private fun setupList(it1: BookingList?) {

        if (it1 == null) {
            ivForNodataFound.visibility = View.VISIBLE
            tvNoDataFound.visibility = View.VISIBLE
        } else {
            ivForNodataFound.visibility = View.GONE
            tvNoDataFound.visibility = View.GONE


            val groupBy = it1!!.data.groupBy {
                it.firstRequestDateTime?.split(" ")?.get(0)
            }

            val isEnglish = AppHandler.getmInstance(applicationContext)?.getAppLanguage().equals("en", ignoreCase = true)

            val sectionAdapter = SectionedRecyclerViewAdapter()

            groupBy.forEach {
                val transitionRVSectionAdapter = TransitionRVSectionAdapter(applicationContext, it.key.toString(), it.value, isEnglish)
                transitionRVSectionAdapter.setOnActionButtonClick(object : TransitionRVSectionAdapter.ItemClickListener {
                    override fun onRootViewClick(datum: Datum) {

                        val newIntent = ViewBookingInfoActivity.newIntent(applicationContext, item = datum)
                        startActivity(newIntent)

                    }

                    override fun onItemClick(datum: Datum) {
                        showThicketIntentPopupMessage(datum)
                    }

                    override fun onActionButtonClick(position: Int, model: Datum) {
                        showActionMenuPopupMessate(model)
                    }


                })
                sectionAdapter.addSection(transitionRVSectionAdapter)

            }

            val linearLayoutManager = LinearLayoutManager(this)

            val sectionHeader = findViewById<RecyclerView>(R.id.listviewLog) as RecyclerView
            sectionHeader.setLayoutManager(linearLayoutManager)
            sectionHeader.setHasFixedSize(true)
            sectionHeader.setAdapter(sectionAdapter)
            sectionHeader.isNestedScrollingEnabled = false;
        }


    }

//    public fun handleViewStatus(it: BookingStatuViewStatus) {
//        if (it.isShowProcessIndicatior) {
//            showProgressDialog()
//        } else {
//            dismissProgressDialog()
//        }
//
//        if (!it.successMessageTricketStatus.equals("")) {
//            showMsg(it.successMessageTricketStatus)
//        }
//
//        if (it.modelPriceChange != null) {
//            showTicketPriceChangeDialog(it.modelPriceChange!!)
//        }
//
//    }



//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        if (item!!.itemId == android.R.id.home)
//            onBackPressed()
//        return super.onOptionsItemSelected(item)
//    }

    override fun onBackPressed() {
        finish()
    }


}
