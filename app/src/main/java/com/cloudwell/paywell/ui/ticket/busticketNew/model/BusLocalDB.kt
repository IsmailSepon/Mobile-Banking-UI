package com.cloudwell.paywell.ui.ticket.busticketNew.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class BusLocalDB(
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "busID")
        var busID: String = "",

        @ColumnInfo(name = "bus_col_in_middle")
        @SerializedName("bus_col_in_middle")
        var busColInMiddle: String = "",

        @ColumnInfo(name = "bus_is_ac")
        @SerializedName("bus_is_ac")
        var busIsAc: String = "",

        @ColumnInfo(name = "columns_in_right")
        @SerializedName("columns_in_right")
        var columnsInRight: String = "",

        @ColumnInfo(name = "empty_rows_in_left")
        @SerializedName("empty_rows_in_left")
        var emptyRowsInLeft: String = "",

        @ColumnInfo(name = "empty_rows_in_middle")
        @SerializedName("empty_rows_in_middle")
        var emptyRowsInMiddle: String = "",


        @ColumnInfo(name = "empty_rows_in_right")
        @SerializedName("empty_rows_in_right")
        var emptyRowsInRight: String = "",

        @ColumnInfo(name = "name")
        @SerializedName("name")
        var name: String = "",

        @ColumnInfo(name = "seat_structure")
        @SerializedName("seat_structure")
        var seatStructure: String = "",


        @ColumnInfo(name = "structure_type")
        @SerializedName("structure_type")
        var structureType: String = "",

        @ColumnInfo(name = "total_columns")
        @SerializedName("total_columns")
        var totalColumns: String = "",

        @ColumnInfo(name = "total_rows")
        @SerializedName("total_rows")
        var totalRows: String = "",

        @ColumnInfo(name = "total_seats")
        @SerializedName("total_seats")
        var totalSeats: String = "")
