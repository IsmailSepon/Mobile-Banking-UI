package com.cloudwell.paywell.prepspversion.ui.ticket.busticketNew.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-06-09.
 */

@Entity
class TripScheduleInfo(

        @ColumnInfo(name = "from_location")
        var from: String = "",

        @ColumnInfo(name = "to_location")
        var To: String = "",

        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "schedule_Id")
        var schedule_Id: String = "",

        @ColumnInfo(name = "validity_date")
        var validity_date: String = "")

//{
//
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "TripScheduleInfo_Id")
//    var id: Long = 0
//}