package com.cloudwell.paywell.consumer.base.customView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.cloudwell.paywell.consumer.R
import kotlinx.android.synthetic.main.status_fragment.view.*

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-09-15.
 */
class BusTicketStatusFragment : DialogFragment() {

    companion object {
        lateinit var message: String
    }

    private var onClicklistener: OnClickListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, 0);

    }


    fun setOnClickListener(onClicklistener: OnClickListener) {
        this.onClicklistener = onClicklistener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.status_fragment, container, false)
        v.tvYourSeats.text = message

        v.tvOk.setOnClickListener {
            dismiss()
            onClicklistener?.onClick()
        }

        return v
    }

    private fun setMargins(view: View, left: Int, top: Int, right: Int, bottom: Int) {
        if (view.layoutParams is ViewGroup.MarginLayoutParams) {
            val p = view.layoutParams as ViewGroup.MarginLayoutParams
            p.setMargins(left, top, right, bottom)
            view.requestLayout()
        }
    }


}

public interface OnClickListener {
    fun onClick()
}