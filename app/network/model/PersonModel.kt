package com.shift.persongenxml

import com.google.gson.annotations.SerializedName


data class PersonModel (

  @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf(),
  @SerializedName("info"    ) var info    : Info?              = Info()

)