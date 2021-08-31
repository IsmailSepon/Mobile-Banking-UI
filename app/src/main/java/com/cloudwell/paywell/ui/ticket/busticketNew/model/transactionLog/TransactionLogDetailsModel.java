package com.cloudwell.paywell.services.activity.eticket.busticketNew.model.transactionLog;

import com.cloudwell.paywell.ui.ticket.busticketNew.model.transactionLog.Datum;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class TransactionLogDetailsModel {


    @SerializedName("message")
    private String message;
    @SerializedName("status_code")
    private Long status;
    @SerializedName("data")
    private List<Datum> data;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

}
