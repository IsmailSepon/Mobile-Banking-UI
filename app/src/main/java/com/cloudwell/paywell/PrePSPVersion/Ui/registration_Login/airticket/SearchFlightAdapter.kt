package com.cloudwell.paywell.services.activity.eticket.airticket

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.multiCity.MultiCityFragment
import com.cloudwell.paywell.R
import com.cloudwell.paywell.appController.AppController2
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.booking.model.Datum
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.fragment.IndianWayFragment
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.fragment.OneWayV2Fragment
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.fragment.RoundTripFragment

class SearchFlightAdapter(fm: FragmentManager?, var item: Datum = Datum()) : FragmentPagerAdapter(fm!!) {
    override fun getItem(position: Int): Fragment {

        if (item.mSearchLog.size == 0) {

            when (position) {
                0
                -> return OneWayV2Fragment()
                1
                -> return RoundTripFragment()
                2
                -> return MultiCityFragment()
                3
                -> return IndianWayFragment()
                else -> return OneWayV2Fragment()
            }

        } else {
            if (item.journeyType.equals("Oneway")) {
                return OneWayV2Fragment()

            } else if (item.journeyType.equals("Return")) {
                return RoundTripFragment()

            } else if (item.journeyType.equals("MultiStop")) {

                return MultiCityFragment()
            }

        }
        return OneWayV2Fragment()
    }

    override fun getCount(): Int {

        if (item.mSearchLog.size == 0) {
            return 4
        } else {
            return 1
        }


    }

    override fun getPageTitle(position: Int): CharSequence? {
        if (item.mSearchLog.size == 0) {
            when (position) {
                0 -> {
                    return AppController2.getContext().getString(R.string.one_way_menu_title)
                }
                1 -> {
                    return AppController2.getContext().getString(R.string.round_trip_menu_title)
                }
                2 -> {
                    return AppController2.getContext().getString(R.string.multi_city_menu_title)
                }
                3 -> {
                    return AppController2.getContext().getString(R.string.indian_menu_title)
                }
                else -> {
                    return ""
                }
            }
        } else {
            if (item.journeyType.equals("Oneway")) {
                return AppController2.getContext().getString(R.string.one_way_menu_title)

            } else if (item.journeyType.equals("Return")) {
                return AppController2.getContext().getString(R.string.round_trip_menu_title)

            } else if (item.journeyType.equals("MultiStop")) {

                return AppController2.getContext().getString(R.string.multi_city_menu_title)
            }

        }

        return ""
    }
}