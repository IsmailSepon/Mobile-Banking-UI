package com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.fragment

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.fragment.app.Fragment
import com.cloudwell.paywell.services.activity.eticket.airticket.*
import com.cloudwell.paywell.services.activity.eticket.airticket.airportSearch.model.RequestAirSearch
import com.cloudwell.paywell.services.activity.eticket.airticket.airportSearch.model.Segment
import com.cloudwell.paywell.services.activity.eticket.airticket.airportSearch.search.AirportsSearchActivity
import com.cloudwell.paywell.services.activity.eticket.airticket.airportSearch.search.model.Airport
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.flightSearch.FlightSearchViewActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.app.AppHandler
import com.cloudwell.paywell.appController.AppController2
import com.cloudwell.paywell.customView.clearableEditText.SlyCalendarDialog
import com.cloudwell.paywell.data.preferences.AppStorageBox
import com.cloudwell.paywell.utils.FormatHelper
import com.cloudwell.paywell.utils.FormatHelper.getPortLevelText
import kotlinx.android.synthetic.main.fragment_round_trip.*

import kotlinx.android.synthetic.main.fragment_round_trip.view.*
import mehdi.sakout.fancybuttons.FancyButton
import java.text.SimpleDateFormat
import java.util.*


class RoundTripFragment : Fragment(), View.OnClickListener, SlyCalendarDialog.Callback {


    private lateinit var fromAirport: Airport
    private lateinit var toAirport: Airport


    var humanReadAbleDateFirst: String = ""
    var humanReadAbleDateSecond: String = ""


    lateinit var tvClass: TextView

    private val REQ_CODE_FROM = 1
    private val REQ_CODE_TO = 3


    lateinit var mClassModel: ClassModel

    lateinit var airTicketAdult: TextView
    lateinit var airTicketKid: TextView
    lateinit var airTicketInfant: TextView

    private lateinit var frameLayout: FrameLayout
    private var mAppHandler: AppHandler? = null

    companion object {
        val KEY_DEAPRT = "Deaprt"
        val KEY_RETURN = "Return"
    }

    private lateinit var searchRoundTripModel: SearchRoundTripModel
    var isReSchuduler = false

    override fun onDataSelected(firstDate: Calendar?, secondDate: Calendar?, hours: Int, minutes: Int) {
        if (firstDate != null && secondDate != null) {

            val nameOfDayOfWeekFirst = SimpleDateFormat("EEE", Locale.ENGLISH).format(firstDate.time)
            val nameOfMonthFirst = SimpleDateFormat("MMM", Locale.ENGLISH).format(firstDate.time)
            val dayFirst = SimpleDateFormat("dd", Locale.ENGLISH).format(firstDate.time)

            tvDepartDate.text = "$nameOfDayOfWeekFirst, $dayFirst $nameOfMonthFirst"
            tvDepartDate.setTextColor(Color.BLACK);

            humanReadAbleDateFirst = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(firstDate.time)


            AppStorageBox.put(activity?.applicationContext!!, AppStorageBox.Key.DEPART_DATE_FIRST_ROUND, humanReadAbleDateFirst)


            val nameOfDayOfWeekSecound = SimpleDateFormat("EEE", Locale.ENGLISH).format(secondDate.time)
            val nameOfMonthSecound = SimpleDateFormat("MMM", Locale.ENGLISH).format(secondDate.time)
            val daySecound = SimpleDateFormat("dd", Locale.ENGLISH).format(secondDate.time)

            tvDepartDate2.text = "$nameOfDayOfWeekSecound, $daySecound $nameOfMonthSecound"
            tvDepartDate2.setTextColor(Color.BLACK);

            humanReadAbleDateSecond = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(secondDate.time)

            AppStorageBox.put(activity?.applicationContext!!, AppStorageBox.Key.DEPART_DATE_SECOUND_ROUND, humanReadAbleDateSecond)

        }

    }

    override fun onCancelled() {
    }


    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.tvFrom -> {

                val intent = Intent(context, AirportsSearchActivity::class.java)
                intent.putExtra("from", 1)
                intent.putExtra("isTo", false)
                startActivityForResult(intent, REQ_CODE_FROM)
            }

