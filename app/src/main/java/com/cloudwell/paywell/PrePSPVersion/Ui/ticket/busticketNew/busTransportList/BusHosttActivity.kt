package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.busTransportList


import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.busTransportList.fragment.TransportListFragment
import com.cloudwell.paywell.services.activity.eticket.busticketNew.busTransportList.view.IbusTransportListView
import com.cloudwell.paywell.services.activity.eticket.busticketNew.busTransportList.viewModel.BusTransportViewModel
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.fragment.SortFragmentDialog
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.model.ResSeatCheckBookAPI
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.model.Transport
import com.cloudwell.paywell.R
import com.cloudwell.paywell.appController.AppController2
import com.cloudwell.paywell.base.BusTricketBaseActivity
import com.cloudwell.paywell.data.preferences.AppStorageBox
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.RequestScheduledata
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.scheduledata.ScheduleDataItem
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.ticket_confirm.ResposeTicketConfirm
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.passenger.BusPassengerBoothDepartureFragment
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.seatLayout.SeatLayoutFragment
import com.cloudwell.paywell.base.newBase.BaseFragment
import com.google.gson.Gson


class BusHosttActivity : BusTricketBaseActivity(), IbusTransportListView, TransportListFragment.OnFragmentInteractionListener,
    SeatLayoutFragment.OnFragmentInteractionListener {

    override fun setBoardingPoint(allBoothNameInfo: MutableSet<String>) {

    }

    override fun saveRequestScheduledata(p: RequestScheduledata) {

    }

    override fun saveExtraCharge(double: Double) {

    }

    override fun showFilterList(filterTypeDepartingTime: List<ScheduleDataItem>) {


    }

    override fun updateListData(position: Int, itemCount: Int) {

    }

    override fun showProgress() {
        com.orhanobut.logger.Logger.v("showProgress")
        showProgressDialog()

    }

    override fun hiddenProgress() {
        com.orhanobut.logger.Logger.v("dismissProgressDialog")
        dismissProgressDialog()
    }

    override fun showSeatCheckAndBookingRepose(it: ResSeatCheckBookAPI) {

    }

    override fun showShowConfirmDialog(it: ResposeTicketConfirm) {

    }

    override fun showNoTripFoundUI() {
    }


    override fun showErrorMessage(message: String) {

    }

    override fun onItemNextButtonClick(retrunTriple: Boolean) {

        if (viewMode.returnTripTransportListMutableLiveData.value == null) {
            addPassengerActivity(false, "passenger_oneway")
        } else if (retrunTriple == true) {
            addPassengerActivity(true, "passenger_retrun")
        } else {
            addTransportListFragment(true)
        }

    }


    lateinit var requestScheduledata: RequestScheduledata
    lateinit var viewMode: BusTransportViewModel
    var isReSchuduler = false

    val KEY_TransportListFragment = TransportListFragment::class.java.name
    val KEY_SeatLayoutFragment = SeatLayoutFragment::class.java.name
    val KEY_BusPassengerBoothDepartureActivity = BusPassengerBoothDepartureFragment::class.java.name


    lateinit var transport: Transport

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_transport_list)

        val data = AppStorageBox.get(AppController2.getContext(), AppStorageBox.Key.RequestScheduledata) as String
        requestScheduledata = Gson().fromJson(data, RequestScheduledata::class.java)

        initViewModel()


        if (savedInstanceState == null) {
            addTransportListFragment(false)
        }


    }

    private fun addTransportListFragment(isRetrunTriple: Boolean) {
        val newFragment = TransportListFragment(requestScheduledata, isRetrunTriple)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, newFragment)
        transaction.addToBackStack(KEY_TransportListFragment)
//        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction.commit()
    }

    private fun addSeatLayoutFragment(model: ScheduleDataItem, isRetrunTriple: Boolean): Int {
        val newFragment = SeatLayoutFragment(model, isRetrunTriple)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, newFragment)
        transaction.addToBackStack(KEY_SeatLayoutFragment + "" + isRetrunTriple)
//        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        return transaction.commit()
    }


    private fun addPassengerActivity(retrunTriple: Boolean, key: String) {
        val newFragment = BusPassengerBoothDepartureFragment(retrunTriple)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, newFragment)
        transaction.addToBackStack(key)
//        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction.commit()
    }

    private fun initViewModel() {

        viewMode = ViewModelProviders.of(this).get(BusTransportViewModel::class.java)
        viewMode.setIbusTransportListView(this)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.sort -> {
                val busTicketStatusFragment = SortFragmentDialog()
                busTicketStatusFragment.setOnClickListener(object : SortFragmentDialog.OnSortClickListener {
                    override fun buttonLowPrice() {
                        // viewMode.onSort(SortType.LOW_PRICE, viewMode.mistOfSchedule);
                    }

                    override fun buttonHeightPrice() {
                        // viewMode.onSort(SortType.HIGHT_PRICE, viewMode.mistOfSchedule)
                    }

                    override fun buttonLowDepartureTime() {
                        // viewMode.onSort(SortType.LOW_DEPARTURE_TIME, viewMode.mistOfSchedule)
                    }

                    override fun buttonHeightDepartureTime() {
                        // viewMode.onSort(SortType.HIGH_DEPARTURE_TIME, viewMode.mistOfSchedule)

                    }

                    override fun buttonHeightAvailableSeat() {
                        //viewMode.onSort(SortType.HIGH_AVAILABLE_SEAT, viewMode.mistOfSchedule)

                    }

                    override fun buttonLowtAvailableSeat() {
                        // viewMode.onSort(SortType.LOW_AVAILABLE_SEAT, viewMode.mistOfSchedule)
                    }

                })
                busTicketStatusFragment.show(supportFragmentManager, "dialog")
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }


    }

    override fun onFragmentInteraction(uri: Uri) {


    }

    override fun onItemCLick(position: Int, retrunTriple: Boolean) {

        val model: ScheduleDataItem?
        if (!retrunTriple) {
            model = viewMode.singleTripTranportListMutableLiveData.value?.get(position)
        } else {
            model = viewMode.returnTripTransportListMutableLiveData.value?.get(position)
        }

        model.let {
            if (it?.resSeatInfo == null) {
                Toast.makeText(applicationContext, "PLease wait..", Toast.LENGTH_LONG).show()
            } else if (model?.resSeatInfo?.tototalAvailableSeat == 0) {
                showDialogMessage("seat not available")
            } else {
                viewMode.cancelAllRequest()
                model?.let { it1 -> addSeatLayoutFragment(it1, retrunTriple) }
            }
        }

    }

    override fun showErrorMessageAndFinsehdFragment(message: String) {
        showBusTicketErrorDialog(message, true)
    }


    override fun onBackPressed() {
        tellFragments()
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }

    private fun tellFragments() {
        val fragments: List<Fragment> = supportFragmentManager.fragments
        for (f in fragments) {
           // if (f is BaseFragment) f.onBackPressed()
        }
    }


}
