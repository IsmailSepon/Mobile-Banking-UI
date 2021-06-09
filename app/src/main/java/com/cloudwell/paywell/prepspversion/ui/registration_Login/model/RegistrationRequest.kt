package com.cloudwell.paywell.prepspversion.ui.registration_Login.model

data class RegistrationRequest(
    var deviceProfile: DeviceProfile? = null,
    var user: User? = null
)

data class DeviceProfile(
    var appVersionNo: String? = null,
    var model: String? = null,
    var refId: String? = null,
    var osName: String? = null,
    var apiLevel: String? = null,
    var deviceName: String? = null,
    var androidId: String? = null
)

data class User(
    var password: String? = null,
    var username: String? = null
)

