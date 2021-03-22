package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.busTransportList.fragment

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.busTransportList.BusHosttActivity
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.busTransportList.adapter.BusTripListAdapter
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.busTransportList.adapter.OnClickListener
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.busTransportList.model.SearchFilter
import com.cloudwell.paywell.services.activity.eticket.busticketNew.busTransportList.view.IbusTransportListView
import com.cloudwell.paywell.services.activity.eticket.busticketNew.busTransportList.viewModel.BusTransportViewModel
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.model.ResSeatCheckBookAPI
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.model.ResSeatInfo
import com.cloudwell.paywell.R
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.model.new_v.RequestScheduledata
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.scheduledata.ScheduleDataItem
import com.cloudwell.paywell.services.activity.eticket.busticketNew.model.new_v.ticket_confirm.ResposeTicketConfirm
import com.cloudwell.paywell.ui.BaseActivity
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.activity_bus_city_search_new.*
import kotlinx.android.synthetic.main.bus_advance_filter.view.*
import kotlinx.android.synthetic.main.fragment_transport_list.*
import kotlinx.android.synthetic.main.fragment_transport_list.bus_control
import kotlinx.android.synthetic.main.fragment_transport_list.view.*
import kotlinx.android.synthetic.main.layout_filter.view.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TransportListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */
class TransportListFragment(val requestScheduledata: RequestScheduledata, val isRetrunTriple: Boolean) : Fragment(), IbusTransportListView {
    private lateinit var adapter: BusTripListAdapter
    private lateinit var viewMode: BusTransportViewModel
    private var listener: OnFragmentInteractionListener? = null
    lateinit var layoutManager: CustomGridLayoutManager
    var popup : PopupWindow? = null
    var p: Point? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_transport_list, container, false)

        initilization(view)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewModel()
    }

    override fun onResume() {
        super.onResume()

        val busHosttActivity = activity as BusHosttActivity
        if (!isRetrunTriple) {
            busHosttActivity.setToolbar(getString(R.string.departure_ticket), resources.getColor(R.color.bus_ticket_toolbar_title_text_color))
        } else {
            busHosttActivity.setToolbar(getString(R.string.round_bus), resources.getColor(R.color.bus_ticket_toolbar_title_text_color))
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroyView() {
        Logger.v("onDestroyView");
        super.onDestroyView()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden) {
            //do when hidden
        } else {
            //do when show
        }
    }

    private fun initilization(view: View) {
//        view.ivFilterUpDown.setImageResource(0)
//        view.ivFilterUpDown.setImageResource(R.drawable.arrow_down)

        view.search_bus_back.setOnClickListener(View.OnClickListener {

            requireActivity().finish()
        })

        view.llCustomFilterHeader.setOnClickListener(View.OnClickListener {

            hiddenAndShowFilter(view)

        })


        view.bus_control.setOnClickListener(View.OnClickListener {



        })


//        view.llCustomFilterHeader2.setOnClickListener {
//            hiddenAndShowFilter(view)
//        }

        view.ivUp.setOnClickListener {
            hiddenAndShowFilter(view)
        }

        view.viewSearch.setOnClickListener {
            hiddenAndShowFilter(view)

            val m = SearchFilter()

            val checkedRadioButtonId = view.radioGroupJounyTime.checkedRadioButtonId
            val departingTime = when (checkedRadioButtonId) {
                R.id.radioJourneyTimeAll -> "Any"
                R.id.radioJourneyTimeAllMorning -> "Morning"
                R.id.radioJourneyTimeAllEvening -> "Evening"
              //  R.id.radioJourneyTimeAfterNoon -> "AfterNoon"
                R.id.radioJourneyTimeAllNight -> "Night"

                else -> "Any"
            }
            m.departingTime = departingTime


            val id = view.radioGroupJounryType.checkedRadioButtonId
            val coachType = when (id) {
                R.id.radioBtmAll -> "All"
                R.id.radioBtmAC -> "Ac"
                R.id.radioBtmNonAC -> "NonAc"
                else -> "All"
            }
            m.coachType = coachType


            val radioGroupSortByid = view.radioGroupSortBy.checkedRadioButtonId
            val sortBy = when (radioGroupSortByid) {
                R.id.radioLowPrice -> "Low Price"
                R.id.radioHighPrice -> "HighPrice"
                else -> "Low Price"
            }
            m.sortBy = sortBy
            viewMode.onSort(m, isRetrunTriple)


        }
//

    }

    private fun hiddenAndShowFilter(view: View) {

        var size = 0
        if (!isRetrunTriple) {
            size = viewMode.singleTripTranportListMutableLiveData.value?.size ?: 0
        } else {
            size = viewMode.returnTripTransportListMutableLiveData.value?.size ?: 0
        }
        if (size > 0) {

            if (view.llAdvaceSerach.visibility == View.VISIBLE) {
                view.llAdvaceSerach.visibility = View.GONE
                layoutManager.isScrollEnabled = true
                view.ivFilterUpDown.setImageResource(0)
                view.ivFilterUpDown.setImageResource(R.drawable.arrow_down)
            } else {
                view.llAdvaceSerach.visibility = View.VISIBLE
                layoutManager.isScrollEnabled = false
                view.ivFilterUpDown.setImageResource(0)
                view.ivFilterUpDown.setImageResource(R.drawable.arrow_up)
            }
        }



//        val view: View = view.llCustomFilterHeader2//window.decorView.rootView
//        val location = IntArray(2)
//        view.getLocationOnScreen(location)
//
//        p = Point()
//        p!!.x = location[0]
//        p!!.y = location[1]
//
//        if (p != null) showPopup(requireActivity(), p!!, view)


    }




    // The method that displays the popup.
    private fun showPopup(context: Activity, p: Point, view: View) {


        val popupWidth = LinearLayout.LayoutParams.MATCH_PARENT
        val popupHeight = LinearLayout.LayoutParams.WRAP_CONTENT
        val inflater = context.getSystemService(BaseActivity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = inflater.inflate(R.layout.layout_filter, null)


        // Creating the PopupWindow
        popup = PopupWindow(context)
        popup!!.contentView = layout
        popup!!.width = popupWidth
        popup!!.height = popupHeight
        popup!!.isFocusable = true
        popup!!.isOutsideTouchable = true



        val OFFSET_X = 30
        val OFFSET_Y = 30


        //Clear the default translucent background
        popup!!.setBackgroundDrawable(null)
        popup!!.showAtLocation(layout, Gravity.NO_GRAVITY, p.x + OFFSET_X, p.y + OFFSET_Y)

        val layoutParams  = layout.layoutParams as FrameLayout.LayoutParams
        layoutParams.setMargins(30, -150, 30, 0)
        layout.layoutParams = layoutParams

        var size = 0
        if (!isRetrunTriple) {
            size = viewMode.singleTripTranportListMutableLiveData.value?.size ?: 0
        } else {
            size = viewMode.returnTripTransportListMutableLiveData.value?.size ?: 0
        }
        if (size > 0) {

            if (layout.llAdvaceSerach.visibility == View.VISIBLE) {
                layout.llAdvaceSerach.visibility = View.GONE
                layoutManager.isScrollEnabled = true
//                layout.ivFilterUpDown.setImageResource(0)
//                layout.ivFilterUpDown.setImageResource(R.drawable.arrow_down)
            } else {
                layout.llAdvaceSerach.visibility = View.VISIBLE
                layoutManager.isScrollEnabled = false
//                layout.ivFilterUpDown.setImageResource(0)
//                layout.ivFilterUpDown.setImageResource(R.drawable.arrow_up)
            }
        }


        layout.viewSearch.setOnClickListener {
            hiddenAndShowFilter(view)

            val m = SearchFilter()

            val checkedRadioButtonId = view.radioGroupJounyTime.checkedRadioButtonId
            val departingTime = when (checkedRadioButtonId) {
                R.id.radioJourneyTimeAll -> "Any"
                R.id.radioJourneyTimeAllMorning -> "Morning"
                R.id.radioJourneyTimeAllEvening -> "Evening"
               // R.id.radioJourneyTimeAfterNoon -> "AfterNoon"
                R.id.radioJourneyTimeAllNight -> "Night"

                else -> "Any"
            }
            m.departingTime = departingTime


            val id = view.radioGroupJounryType.checkedRadioButtonId
            val coachType = when (id) {
                R.id.radioBtmAll -> "All"
                R.id.radioBtmAC -> "Ac"
                R.id.radioBtmNonAC -> "NonAc"
                else -> "All"
            }
            m.coachType = coachType


            val radioGroupSortByid = view.radioGroupSortBy.checkedRadioButtonId
            val sortBy = when (radioGroupSortByid) {
                R.id.radioLowPrice -> "Low Price"
                R.id.radioHighPrice -> "HighPrice"
                else -> "Low Price"
            }
            m.sortBy = sortBy
            viewMode.onSort(m, isRetrunTriple)


        }

    }


    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }


    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
        fun onItemCLick(position: Int, retrunTriple: Boolean)
        fun showErrorMessageAndFinsehdFragment(message: String)
    }

    override fun showNoTripFoundUI() {
        shimmer_recycler_view.visibility = View.INVISIBLE
        layoutNoSerachFound.visibility = View.VISIBLE
    }

    override fun showErrorMessage(message: String) {
        listener?.showErrorMessageAndFinsehdFragment(message)
    }

    override fun showSeatCheckAndBookingRepose(it: ResSeatCheckBookAPI) {
    }

    override fun showShowConfirmDialog(it: ResposeTicketConfirm) {
    }

    override fun setBoardingPoint(allBoothNameInfo: MutableSet<String>) {
    }

    override fun saveRequestScheduledata(p: RequestScheduledata) {
    }

    override fun saveExtraCharge(double: Double) {

    }

    override fun showFilterList(filterTypeDepartingTime: List<ScheduleDataItem>) {
        setAdapter(filterTypeDepartingTime)

    }

    override fun updateListData(position: Int, itemCount: Int) {
        adapter.notifyItemChanged(position)
        adapter.notifyItemRangeChanged(position, itemCount)

    }

    fun setAdapter(data: List<ScheduleDataItem>) {
        layoutNoSerachFound.visibility = View.INVISIBLE

        shimmer_recycler_view.visibility = View.VISIBLE
        layoutManager = CustomGridLayoutManager(activity, true)
        shimmer_recycler_view.layoutManager = layoutManager
        shimmer_recycler_view.adapter = data.let { it1 ->

            adapter = BusTripListAdapter(data, requireContext(), viewMode.extraCharge.value
                    ?: 0.0, isRetrunTriple,
                    object : OnClickListener {
                        override fun onUpdateData(position: Int, resSeatInfo: ResSeatInfo) {


                        }

                        override fun needUpdateData(position: Int, model: ScheduleDataItem) {
                            viewMode.needToUpdateData(position, model, isRetrunTriple)
                        }

                        override fun onClick(position: Int) {
                    // do whatever
                    listener?.onItemCLick(position, isRetrunTriple)

                }
            })
            adapter
        }

    }


    override fun showProgress() {
        shimmer_recycler_view?.showShimmerAdapter()

    }

    override fun hiddenProgress() {
        shimmer_recycler_view?.hideShimmerAdapter()
    }

    override fun showNoInternetConnectionFound() {

    }


    private fun initViewModel() {

        viewMode = ViewModelProviders.of(requireActivity()).get(BusTransportViewModel::class.java)
        viewMode.setIbusTransportListView(this)
        viewMode.init(requestScheduledata, isRetrunTriple)


    }

    class CustomGridLayoutManager(context: Context?, var isScrollEnabled: Boolean) : LinearLayoutManager(context) {

        override fun canScrollVertically(): Boolean {
            //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
            return isScrollEnabled && super.canScrollVertically()
        }
    }


}
