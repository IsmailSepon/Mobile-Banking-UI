package com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.flightDetails1

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.base.AirTricketBaseActivity
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.flightDetails1.model.RequestAirPriceSearch
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.flightDetails1.model.Segment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.services.activity.eticket.airticket.airportSearch.model.RequestAirSearch
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.flightDetails1.adapter.FlightSequenceAdapter
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.flightDetails1.fragment.AirlessDialogFragment
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.flightDetails1.fragment.FlightFareDialogFragment
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.flightDetails1.model.Airline
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.flightDetails1.model.ResposeAirPriceSearch
import com.cloudwell.paywell.services.activity.eticket.airticket.flightDetails1.viewModel.FlightDetails1ViewModel
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.flightDetails2.FlightDetails2Activity
import com.cloudwell.paywell.data.preferences.AppStorageBox
import com.cloudwell.paywell.utils.CalculationHelper
import com.cloudwell.paywell.utils.DateUtils
import com.cloudwell.paywell.utils.DateUtils.differenceMilliSecond
import kotlinx.android.synthetic.main.contant_flight_details.*
import java.text.SimpleDateFormat
import java.util.*


class FlightDetails1Activity : AirTricketBaseActivity() {


    var totalJourneyinMiliSecound = 0L

    private lateinit var mFlightDetails1ViewModel: FlightDetails1ViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_details)
        setToolbar(getString(R.string.title_booking_and_review))

        rootLayout.visibility = View.INVISIBLE
        initializationView()
        initViewModel()


    }

    private fun initViewModel() {
        mFlightDetails1ViewModel = ViewModelProviders.of(this).get(FlightDetails1ViewModel::class.java)

        mFlightDetails1ViewModel.baseViewStatus.observe(this, Observer {
            handleViewCommonStatus(it)
        })

        mFlightDetails1ViewModel.mViewStatus.observe(this, androidx.lifecycle.Observer {
            handleViewStatus(it)
        })


        mFlightDetails1ViewModel.mListMutableLiveDataResults.observe(this, androidx.lifecycle.Observer {


            it?.let { it1 -> displayData(it1) }

        })

        val mSearchId = intent.extras?.getString("mSearchId", "")
        val resultID = intent.extras?.getString("resultID", "")

        val requestAirPriceSearch = RequestAirPriceSearch()
        requestAirPriceSearch.searchId = mSearchId
        requestAirPriceSearch.resultID = resultID


        mFlightDetails1ViewModel.callAirPriceSearch(requestAirSearch = requestAirPriceSearch)
    }

    private fun handleViewStatus(status: FlightDetails1Status?) {
        status.let {

            if (it?.isShowProcessIndicator == true) {
                showProgressDialog()

            } else {
                dismissProgressDialog()
            }

            if (!it?.noSerachFoundMessage.equals("")) {

                showSnackMessageWithTextMessage(it?.noSerachFoundMessage)

            } else {

            }

        }

    }

    private fun displayData(it: ResposeAirPriceSearch) {
        rootLayout.visibility = View.VISIBLE

        val requestAirSearch = AppStorageBox.get(applicationContext, AppStorageBox.Key.REQUEST_AIR_SERACH) as RequestAirSearch

        val result = it.data?.results?.get(0);


        val segments = result?.segments
        val segment = result?.segments?.get(0)


        //generator of segemnt view
        segments?.let { it1 -> setupTimelineExpanableView(it1) }

        if (segments?.size!! > 1) {
            // multiple route


            val orignAirtportCode = segments.get(0).origin?.airport?.airportCode
            val destinationairportCode = segments.get(0).destination?.airport?.airportCode
            tvOrginAndDestinationAirportCode.text = orignAirtportCode + " - " + destinationairportCode

            AppStorageBox.put(applicationContext, AppStorageBox.Key.orignAirportAnddestinationairportCode, orignAirtportCode + " - " + destinationairportCode)


            val date = segments.get(0).origin?.depTime?.let { DateUtils.getFormatDepTime(it.toString()) }
            AppStorageBox.put(applicationContext, AppStorageBox.Key.humanReadAbleDate, date!!)
            tvNameOfDate.text = date


            val durtingJounaryTime = DateUtils.getDurtingJounaryTime(totalJourneyinMiliSecound)
            AppStorageBox.put(applicationContext, AppStorageBox.Key.totalJourney_time, durtingJounaryTime)


            val orign = segments.get(0)
            var orignTime = orign.origin?.depTime.toString().split("T").get(1)
            orignTime = orignTime.substring(0, orignTime.length - 3)

            val destination = segments.get(0)
            var destinationTime = destination.destination?.arrTime.toString().split("T").get(1)
            destinationTime = destinationTime.substring(0, destinationTime.length - 3)


            tvShortDepartArriveTime.text = orignTime + "-" + destinationTime
            AppStorageBox.put(applicationContext, AppStorageBox.Key.ShortDepartArriveTime, orignTime + "-" + destinationTime)


        } else {

            val orignAirtportCode = segments?.get(0)?.origin?.airport?.airportCode
            val destinationairportCode = segments?.get(segments.size - 1)?.destination?.airport?.airportCode
            tvOrginAndDestinationAirportCode.text = orignAirtportCode + " - " + destinationairportCode
            AppStorageBox.put(applicationContext, AppStorageBox.Key.orignAirportAnddestinationairportCode, orignAirtportCode + " - " + destinationairportCode)



            segments?.let { it1 -> displayHumanDate(it1) }


            val orign = segments?.get(0);
            var orignTime = orign?.origin?.depTime.toString().split("T")?.get(1).toString()
            orignTime = orignTime.substring(0, orignTime.length - 3)

            val destination = segments?.get(segments.size - 1);
            var destinationTime = destination?.destination?.arrTime.toString().split("T")?.get(1).toString()
            destinationTime = destinationTime.substring(0, destinationTime.length - 3)


            tvShortDepartArriveTime.text = orignTime + "-" + destinationTime
            AppStorageBox.put(applicationContext, AppStorageBox.Key.ShortDepartArriveTime, orignTime + "-" + destinationTime)

        }


        val fares = result.fares
        val AIRLINE_CODE = AppStorageBox.get(applicationContext, AppStorageBox.Key.AIRLINE_CODE) as String
        val totalPrice = CalculationHelper.getTotalFareDetati(fares, AIRLINE_CODE)

        tvTotalFair.text = "" + totalPrice
        tvClass.text = getString(R.string.class_text) + ": " + requestAirSearch.segments.get(0).cabinClass



        val fromHtml = Html.fromHtml(getString(R.string.baggage) + segment?.baggage + " " + getString(R.string.kg_per_adult))
        tvBaggage.text = fromHtml


        if (result.passportMadatory!!) {
            tvPassportMandatory.text = getString(R.string.passport_mandatory)
        } else {
            tvPassportMandatory.text = getString(R.string.passport_not_mandatory)
        }

        if (result.extraServices == null) {
            tvExtraService.text = getString(R.string.extra_serviex) + ": " + getString(R.string.n_a)
        } else {
            tvExtraService.text = getString(R.string.extra_serviex) + ": " + getString(R.string.n_a)
        }

        if (result.isRefundable!!) {
            tvRefunable.text = getString(R.string.refundable) + ": " + getString(R.string.yes)
        } else {
            tvRefunable.text = getString(R.string.refundable) + ": " + getString(R.string.no)

        }

        val fareType = it.data?.results?.get(0)?.fareType
        if (fareType.equals("InstantTicketing")) {
            btBook.text = getString(R.string.issue_ticket)
        } else {
            btBook.text = getString(R.string.booking_now)
        }


    }

    private fun setupTimelineExpanableView(segments: List<Segment>) {
        val segmentsList = mutableListOf<FlightSequenceAdapter.MyItem>()

        segments.forEach {
            // parse depDate
            val origin = it.origin
            val depDate = origin?.depTime?.split("T")?.get(0).toString()
            var depTime = origin?.depTime?.split("T")?.get(1).toString()
            depTime = depTime.substring(0, depTime.length - 3)
            val airlineName = it.airline?.airlineName


            // parse journey time
            val split = origin?.depTime.toString().split("T");
            val date = split.get(0) + " " + split.get(1)
            val fistDate = SimpleDateFormat("yyyy-mm-dd HH:mm:ss", Locale.ENGLISH).parse(date)

            val split1 = it.destination?.arrTime.toString().split("T");
            val date1 = split1.get(0) + " " + split1.get(1)
            val secondDate = SimpleDateFormat("yyyy-mm-dd HH:mm:ss", Locale.ENGLISH).parse(date1)

            val differenceDate = differenceMilliSecond(fistDate, secondDate)

            val differenceMilliSecondString = DateUtils.getDartingJanuaryTimeNew(it)

            segmentsList.add(FlightSequenceAdapter.MyItem(true, origin?.airport?.airportName!!, depDate, depTime, airlineName, "", differenceMilliSecondString))


            totalJourneyinMiliSecound = totalJourneyinMiliSecound + differenceDate

            // parse destination
            val destination = it.destination
            val arrDate = destination?.arrTime?.split("T")?.get(0).toString()
            var arrTime = destination?.arrTime?.split("T")?.get(1).toString()
            arrTime = arrTime.substring(0, arrTime.length - 3)
            val cityName = it.destination?.airport?.cityName
            segmentsList.add(FlightSequenceAdapter.MyItem(true, destination?.airport?.airportName!!, arrDate, arrTime, "", cityName!!, ""))

        }

        val flightSequenceAdapter = FlightSequenceAdapter(segmentsList, object : FlightSequenceAdapter.OnFlightClick {
            override fun onclick(airlineName: String?) {
                val airline = segments.get(0).airline

                showAirlessInfo(airline)
            }
        })

        sequenceLayout.setAdapter(flightSequenceAdapter)
    }

    private fun showAirlessInfo(airline: Airline?) {
        val dialogFragment = AirlessDialogFragment()


        val get = mFlightDetails1ViewModel.mListMutableLiveDataResults.value?.data?.results?.get(0)?.fares?.get(0)
        AppStorageBox.put(applicationContext, AppStorageBox.Key.Airline_details, airline!!)

        val args = Bundle()
        args.putParcelable("object", get)

        dialogFragment.arguments = args
        dialogFragment.show(supportFragmentManager, "dialog")


    }


    private fun initializationView() {
        ivUpDown.switchState()
        ivUpDown2.switchState()

        tvOrginAndDestinationAirportCode.visibility = View.GONE
        tvShortDepartArriveTime.visibility = View.GONE
        lineView.visibility = View.GONE


        ivUpDown.setOnClickListener {
            handleUpDownClick()

        }

        ivUpDown2.setOnClickListener {
            handleUpDownClick()
        }

        viewDeartSectionWithoutColor.setOnClickListener {
            handleUpDownClick()
        }


        btBook.setOnClickListener {


            AppStorageBox.put(applicationContext, AppStorageBox.Key.ResposeAirPriceSearch,
                mFlightDetails1ViewModel.mListMutableLiveDataResults.value!!
            )
            val s = Intent(this.applicationContext, FlightDetails2Activity::class.java)
            startActivity(s)

        }


        constrainlayoutPricesDetailsView.setOnClickListener {

            val airlineCode = mFlightDetails1ViewModel.mListMutableLiveDataResults.value?.data?.results?.get(0)?.segments?.get(0)?.airline?.airlineCode


            val get = mFlightDetails1ViewModel.mListMutableLiveDataResults.value?.data?.results?.get(0)?.fares
            AppStorageBox.put(applicationContext, AppStorageBox.Key.FARE_DATA, get!!)

            val s = Intent(this.applicationContext, BaggageAndPoliciesActiivty::class.java)
            startActivity(s)
        }


    }

    private fun showFareDetailsDialog() {
        val ft = supportFragmentManager.beginTransaction()
        val prev = supportFragmentManager.findFragmentByTag("dialog")
        if (prev != null) {
            ft.remove(prev)
        }
        ft.addToBackStack(null)
        val dialogFragment = FlightFareDialogFragment()

        val get = mFlightDetails1ViewModel.mListMutableLiveDataResults.value?.data?.results?.get(0)?.fares?.get(0)

        val args = Bundle()
        args.putParcelable("object", get)

        dialogFragment.arguments = args
        dialogFragment.show(ft, "dialog")
    }

    private fun handleUpDownClick() {
        val expanded = expandable_layout_2.isExpanded
        if (expanded) {
            ivUpDown2.visibility = View.GONE
            expandable_layout_2.collapse()
            rotatedUpUp()
        } else {
            ivUpDown2.visibility = View.VISIBLE
            expandable_layout_2.expand()
            rotatedUpUp()
        }
    }

    private fun rotatedUpUp() {
        ivUpDown.switchState()

        if (tvOrginAndDestinationAirportCode.visibility == View.VISIBLE) {
            tvOrginAndDestinationAirportCode.visibility = View.GONE
            tvShortDepartArriveTime.visibility = View.GONE
            lineView.visibility = View.GONE
        } else {
            tvOrginAndDestinationAirportCode.visibility = View.VISIBLE
            tvShortDepartArriveTime.visibility = View.VISIBLE
            lineView.visibility = View.VISIBLE
        }


    }


    private fun displayHumanDate(outputSegment: List<Segment>) {


        val date = outputSegment.get(0).origin?.depTime?.let { DateUtils.getFormatDepTime(it) }

        AppStorageBox.put(applicationContext, AppStorageBox.Key.humanReadAbleDate, date!!)
        tvNameOfDate.text = date


        val durtingJounaryTime = DateUtils.getDurtingJounaryTime(totalJourneyinMiliSecound)

        AppStorageBox.put(applicationContext, AppStorageBox.Key.totalJourney_time, durtingJounaryTime)


    }


}
