package com.shift.persongeneratorxml.network

import com.shift.persongenxml.PersonModel
import retrofit2.http.GET

interface PersonApi {
    @GET("api")
    suspend fun getPerson(): PersonModel
}