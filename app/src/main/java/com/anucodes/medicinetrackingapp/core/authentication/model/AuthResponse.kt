package com.anucodes.medicinetrackingapp.core.authentication.model

import com.anucodes.medicinetrackingapp.core.models.UserDetails

sealed class AuthResponse {
    object Idle: AuthResponse()
    object Loading: AuthResponse()
    data class Success(val message: String): AuthResponse()
    data class Failure(val message: String): AuthResponse()
}

sealed class AuthState {
    object Loading : AuthState()
    data class Authenticated(val user: UserDetails) : AuthState()
    object Unauthenticated : AuthState()
}