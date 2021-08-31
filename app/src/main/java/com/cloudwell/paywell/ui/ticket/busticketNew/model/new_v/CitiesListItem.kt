package com.cloudwell.paywell.ui.ticket.busticketNew.model.new_v
import com.google.gson.annotations.SerializedName

class CitiesListItem(

	@field:SerializedName("cities_id")
	val citiesId: String = "",

	@field:SerializedName("cities_name")
	val citiesName: String = ""
)