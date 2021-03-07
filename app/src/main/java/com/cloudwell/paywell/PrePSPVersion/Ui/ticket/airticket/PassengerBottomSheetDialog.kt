package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cloudwell.paywell.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_passenger_bottom_sheet_dialog.*
import kotlinx.android.synthetic.main.fragment_passenger_bottom_sheet_dialog.view.*


class PassengerBottomSheetDialog : BottomSheetDialogFragment(), View.OnClickListener {


    lateinit var mListenerPsngr: PsngrBottomSheetListener
    lateinit var userType: ArrayList<UserTypeModel>
    var adult : Int = 1
    var child : Int = 1
    var infant : Int = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { val view = inflater.inflate( R.layout.fragment_passenger_bottom_sheet_dialog, container, false)
        getDialog()?.setCanceledOnTouchOutside(true)


        view.add_adult.setOnClickListener(this)
        view.miniz_adult.setOnClickListener(this)
        view.add_child.setOnClickListener(this)
        view.remove_child.setOnClickListener(this)
        view.add_Infant.setOnClickListener(this)
        view.remove_Infant.setOnClickListener(this)

        return view
    }

    fun setmListenerPsngr(psngrBottomSheetListener: PsngrBottomSheetListener) {
        mListenerPsngr = psngrBottomSheetListener
    }

    interface PsngrBottomSheetListener {
        fun onAdultButtonClickListener(text: String)

        fun onKidButtonClickListener(text: String)

        fun onInfantButtonClickListener(text: String)
    }



    override fun onDestroy() {



        mListenerPsngr.onAdultButtonClickListener("" + adult)
        mListenerPsngr.onKidButtonClickListener("" + child)
        mListenerPsngr.onInfantButtonClickListener("" + infant)

        super.onDestroy()
    }

    override fun onClick(v: View?) {

        when (v!!.id) {
            R.id.add_adult ->
                add_adult()


            R.id.miniz_adult ->
               miniz_adult()

            R.id.add_child ->
                add_child()

            R.id.remove_child ->
                miniz_child()

            R.id.add_Infant ->
                add_infant()

            R.id.remove_Infant ->
               miniz_infant()
        }



    }

    fun add_adult(){
        adult += 1
        adult_passenger.text = adult.toString()
        miniz_adult.visibility = View.VISIBLE
    }

    fun miniz_adult(){
        adult -= 1
        if(adult == 0){
            miniz_adult.visibility = View.INVISIBLE
        }
        adult_passenger.text = adult.toString()
    }
//---------------------------------------------------------------
    fun add_child(){
        child += 1
        child_passenger.text = child.toString()
        remove_child.visibility = View.VISIBLE
    }

    fun miniz_child(){
        child -= 1
        if(child == 0){
            remove_child.visibility = View.INVISIBLE
        }
        child_passenger.text = child.toString()
    }
//------------------------------------------------------------
    fun add_infant(){
        infant += 1
        Infant_passenger.text = infant.toString()
        remove_Infant.visibility = View.VISIBLE
    }

    fun miniz_infant(){
        infant -= 1
        if(infant == 0){
            remove_Infant.visibility = View.INVISIBLE
        }
        Infant_passenger.text = infant.toString()
    }






}
