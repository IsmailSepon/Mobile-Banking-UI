package com.cloudwell.paywell.data.preferences

import android.content.Context

import com.orhanobut.hawk.Hawk

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-09-05.
 */
object AppStorageBox {

    enum class Key {
        /* Recommended naming convention:
         * ints, floats, doubles, longs:
         * SAMPLE_NUM or SAMPLE_COUNT or SAMPLE_INT, SAMPLE_LONG etc.
         *
         * boolean: IS_SAMPLE, HAS_SAMPLE, CONTAINS_SAMPLE
         *
         * String: SAMPLE_KEY, SAMPLE_STR or just SAMPLE
         */
        SERACH_ID, Request_ID, AUTHORIZATION_DATA, NOTIFICATION_DETAILS, FARE_DATA, AIRLINE_CODE, COUNTER_PASSENGER, ResposeAirPriceSearch, ShortDepartArriveTime, AIRTRICKET_EDIT_PASSENGER, SELETED_PASSENGER_IDS, AIRPORT, Airline_details, REQUEST_AIR_SERACH, orignAirportAnddestinationairportCode, totalJourney_time, humanReadAbleDate, AIR_PRE_BOOKKING, AIR_BOOKKING, AIRTICKET_BOOKING_RESPONSE, BOOKING_STATUS_ITEM, FROM_CACHE, TO_CACHE, DEPART_DATE, DEPART_DATE_API_formate, CLASS_TYPE, INFANT_PSNGER, KID_PSNGER, ADUL_PSNGER, FROM_CACHE_INDIA, TO_CACHE_INDIA, DEPART_DATE_INDIA, DEPART_DATE_API_formate_INDIA, CLASS_TYPE_INDIA, INFANT_PSNGER_INDIA, KID_PSNGER_INDIA, ADUL_PSNGER_INDIA, FROM_CACHE_ROUND, TO_CACHE_ROUND, CLASS_TYPE_ROUND, INFANT_PSNGER_ROUND, KID_PSNGER_ROUND, ADUL_PSNGER_ROUND, DEPART_DATE_FIRST_ROUND, DEPART_DATE_FIRST_ROUND_Human, DEPART_DATE_SECOUND_ROUND, DEPART_DATE_SECOUND_ROUND_hyuman, REQUEST_API_reschedule, SECURITY_TOKEN, ACCESS_KEY, TRANSPORT_ID, DEPARTURE_ID, BUS_LEAVING_FROM_CITY, LAUNCH_LEAVING_FROM_CITY, LAUNCH_GOING_TO_CITY, BUS_JOURNEY_DATE, BUS_RETURN_DATE, BUS_ID, BUS_GOING_TO_CITY, SELETED_BUS_INFO, BUS_VALIDATE_DATE, BOARDING_POGISTION, USER_USED_NOTIFICAITON_FLOW, RequestScheduledata, ExtraCharge_bus, IS_BUS_Ticket_USER_FLOW
    }
    fun put(context: Context, key: Key, value: Any?) {
        Hawk.init(context).build()
        Hawk.put(key.name, value)
        Hawk.destroy()
    }

    operator fun get(context: Context, key: Key): Any {
        Hawk.init(context).build()
        val data = Hawk.get<Any>(key.name)
        Hawk.destroy()
        return data
    }

    fun delete(context: Context, key: Key) {
        Hawk.init(context).build()
        Hawk.delete(key.name)
        Hawk.destroy()
    }

    fun check(context: Context, key: Key): Boolean {
        Hawk.init(context).build()
        return Hawk.contains(key.name)
    }


}

