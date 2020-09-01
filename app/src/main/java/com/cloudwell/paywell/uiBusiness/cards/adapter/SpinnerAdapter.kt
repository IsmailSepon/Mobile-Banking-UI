package com.cloudwell.paywell.uiBusiness.cards.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.cloudwell.paywell.R


/**
 * Created by Sepon on 8/9/2020.
 */
open class SpinnerAdapter(val context: Context, var dataSource: Array<String>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    var selectedItem = -1

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View

        val vh: ItemHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.common_spinner_item, parent, false)
            vh = ItemHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemHolder
        }
        vh.label.text = dataSource.get(position)
        return view
    }

    override fun getItem(position: Int): Any? {
        return dataSource[position];
    }

    override fun getCount(): Int {
        return dataSource.size;
    }

    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    private class ItemHolder(row: View?) {
        val label: TextView

        init {
            label = row?.findViewById(R.id.spinner_item) as TextView
        }
    }




}