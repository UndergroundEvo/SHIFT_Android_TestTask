package com.shift.persongenxml.network.retrofit

import retrofit2.http.GET

interface PersonApi {
    @GET("api")
    fun getPerson(): Person
}