package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.passenger


import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.busTransportList.BusHosttActivity
import com.cloudwell.paywell.services.activity.eticket.busticketNew.busTransportList.view.IbusTransportListView
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.busTransportList.viewModel.BusTransportViewModel
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.menu.BusTicketMenuActivity
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.model.BoothInfo
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.model.RequestBusSearch
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.model.ResSeatCheckBookAPI
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.model.TripScheduleInfoAndBusSchedule
import com.cloudwell.paywell.R
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.Passenger
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.model.new_v.RequestScheduledata
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.scheduledata.ScheduleDataItem
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.ticket_confirm.ResposeTicketConfirm
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.dialog.BusSucessMsgWithFinlishDialog
import com.cloudwell.paywell.base.newBase.BaseFragment
import com.cloudwell.paywell.constant.AllConstant
import com.cloudwell.paywell.utils.FragmentHelper
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_bus_booth_departure.*
import kotlinx.android.synthetic.main.activity_bus_booth_departure.view.*
import kotlinx.android.synthetic.main.ask_pin_layout.*
import java.text.DecimalFormat


class BusPassengerBoothDepartureFragment(var isRetrunTriple: Boolean) : BaseFragment(), IbusTransportListView {
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

    override fun showShowConfirmDialog(it: ResposeTicketConfirm) {
        val t = BusSucessMsgWithFinlishDialog(it, isRetrunTriple)
        t.show(requireFragmentManager(), "dialog")
        t.setOnClickListener(object : BusSucessMsgWithFinlishDialog.MyClickListener {
            override fun onClick() {
                val intent = Intent(activity, BusTicketMenuActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)

            }
        })

    }


    override fun showSeatCheckAndBookingRepose(it: ResSeatCheckBookAPI) {


    }

    override fun showErrorMessage(message: String) {


        val busHosttActivity1 = activity as BusHosttActivity
        busHosttActivity1.showBusTicketErrorDialog(message)

    }

    override fun showNoTripFoundUI() {


    }

    override fun showProgress() {
        com.orhanobut.logger.Logger.v("showProgress")
        val busHosttActivity1 = activity as BusHosttActivity
        busHosttActivity1.showProgressDialog()

    }

    override fun hiddenProgress() {
        com.orhanobut.logger.Logger.v("hiddenProgress")
        val busHosttActivity1 = activity as BusHosttActivity
        busHosttActivity1.dismissProgressDialog()

    }

    override fun showNoInternetConnectionFound() {


    }

    private lateinit var busListAdapter: Any
    private val allBoothInfo = mutableListOf<BoothInfo>()
    private val allBoothNameInfo = mutableListOf<String>()


    private lateinit var boothList: Spinner

    lateinit var viewMode: BusTransportViewModel
    internal lateinit var model: TripScheduleInfoAndBusSchedule
    internal lateinit var requestBusSearch: RequestBusSearch
    internal var totalAPIValuePrices: String = ""
    var seatLevel = ""
    var seatId = ""
    var password = ""

