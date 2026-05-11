package com.anucodes.medicinetrackingapp.core.authentication.model

sealed class AuthResponse {
    object Idle: AuthResponse()
    object Loading: AuthResponse()
    data class Success(val message: String): AuthResponse()
    data class Failure(val message: String): AuthResponse()
}