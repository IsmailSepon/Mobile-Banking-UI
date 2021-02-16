package com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket

import com.cloudwell.paywell.appController.AppController
import com.cloudwell.paywell.appController.AppController2
import com.cloudwell.paywell.base.BaseViewModel
import com.cloudwell.paywell.services.activity.eticket.airticket.AirThicketRepository

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 19/2/19.
 */
open class AirTicketBaseViewMode : BaseViewModel() {
    var mAirTicketRepository: AirThicketRepository

    init {
//       mAirTicketRepository = AirThicketRepository(AppController2.getContext())
        mAirTicketRepository = AirThicketRepository(AppController2.getContext())
    }


}
