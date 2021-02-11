package com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket

class UserTypeModel {

    var userType: String
    var psngrCount: Int

    constructor(userType: String, psngrCount: Int) {
        this.userType = userType
        this.psngrCount = psngrCount
    }

    fun getSelectedUserType(): String? {
        return userType
    }

    fun setSelectedUserType(type: String) {
        userType = type
    }

    fun getSelectedPsngrCount(): Int {
        return psngrCount
    }

    fun setSelectedPsngrCount(count: Int) {
        psngrCount = count
    }
}