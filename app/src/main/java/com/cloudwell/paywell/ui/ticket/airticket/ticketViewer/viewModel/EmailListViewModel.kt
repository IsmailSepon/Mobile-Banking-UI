package com.cloudwell.paywell.ui.ticket.airticket.ticketViewer.viewModel

import com.cloudwell.paywell.ui.ticket.airticket.base.newBase.BaseViewState
import com.cloudwell.paywell.ui.ticket.airticket.AirTicketBaseViewMode
import com.cloudwell.paywell.ui.ticket.airticket.base.newBase.SingleLiveEvent
import com.cloudwell.paywell.ui.ticket.airticket.ticketViewer.model.EmailListViewStatus
import com.cloudwell.paywell.ui.ticket.airticket.ticketViewer.model.ResInvoideEmailAPI

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 4/3/19.
 */
class EmailListViewModel : AirTicketBaseViewMode() {


    val mViewStatus = SingleLiveEvent<EmailListViewStatus>()


    fun callSendInvoiceAPI(bookingId: String, emailString: String, key:String, internetConnection1: Boolean) {

        if (!internetConnection1) {
            baseViewStatus.value = BaseViewState(isNoInternectConnectionFoud = true)
        } else {
            mViewStatus.value = EmailListViewStatus(noSerachFoundMessage = "", isShowProcessIndicatior = true, successMessage = "")
            mAirTicketRepository.callInvoiceAPI(bookingId, emailString, key).observeForever {
                mViewStatus.value = EmailListViewStatus(noSerachFoundMessage = "", isShowProcessIndicatior = false, successMessage = "")

                val okNetworkAndStatusCode = isOkNetworkAndStatusCode(it)

                if (okNetworkAndStatusCode) {
                    mViewStatus.value = EmailListViewStatus(noSerachFoundMessage = "", isShowProcessIndicatior = false, successMessage = it!!.message)
                } else {
                    mViewStatus.value = EmailListViewStatus(noSerachFoundMessage = it!!.message, isShowProcessIndicatior = false, successMessage = "")
                }

            }

        }

    }

    fun isOkNetworkAndStatusCode(it: ResInvoideEmailAPI?): Boolean {
        it?.let {
            if (it.throwable != null) {
                baseViewStatus.value = it.throwable!!.message.let { it1 ->
                    BaseViewState(errorMessage = it1.toString())
                }
                mViewStatus.value = EmailListViewStatus(noSerachFoundMessage = "Please try again", isShowProcessIndicatior = false, successMessage = "");

                return false
            } else if (it.status == 200) {
                return true
            }

        }
        return false
    }
}