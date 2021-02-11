package com.cloudwell.paywell.services.activity.notification

import com.cloudwell.paywell.appController.AppController2
import com.cloudwell.paywell.base.BaseViewModel
import com.cloudwell.paywell.notification.NotificationRepogitory

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 7/2/19.
 */
open class BaseNotifcationViewModel : BaseViewModel() {
    val mNotificationRepository: NotificationRepogitory

    init {
        mNotificationRepository = NotificationRepogitory(AppController2.getContext())
    }


}
