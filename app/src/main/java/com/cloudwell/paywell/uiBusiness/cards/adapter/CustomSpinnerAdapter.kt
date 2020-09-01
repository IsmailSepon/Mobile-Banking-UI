package com.cloudwell.paywell.uiBusiness.cards.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter


/**
 * Created by Sepon on 8/9/2020.
 */
open class CustomSpinnerAdapter<T>(context: Context, layoutId: Int, items: List<T>?) : ArrayAdapter<T>(context, layoutId,
    items!!
) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = super.getView(position, convertView, parent)
        view.setPadding(0,view.paddingTop,view.paddingRight,view.paddingBottom)
        return view
    }
}