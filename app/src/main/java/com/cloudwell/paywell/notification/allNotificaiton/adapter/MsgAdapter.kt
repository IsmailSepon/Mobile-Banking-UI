package com.cloudwell.paywell.services.activity.notification.allNotificaiton.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.cloudwell.paywell.R
import com.cloudwell.paywell.app.AppHandler
import com.cloudwell.paywell.appController.AppController2
import com.cloudwell.paywell.services.activity.notification.model.NotificationDetailMessage
import org.json.JSONObject

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 14/2/19.
 */
class MsgAdapter(private val mContext: Context, val t: List<NotificationDetailMessage>) : BaseAdapter() {

    var mAppHandler = AppHandler.getmInstance(mContext)

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return t.size
    }

    override fun getItem(position: Int): Any? {
        return t[position]
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val viewHolder: ViewHolder
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.dialog_notification, parent, false)
            viewHolder = ViewHolder()
            viewHolder.title = convertView!!.findViewById(R.id.title)
            viewHolder.date = convertView.findViewById(R.id.date)
            viewHolder.msg = convertView.findViewById(R.id.message)
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
        }

        val model = t[position]

        if (model.status.equals("Unread")) {
            viewHolder.title!!.setTextColor(Color.parseColor("#ff0000"))
        } else {
            viewHolder.title!!.setTextColor(Color.parseColor("#355689"))
        }

        viewHolder.title!!.text = model.messageSub
        viewHolder.date!!.text = model.addedDatetime
        viewHolder.msg!!.text = model.message
        if (mAppHandler!!.appLanguage.equals("en", ignoreCase = true)) {
            viewHolder.title!!.typeface = AppController2.getInstance().oxygenLightFont
            viewHolder.date!!.typeface = AppController2.getInstance().oxygenLightFont
            viewHolder.msg!!.typeface = AppController2.getInstance().oxygenLightFont
        } else {
            viewHolder.title!!.typeface = AppController2.getInstance().aponaLohitFont
            viewHolder.date!!.typeface = AppController2.getInstance().aponaLohitFont
            viewHolder.msg!!.typeface = AppController2.getInstance().aponaLohitFont
        }


        var testmessage = "" + model.message
        testmessage = testmessage.replace("\\", "")
        testmessage = testmessage.replace("\\\\".toRegex(), "")
        testmessage = testmessage.replace("\\\\\\\\".toRegex(), "")
        testmessage = testmessage.replace("\\\\\\\\\\\\".toRegex(), "")

        if (testmessage.contains("notification_action_type")) {
            // air ticket flow
            try {
                val jsonObject = JSONObject(testmessage)
                val notification_action_type = jsonObject.getString("notification_action_type")
                val original_message = jsonObject.getString("original_message")

                viewHolder.msg!!.text = original_message
            } catch (e: Exception) {

            }

        } else {

        }

        return convertView
    }


    private inner class ViewHolder {
        internal var title: TextView? = null
        internal var date: TextView? = null
        internal var msg: TextView? = null
    }
}