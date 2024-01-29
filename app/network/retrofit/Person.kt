package com.shift.persongenxml.network.retrofit

import java.util.Date

data class Person(
    val name: String,
    val email: String,
    val birthday: Date,
    val address: String,
    val phone: String,
    val password: String,
    val imageThumbnail: String,
    val image: String
)
