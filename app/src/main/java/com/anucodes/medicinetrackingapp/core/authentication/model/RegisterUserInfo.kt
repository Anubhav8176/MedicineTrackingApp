package com.anucodes.medicinetrackingapp.core.authentication.model

import java.util.Date


data class RegisterUserInfo(
    val name: String,
    val email: String,
    val password: String,
    val dob: Date,
    val age: Int
)