    lateinit var busHosttActivity: BusHosttActivity


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_bus_booth_departure, container, false)

        view.btn_search.setOnClickListener {
            handleBookingContinueBooking()
        }



        view.busdeparture_back.setOnClickListener(View.OnClickListener {
            FragmentHelper.removeFragment(requireActivity().supportFragmentManager)
        })

        return view


    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.v("onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Logger.v("onDestroyView")

    }

    override fun onStop() {
        super.onStop()
        Logger.v("onStop")
    }

    override fun onResume() {
        super.onResume()
        Logger.v("onResume")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Logger.v("onAttach")
        val busHosttActivity = activity as BusHosttActivity
        busHosttActivity.setToolbar(getString(R.string.title), resources.getColor(R.color.bus_ticket_toolbar_title_text_color))

    }

    override fun onAttachFragment(childFragment: Fragment) {
        super.onAttachFragment(childFragment!!)
        Logger.v("onAttachFragment")

    }

    override fun onDetach() {
        super.onDetach()
        Logger.v("onDetach")
        viewMode.view = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Logger.v("onActivityCreated")
        initViewModel()
        busHosttActivity = activity as BusHosttActivity

        if (!isRetrunTriple) {
            view?.ConstLayoutRetrun?.visibility = View.GONE
        } else {

            val retrunScheduleDataItem = viewMode.retrunScheduleDataItem.value
            val retrunBordingPoint = viewMode.retrunBordingPoint.value
            val sbr = viewMode.seatBlockRequestPojo.value
            val optionInfo = sbr?.optionInfo?.get(1)

            view?.tvAddressRetrun?.text = "${sbr?.toCity}-${sbr?.fromCity}"
            view?.tvBusNameRetrun?.text = retrunScheduleDataItem?.companyName + " " + retrunScheduleDataItem?.busServiceType
            view?.tvSeatNumberRetrun?.text = "" + optionInfo?.seatLevel
            view?.tvboadingPointRount?.text = "Boarding point at " + retrunBordingPoint?.counterName + " " + retrunBordingPoint?.scheduleTime
        }

        val singleScheduleDataItem = viewMode.singleScheduleDataItem.value
        val singleBordingPoint = viewMode.singleBordingPoint.value
        val sbr = viewMode.seatBlockRequestPojo.value
        val get = sbr?.optionInfo?.get(0)

        view?.tvAddressOneWay?.text = "${sbr?.fromCity}-${sbr?.toCity}"
        view?.tvBusNameOneWay?.text = singleScheduleDataItem?.companyName + " " + singleScheduleDataItem?.busServiceType
        view?.tvSeatNumberOneWay?.text = "" + get?.seatLevel
        view?.tvBoardingPoint?.text = "Boarding point at " + singleBordingPoint?.counterName + " " + singleBordingPoint?.scheduleTime


        val totalPrices = (viewMode.singleTotalAmount.value
                ?: 0.0) + (viewMode.retrunTotalAmount.value ?: 0.0)
        view?.tvTotalAAmont?.text = getString(R.string.totat_amont_bus) + DecimalFormat("#").format(totalPrices) + " " + getString(R.string.include_prices);

    }

    private fun initViewModel() {
        viewMode = ViewModelProviders.of(requireActivity()).get(BusTransportViewModel::class.java)
        viewMode.setIbusTransportListView(this)


    }

    private fun handleBookingContinueBooking() {
        val fullName = fullNameTV.text.toString().trim()
        val mobileNumber = mobileNumberTV.text.toString().trim()
        val age = ageTV.text.toString().trim()
        val address = etAddress.text.toString().trim()
        val email = etEmail.text.toString().trim()

        if (fullName.equals("")) {
            textInputLayoutFirstName.error = getString(R.string.invalid_full_name)
            return
        } else {
            textInputLayoutFirstName.error = null
        }
        if (mobileNumber.equals("")) {
            textInputLayoutmobileNumber.error = getString(R.string.Invalid_mobile_number)
            return
        } else {
            textInputLayoutmobileNumber.error = null
        }

        if (age.equals("")) {
            textInputLayoutAge.error = getString(R.string.invalid_age)
            return
        } else {
            textInputLayoutAge.error = null
        }

        if (address.equals("")) {
            textInputLayoutAddress.error = getString(R.string.invalid_address)
            return
        } else {
            textInputLayoutAddress.error = null
        }


        if (email.equals("")) {
            textInputLayoutmobilEmail.error = getString(R.string.invalid_email)
            return
        } else {
            if (email.matches(AllConstant.emailPattern.toRegex()) && email.length > 0) {
                textInputLayoutmobilEmail.error = ""
            } else {
                textInputLayoutmobilEmail.error = getString(R.string.invalid_email)
                return
            }
        }

        val id = radioGroup.checkedRadioButtonId
        val gender = when (id) {
            R.id.maleRB -> "male"
            R.id.femaleRB -> "female"
            else -> "male"
        }
        val passenger = Passenger()
        passenger.passengerAddress = address
        passenger.passengerAge = age
        passenger.passengerEmail = email
        passenger.passengerGender = gender
        passenger.passengerMobile = mobileNumber
        passenger.passengerName = fullName


        askpin(busHosttActivity.isInternetConnection, passenger)


    }

    private fun askpin(internetConnection: Boolean, passenger: Passenger){

        val dialog : Dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.ask_pin_layout)

        val pin_et : EditText = dialog.pin_et
        val pin_ok : TextView = dialog.ok_txt

        pin_ok.setOnClickListener(View.OnClickListener {

            if (pin_et.text.toString().length != 0) {

                val PIN_NO = pin_et.text.toString()
                if (internetConnection) {
                    viewMode.callSeatBookAndConfirmAPI(PIN_NO, passenger)
                    dialog.dismiss()
                } else {
                    busHosttActivity.showBusTicketErrorDialog(getString(R.string.connection_error_msg))
                    dialog.dismiss()
                }
            } else {
                busHosttActivity.showBusTicketErrorDialog(getString(R.string.pin_no_error_msg))
                dialog.dismiss()
            }


        })




        dialog.show()

    }

    private fun askForPin(internetConnection: Boolean, passenger: Passenger) {
        val builder = AlertDialog.Builder(requireActivity())

        builder.setTitle(R.string.pin_no_title_msg)

        val pinNoET = EditText(requireContext())
        val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        pinNoET.gravity = Gravity.CENTER_HORIZONTAL
        pinNoET.layoutParams = lp
        pinNoET.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_TEXT_VARIATION_PASSWORD
        pinNoET.transformationMethod = PasswordTransformationMethod.getInstance()
        builder.setView(pinNoET)

        builder.setPositiveButton(R.string.okay_btn) { dialogInterface, id ->
            val inMethMan = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inMethMan.hideSoftInputFromWindow(pinNoET.windowToken, 0)

            if (pinNoET.text.toString().length != 0) {
                dialogInterface.dismiss()
                val PIN_NO = pinNoET.text.toString()
                if (internetConnection) {
                    viewMode.callSeatBookAndConfirmAPI(PIN_NO, passenger)
                } else {
                    busHosttActivity.showBusTicketErrorDialog(getString(R.string.connection_error_msg))
                }
            } else {
                busHosttActivity.showBusTicketErrorDialog(getString(R.string.pin_no_error_msg))

            }
        }
        builder.setNegativeButton(R.string.cancel) { dialogInterface, i -> dialogInterface.dismiss() }
        val alert = builder.create()
        alert.show()
    }


//    override fun onBackPressed() {
//        super.onBackPressed()
//
//        val busHosttActivity = activity as BusHosttActivity
//        if (!isRetrunTriple) {
//            busHosttActivity.setToolbar("Departure Ticket", resources.getColor(R.color.bus_ticket_toolbar_title_text_color))
//        } else {
//            busHosttActivity.setToolbar("Return Ticket", resources.getColor(R.color.bus_ticket_toolbar_title_text_color))
//        }
//
//    }
}