            R.id.layoutTo -> {

                val intent = Intent(context, AirportsSearchActivity::class.java)
                intent.putExtra("from", 1)
                intent.putExtra("isTo", true)
                startActivityForResult(intent, REQ_CODE_TO)
            }

            R.id.tvDeaprt -> {
                showDepartDatePicker(KEY_DEAPRT)
            }
            R.id.tvDepart1 -> {
                showDepartDatePicker(KEY_DEAPRT)
            }
            R.id.tvDepartDate -> {
                showDepartDatePicker(KEY_DEAPRT)
            }


            R.id.layoutReturn -> {

                showDepartDatePicker(KEY_RETURN)
            }
            R.id.tvDepart2 -> {

                showDepartDatePicker(KEY_RETURN)
            }
            R.id.tvDepartDate2 -> {

                showDepartDatePicker(KEY_RETURN)
            }

            R.id.layoutDepart -> {


            }

            R.id.btn_search -> {

                handleSearchClick()
            }
        }


    }

    private fun showDepartDatePicker(s: String) {
        val calendar = Calendar.getInstance()

        val year = calendar.get(Calendar.YEAR)
        val thismonth = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        if (s.equals(KEY_DEAPRT)) {
            if (!tvDepartDate.text.equals(getString(R.string.date))) {
                val crachDepartureDate = AppStorageBox.get(activity?.applicationContext!!, AppStorageBox.Key.DEPART_DATE_FIRST_ROUND) as String?

                val date = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(crachDepartureDate) as Date
                calendar.time = date

            }
        } else {
            if (!tvDepartDate2.text.equals(getString(R.string.date))) {
                val crachDepartureDate = AppStorageBox.get(activity?.applicationContext!!, AppStorageBox.Key.DEPART_DATE_SECOUND_ROUND) as String?

                val date = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(crachDepartureDate) as Date
                calendar.time = date

            }

        }


        val datePickerDialog = context?.let {
            DatePickerDialog(it,
                    DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                        if (s.equals(KEY_DEAPRT)) {
                            val calendar = Calendar.getInstance()
                            calendar.set(Calendar.YEAR, year)
                            calendar.set(Calendar.MONTH, month)
                            calendar.set(Calendar.DAY_OF_MONTH, day)
                            val date = calendar.getTime()


                            val nameOfDayOfWeekFirst = SimpleDateFormat("EEE", Locale.ENGLISH).format(calendar.time)
                            val nameOfMonthFirst = SimpleDateFormat("MMM", Locale.ENGLISH).format(calendar.time)
                            val dayFirst = SimpleDateFormat("dd", Locale.ENGLISH).format(calendar.time)

                            val human = "$nameOfDayOfWeekFirst, $dayFirst $nameOfMonthFirst"

                            tvDepartDate.text = "$nameOfDayOfWeekFirst, $dayFirst $nameOfMonthFirst"
                            tvDepartDate.setTextColor(Color.BLACK);

                            humanReadAbleDateFirst = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar.time)


                            AppStorageBox.put(activity?.applicationContext!!, AppStorageBox.Key.DEPART_DATE_FIRST_ROUND, humanReadAbleDateFirst)
                            AppStorageBox.put(activity?.applicationContext!!, AppStorageBox.Key.DEPART_DATE_FIRST_ROUND_Human, human)

                        } else {


                            val calendar1 = Calendar.getInstance()
                            calendar1.set(Calendar.YEAR, year)
                            calendar1.set(Calendar.MONTH, month)
                            calendar1.set(Calendar.DAY_OF_MONTH, day)
                            val date = calendar1.getTime()

                            val nameOfDayOfWeekSecound = SimpleDateFormat("EEE", Locale.ENGLISH).format(calendar1.time)
                            val nameOfMonthSecound = SimpleDateFormat("MMM", Locale.ENGLISH).format(calendar1.time)
                            val daySecound = SimpleDateFormat("dd", Locale.ENGLISH).format(calendar1.time)


                            val human = "$nameOfDayOfWeekSecound, $daySecound $nameOfMonthSecound"
                            tvDepartDate2.text = "$nameOfDayOfWeekSecound, $daySecound $nameOfMonthSecound"
                            tvDepartDate2.setTextColor(Color.BLACK);

                            humanReadAbleDateSecond = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(calendar1.time)

                            AppStorageBox.put(activity?.applicationContext!!, AppStorageBox.Key.DEPART_DATE_SECOUND_ROUND, humanReadAbleDateSecond)
                            AppStorageBox.put(activity?.applicationContext!!, AppStorageBox.Key.DEPART_DATE_SECOUND_ROUND_hyuman, human)
                        }


                    }, year, thismonth, dayOfMonth)
        }

        val calendarMin = Calendar.getInstance()
        datePickerDialog?.datePicker?.updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
        datePickerDialog?.datePicker?.minDate = (calendarMin.timeInMillis - 10000)
        datePickerDialog?.show()

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_round_trip, container, false)

        inilitzationView(view)


        return view
    }

    private fun inilitzationView(view: View) {

        frameLayout = view.findViewById(R.id.myView)
        val tvDepart = view.findViewById<TextView>(R.id.tvDepart2)
        val tvDepartDate = view.findViewById<TextView>(R.id.tvDepartDate)
        val airTicketClass = view.findViewById<TextView>(R.id.airTicketClass)
        val llPassenger = view.findViewById<LinearLayout>(R.id.llPassenger)
        val btnSearch = view.findViewById<FancyButton>(R.id.btn_search)
        val tvFrom = view.findViewById<LinearLayout>(R.id.tvFrom)
        val layoutTo = view.findViewById<LinearLayout>(R.id.layoutTo)
        val layoutDepart = view.findViewById<LinearLayout>(R.id.layoutDepart)
        val tvClass = view.findViewById<TextView>(R.id.airTicketClass)

        layoutDepart.setOnClickListener(this)
        view.tvDeaprt.setOnClickListener(this)
        view.layoutReturn.setOnClickListener(this)
        view.tvDepart1.setOnClickListener(this)
        view.tvDepartDate.setOnClickListener(this)
        view.tvDepart2.setOnClickListener(this)
        view.tvDepartDate2.setOnClickListener(this)



        mAppHandler = AppHandler.getmInstance(context)

        tvDepart.setOnClickListener(this)
        tvDepartDate.setOnClickListener(this)
        airTicketClass.setOnClickListener(this)
        llPassenger.setOnClickListener(this)
        btnSearch.setOnClickListener(this)
        tvFrom.setOnClickListener(this)
        layoutTo.setOnClickListener(this)

        view.btn_search.setOnClickListener(this)


        airTicketInfant = view.findViewById<TextView>(R.id.airTicketInfant)
        airTicketAdult = view.findViewById<TextView>(R.id.airTicketAdult)
        airTicketKid = view.findViewById<TextView>(R.id.airTicketKid)

        val tsFrom = view.findViewById<TextSwitcher>(R.id.tsRoundTripFrom)
        val tsFromPort = view.findViewById<TextSwitcher>(R.id.tsRoundTripFromPort)
        val tsTo = view.findViewById<TextSwitcher>(R.id.tsRoundTripTo)
        val tsToPort = view.findViewById<TextSwitcher>(R.id.tsRoundTripToPort)
        val ivSwitchTrip = view.findViewById<ImageView>(R.id.ivRoundTripTextSwitcher)

        tsFrom.removeAllViews()
        tsFrom.setFactory {
            TextView(android.view.ContextThemeWrapper(context,
                    R.style.TicketFrom), null, 0)
        }
        tsFromPort.removeAllViews()
        tsFromPort.setFactory {
            TextView(android.view.ContextThemeWrapper(context,
                    R.style.TicketFromPort), null, 0)
        }
        tsTo.removeAllViews()
        tsTo.setFactory {
            TextView(android.view.ContextThemeWrapper(context,
                    R.style.TicketTo), null, 0)
        }
        tsToPort.removeAllViews()
        tsToPort.setFactory {
            TextView(android.view.ContextThemeWrapper(context,
                    R.style.TicketToPort), null, 0)
        }
        val inAnim = AnimationUtils.loadAnimation(context,
                android.R.anim.fade_in)
        val outAnim = AnimationUtils.loadAnimation(context,
                android.R.anim.fade_out)
        inAnim.duration = 200
        outAnim.duration = 200
        tsFrom.inAnimation = inAnim
        tsFrom.outAnimation = outAnim
        tsFromPort.inAnimation = inAnim
        tsFromPort.outAnimation = outAnim
        tsTo.inAnimation = inAnim
        tsTo.outAnimation = outAnim
        tsToPort.inAnimation = inAnim
        tsToPort.outAnimation = outAnim

        tsFrom.setCurrentText(activity?.application?.getString(R.string.from))
        tsFromPort.setCurrentText(activity?.application?.getString(R.string.airport))
        view.tvHitFrom.visibility = View.INVISIBLE


        tsTo.setCurrentText(activity?.application?.getString(R.string.to))
        tsToPort.setCurrentText(activity?.application?.getString(R.string.airport))
        view.tvHitTo.visibility = View.INVISIBLE

        val fromCacheAirport = AppStorageBox.get(activity?.applicationContext!!, AppStorageBox.Key.FROM_CACHE) as Airport?
        if (fromCacheAirport != null) {
            view.tsRoundTripFrom.setText(fromCacheAirport.iata)
            view.tsRoundTripFromPort.setText(fromCacheAirport.airportName)
            view.tvHitFrom.visibility = View.VISIBLE

            fromAirport = Airport()
            fromAirport.iata = fromCacheAirport.iata

        } else {
            tsFrom.setCurrentText(activity?.application?.getString(R.string.from))
            tsFromPort.setCurrentText(activity?.application?.getString(R.string.airport))
            view.tvHitFrom.visibility = View.INVISIBLE
        }


        val toCacheAirport = AppStorageBox.get(activity?.applicationContext!!, AppStorageBox.Key.TO_CACHE) as Airport?
        if (toCacheAirport != null) {

            view.tsRoundTripTo.setText(toCacheAirport.iata)
            view.tsRoundTripToPort.setText(toCacheAirport.airportName)
            view.tvHitTo.visibility = View.VISIBLE

            toAirport = Airport()
            toAirport.iata = toCacheAirport.iata

        } else {
            tsTo.setCurrentText(activity?.application?.getString(R.string.to))
            tsToPort.setCurrentText(activity?.application?.getString(R.string.airport))
            view.tvHitTo.visibility = View.INVISIBLE
        }


        val textFrom = tsFrom.currentView as TextView
        val textFromPort = tsFromPort.currentView as TextView
        val textTo = tsTo.currentView as TextView
        val textToPort = tsToPort.currentView as TextView

        searchRoundTripModel = SearchRoundTripModel(textFrom.text.toString(), textTo.text.toString(), textFromPort.text.toString(), textToPort.text.toString())

        ivSwitchTrip.setOnClickListener {
            tsFrom.setText(searchRoundTripModel.getToName())
            tsTo.setText(searchRoundTripModel.getFromName())

            val from = searchRoundTripModel.getFromName()
            searchRoundTripModel.setFromName(searchRoundTripModel.getToName())
            searchRoundTripModel.setToName(from)

            tsFromPort.setText(searchRoundTripModel.getToPortName())
            tsToPort.setText(searchRoundTripModel.getFromPortName())

            val fromPort = searchRoundTripModel.getFromPortName()
            searchRoundTripModel.setFromPortName(searchRoundTripModel.getToPortName())
            searchRoundTripModel.setToPortName(fromPort)


            val fromAirTricket = Airport()
            fromAirTricket.airportName = searchRoundTripModel.fromPort
            fromAirTricket.iata = searchRoundTripModel.getFromName()
            AppStorageBox.put(activity?.applicationContext!!, AppStorageBox.Key.FROM_CACHE, fromAirTricket)


            val toAirTricket = Airport()
            toAirTricket.airportName = searchRoundTripModel.toPort
            toAirTricket.iata = searchRoundTripModel.getToName()

            AppStorageBox.put(activity?.applicationContext!!, AppStorageBox.Key.TO_CACHE, toAirTricket)

            toAirport.iata = toAirTricket.iata
            fromAirport.iata = fromAirTricket.iata

        }


        val fromAirTricket = Airport()
        fromAirTricket.airportName = searchRoundTripModel.fromPort
        fromAirTricket.iata = searchRoundTripModel.getFromName()

        AppStorageBox.put(activity?.applicationContext!!, AppStorageBox.Key.FROM_CACHE, fromAirTricket)


        val toAirTricket = Airport()
        fromAirTricket.airportName = searchRoundTripModel.toPort
        fromAirTricket.iata = searchRoundTripModel.getToName()

        AppStorageBox.put(activity?.applicationContext!!, AppStorageBox.Key.TO_CACHE, fromAirTricket)


        val crachDepartureDate = AppStorageBox.get(activity?.applicationContext!!, AppStorageBox.Key.DEPART_DATE_FIRST_ROUND) as String?
        if (crachDepartureDate != null) {
            view.tvDepartDate.text = "" + crachDepartureDate
            view.tvDepartDate.setTextColor(Color.BLACK)

            val firstDate = AppStorageBox.get(activity?.applicationContext!!, AppStorageBox.Key.DEPART_DATE_FIRST_ROUND_Human) as String
            val firstDateAPI = AppStorageBox.get(activity?.applicationContext!!, AppStorageBox.Key.DEPART_DATE_FIRST_ROUND) as String
            humanReadAbleDateFirst = firstDateAPI
            view.tvDepartDate.text = "" + firstDate
            view.tvDepartDate.setTextColor(Color.BLACK)

        }

        val crachDepartureDateSecound = AppStorageBox.get(activity?.applicationContext!!, AppStorageBox.Key.DEPART_DATE_SECOUND_ROUND) as String?
        if (crachDepartureDateSecound != null) {
            val secoundDate = AppStorageBox.get(activity?.applicationContext!!, AppStorageBox.Key.DEPART_DATE_SECOUND_ROUND_hyuman) as String
            val secoundDateAPI = AppStorageBox.get(activity?.applicationContext!!, AppStorageBox.Key.DEPART_DATE_SECOUND_ROUND) as String
            humanReadAbleDateSecond = secoundDateAPI
            view.tvDepartDate2.text = "" + secoundDate
            view.tvDepartDate2.setTextColor(Color.BLACK)
        }

        val classModel = AppStorageBox.get(activity?.applicationContext!!, AppStorageBox.Key.CLASS_TYPE) as ClassModel?
        if (classModel == null) {

            mClassModel = ClassModel("Economy", "Economy", true)
        } else {
            mClassModel = classModel
            view.airTicketClass.setText(classModel.className)
        }


        val infanntPass = AppStorageBox.get(activity?.applicationContext!!, AppStorageBox.Key.INFANT_PSNGER) as Int?
        if (infanntPass != null) {
            onInfantPsngrTextChange("" + infanntPass)
        }


        val kidPsnGer = AppStorageBox.get(activity?.applicationContext!!, AppStorageBox.Key.KID_PSNGER) as Int?
        if (kidPsnGer != null) {
            onKidPsngrTextChange("" + kidPsnGer)
        }


        val adulPassger = AppStorageBox.get(activity?.applicationContext!!, AppStorageBox.Key.ADUL_PSNGER) as Int?
        if (adulPassger != null) {
            onAdultPsngrTextChange("" + adulPassger)
        }


        tvClass.setOnClickListener {


            handleClass()
        }

        llPassenger.setOnClickListener {

            handlePassengerClick()
        }


        // only run when reschedule

        if (AirTicketMainActivity.item.mSearchLog.size != 0) {
            isReSchuduler = true

            val mSearchLog = AirTicketMainActivity.item.mSearchLog.get(0)

            val originPort = mSearchLog.origin_port
            val destinationPort = mSearchLog.destination_port
            val cabinClass = mSearchLog.cabin_class
            val adultQty = mSearchLog.adult_qty
            val childQty = mSearchLog.child_qty
            val infantQty = mSearchLog.infant_qty


            tsFrom.setCurrentText(originPort)
            AirThicketRepository(AppController2.getContext()).getAirportBy(originPort).observeForever {
                tsFromPort.setCurrentText(getPortLevelText(it))
                tsFromPort.isEnabled = false
                tsFromPort.alpha = 0.5f
                tvFrom.isEnabled = false
                tvFrom.alpha = 0.5f

                searchRoundTripModel.setFromName(originPort)
                fromAirport.iata = originPort


            }

            tsTo.setCurrentText(destinationPort)
            AirThicketRepository(AppController2.getContext()).getAirportBy(destinationPort).observeForever {
                tsToPort.setCurrentText(getPortLevelText(it))
                tsToPort.isEnabled = false
                tsToPort.alpha = 0.5f

                layoutTo.isEnabled = false
                layoutTo.alpha = 0.5f

                searchRoundTripModel.setToName(destinationPort)
                toAirport.iata = destinationPort

            }

            view.tvDepartDate.setText(getString(R.string.date))
            humanReadAbleDateFirst = ""



            view.tvDepartDate2.setText("" + getString(R.string.date))
            humanReadAbleDateSecond = ""


            mClassModel = ClassModel(cabinClass, cabinClass, true)
            view.airTicketClass.setText(mClassModel.className)
            view.airTicketClass.isEnabled = false
            view.airTicketClass.alpha = 0.5f

            onAdultPsngrTextChange("" + adultQty)
            airTicketAdult.isEnabled = false
            airTicketAdult.alpha = 0.5f

            onKidPsngrTextChange("" + childQty)
            airTicketKid.isEnabled = false
            airTicketKid.alpha = 0.5f


            onInfantPsngrTextChange("" + infantQty)
            airTicketInfant.isEnabled = false
            airTicketInfant.alpha = 0.5f

            llPassenger.isEnabled = false
            llPassenger.alpha = 0.5f


            view.btn_search.setText("Reschedule search")

            view.tsRoundTripFromPort.visibility = View.INVISIBLE
            view.tsRoundTripToPort.visibility = View.INVISIBLE


        }

    }


    private fun handleClass() {
        val b = Bundle()
        b.putString("myClassName", airTicketClass.text.toString())

        val bottomSheet = ClassBottomSheetDialog()
        bottomSheet.setOnClassListener(object : ClassBottomSheetDialog.ClassBottomSheetListener {
            override fun onButtonClickListener(classModel: ClassModel) {

                mClassModel = classModel

                airTicketClass.setText(classModel.className)
            }

        })

        bottomSheet.arguments = b
        bottomSheet.show(requireFragmentManager(), "classBottomSheet")
    }


    private fun handlePassengerClick() {
        val b = Bundle()
        b.putString("myAdult", airTicketAdult.text.toString())
        b.putString("myKid", airTicketKid.text.toString())
        b.putString("myInfant", airTicketInfant.text.toString())

        val passengerBottomSheet = PassengerBottomSheetDialog()
        passengerBottomSheet.setmListenerPsngr(object : PassengerBottomSheetDialog.PsngrBottomSheetListener {
            override fun onInfantButtonClickListener(text: String) {
                onInfantPsngrTextChange(text)

            }

            override fun onKidButtonClickListener(text: String) {
                onKidPsngrTextChange(text)

            }

            override fun onAdultButtonClickListener(text: String) {
                onAdultPsngrTextChange(text)

            }

        })
        passengerBottomSheet.arguments = b
        passengerBottomSheet.show(requireFragmentManager(), "psngrBottomSheet")
    }

    fun onClassTextChange(text: String) {
        tvClass.setText(text)


    }

    fun onAdultPsngrTextChange(text: String) {
        airTicketAdult.setText(text)
        val toInt = text.toInt()

        AppStorageBox.put(activity?.applicationContext!!, AppStorageBox.Key.ADUL_PSNGER, toInt)

        if (toInt > 0) {
            airTicketAdult.setTextColor(getResources().getColor(R.color.black33333))
        } else {
            airTicketAdult.setTextColor(getResources().getColor(R.color.blackcccccc))
        }
    }

    fun onKidPsngrTextChange(text: String) {
        airTicketKid.setText(text)
        val toInt = text.toInt()

        AppStorageBox.put(activity?.applicationContext!!, AppStorageBox.Key.KID_PSNGER, toInt)

        if (toInt > 0) {
            airTicketKid.setTextColor(getResources().getColor(R.color.black33333))
        } else {
            airTicketKid.setTextColor(getResources().getColor(R.color.blackcccccc))
        }
    }

    fun onInfantPsngrTextChange(text: String) {
        airTicketInfant.setText(text)
        val toInt = text.toInt()
        AppStorageBox.put(activity?.applicationContext!!, AppStorageBox.Key.INFANT_PSNGER, toInt)

        if (toInt > 0) {
            airTicketInfant.setTextColor(getResources().getColor(R.color.black33333))
        } else {
            airTicketInfant.setTextColor(getResources().getColor(R.color.blackcccccc))
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            val get = AppStorageBox.get(activity?.applicationContext!!, AppStorageBox.Key.AIRPORT) as Airport

            when (requestCode) {
                REQ_CODE_FROM -> {

                    fromAirport = get

                    var cityOrStatusName = ""
                    if (!get.city.equals("")) {
                        cityOrStatusName = get.city + "/"
                    } else if (!get.state.equals("")) {
                        cityOrStatusName = get.state + "/"
                    }

                    searchRoundTripModel.setFromName(get.iata)
                    searchRoundTripModel.setFromPortName("" + FormatHelper.formatText(cityOrStatusName + get.airportName))

                    tsRoundTripFrom.setText(get.iata)
                    tsRoundTripFromPort.setText("" + FormatHelper.formatText(cityOrStatusName + get.airportName))
                    tvHitFrom.visibility = View.VISIBLE


                    fromAirport.airportName = "" + FormatHelper.formatText(cityOrStatusName + get.airportName)

                    AppStorageBox.put(activity?.applicationContext!!, AppStorageBox.Key.FROM_CACHE, fromAirport)

                }

                REQ_CODE_TO -> {

                    toAirport = get


                    var cityOrStatusName = ""
                    if (!get.city.equals("")) {
                        cityOrStatusName = get.city + "/"
                    } else if (!get.state.equals("")) {
                        cityOrStatusName = get.state + "/"
                    }

                    searchRoundTripModel.setToName(get.iata)
                    searchRoundTripModel.setToPortName("" + FormatHelper.formatText(cityOrStatusName + get.airportName))

                    tsRoundTripTo.setText(get.iata)
                    tsRoundTripToPort.setText("" + FormatHelper.formatText(cityOrStatusName + get.airportName))

                    tvHitTo.visibility = View.VISIBLE

                    toAirport.airportName = "" + FormatHelper.formatText(cityOrStatusName + get.airportName)

                    AppStorageBox.put(activity?.applicationContext!!, AppStorageBox.Key.TO_CACHE, toAirport)
                }


            }
        }
    }

    private fun handleSearchClick() {
        if (searchRoundTripModel.getFromName().equals(OneWayV2Fragment.KEY_FROM)) {
            Toast.makeText(activity?.applicationContext, "Please select from airport", Toast.LENGTH_LONG).show()

            return
        }

        if (searchRoundTripModel.getToName().equals(OneWayV2Fragment.KEY_To)) {
            Toast.makeText(activity?.applicationContext, "Please select arrival airport", Toast.LENGTH_LONG).show()
            return
        }

        if (humanReadAbleDateFirst.equals("")) {
            Toast.makeText(activity?.applicationContext, "Please select depart date", Toast.LENGTH_LONG).show()
            return
        }

        if (humanReadAbleDateSecond.equals("")) {
            Toast.makeText(activity?.applicationContext, "Please select return date", Toast.LENGTH_LONG).show()
            return
        }


        val list = mutableListOf<Segment>()
        val segment1 = Segment(mClassModel.apiClassName, humanReadAbleDateFirst, toAirport.iata, fromAirport.iata)
        val segment2 = Segment(mClassModel.apiClassName, humanReadAbleDateSecond, fromAirport.iata, toAirport.iata)

        list.add(segment1)
        list.add(segment2)

        val requestAirSearch = RequestAirSearch(airTicketAdult.text.toString().toLong(), airTicketKid.text.toString().toLong(), airTicketInfant.text.toString().toLong(), "Return", list)


        AppStorageBox.put(activity?.applicationContext!!, AppStorageBox.Key.REQUEST_AIR_SERACH, requestAirSearch)
        AppStorageBox.put(activity?.applicationContext!!, AppStorageBox.Key.REQUEST_API_reschedule, AirTicketMainActivity.item)

        val intent = Intent(activity?.applicationContext, FlightSearchViewActivity::class.java)
        intent.putExtra("isReSchuduler", isReSchuduler)
        startActivity(intent)

    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)

        try {
            if (isVisibleToUser) {
                inilitzationView(myView)
            } else {

            }
        } catch (e: Exception) {
            com.orhanobut.logger.Logger.v("", "")
        }

    }
}
