package com.anucodes.medicinetrackingapp.core.models

import java.util.Date

data class UserDetails(
    val id: String,
    val name: String,
    val email: String,
    val dateOfBirth: Date,
    val age: Int,
    val profilePictureUrl: String? = null,
    val phoneNumber: String? = null,
    val bio: String? = null,
    val isEmailVerified: Boolean = false,
    val createdAt: Date? = null,
    val updatedAt: Date? = null
)