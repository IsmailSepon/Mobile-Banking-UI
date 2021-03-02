package com.cloudwell.paywell.services.activity.notification.notificaitonFullView.viewModel

import androidx.lifecycle.MutableLiveData
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.base.newBase.SingleLiveEvent
import com.cloudwell.paywell.notification.model.ResposeReScheduleNotificationAccept
import com.cloudwell.paywell.services.activity.notification.BaseNotifcationViewModel
import com.cloudwell.paywell.services.activity.notification.model.NotificationDetailMessage
import com.cloudwell.paywell.services.activity.notification.notificaitonFullView.model.NotificationDetailMessageSync
import com.cloudwell.paywell.services.activity.notification.notificaitonFullView.view.NotificationFullViewStatus
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 10/2/19.
 */

class NotificationFullNotifcationViewModel : BaseNotifcationViewModel() {

    val mViewStatus = SingleLiveEvent<NotificationFullViewStatus>()
    val mListMutableLiveData = MutableLiveData<NotificationDetailMessage>()


    fun init(isNotificationFlow: Boolean, fcmNotificationDetailsJson: String) {
        if (isNotificationFlow) {
            handleNotificationClickFlow(fcmNotificationDetailsJson);
        } else {
            handleNormalFlow();
        }

    }

    private fun handleNormalFlow() {
        val stringData = mNotificationRepository.getNotificationDetailsData();
        val gson = Gson()
        val modelObject = gson.fromJson(stringData, NotificationDetailMessage::class.java)
        mListMutableLiveData.value = modelObject


    }

    private fun handleNotificationClickFlow(fcmNotificationDetailsJson: String) {

        val jsonObject = JSONObject(fcmNotificationDetailsJson);
        val message_id = jsonObject.getInt("message_id")
        val title = jsonObject.getString("title");
        val message = jsonObject.getString("message")
        val image = jsonObject.getString("image");
        val addedDatetime = jsonObject.getString("added_datetime")
        val expiryTime = jsonObject.getString("message_expiry_time")

        var balanceReturnData = ""
        if (jsonObject.has("balance_return_data")){
             balanceReturnData = jsonObject.getString("balance_return_data")
        }else {
            balanceReturnData = ""
        }


        val model = NotificationDetailMessage(addedDatetime, balanceReturnData, image, message, "" + message_id, title, "Read", "Notification", expiryTime);
        mListMutableLiveData.value = model


        doAsync {
            mNotificationRepository.saveNotificationData(model)
            val syncData = NotificationDetailMessageSync(model?.messageId!!)
            mNotificationRepository.addNotificationSyncData(syncData)

            uiThread {
                mViewStatus.value = NotificationFullViewStatus.START_NOTIFICATION_SERVICE
            }
        }
    }

    fun callReScheduleNotificationAccept(id: Int, accept_status: Int): MutableLiveData<ResposeReScheduleNotificationAccept> {


        return mNotificationRepository.callReScheduleNotificationAccept(id, accept_status)

    }


}