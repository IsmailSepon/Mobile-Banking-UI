package com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.flightDetails1.model;

import com.google.gson.annotations.SerializedName;


public class RequestAirPriceSearch {

    @SerializedName("ResultID")
    private String mResultID;
    @SerializedName("SearchId")
    private String mSearchId;

    public String getResultID() {
        return mResultID;
    }

    public void setResultID(String resultID) {
        mResultID = resultID;
    }

    public String getSearchId() {
        return mSearchId;
    }

    public void setSearchId(String searchId) {
        mSearchId = searchId;
    }

}
