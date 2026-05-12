package com.anucodes.medicinetrackingapp.core.authentication.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anucodes.medicinetrackingapp.core.authentication.model.AuthResponse
import com.anucodes.medicinetrackingapp.core.authentication.model.LogInRequest
import com.anucodes.medicinetrackingapp.core.authentication.model.RegisterUserInfo
import com.anucodes.medicinetrackingapp.core.models.UserDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.user.UserInfo
import io.github.jan.supabase.auth.user.UserSession
import io.github.jan.supabase.exceptions.RestException
import jakarta.inject.Inject
import java.text.SimpleDateFormat
import java.util.Locale
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import java.util.Date
import kotlin.time.Instant
import kotlin.time.toJavaInstant

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val supabaseAuth: Auth,
    private val supabaseClient: SupabaseClient
): ViewModel() {

    private val _authResponse = MutableStateFlow<AuthResponse>(AuthResponse.Idle)
    val authResponse = _authResponse.asStateFlow()

    private val _userInfo = MutableStateFlow<UserDetails?>(null)
    val userInfo = _userInfo.asStateFlow()

    init {
        getCurrentUser()
    }

    //Register new user
    fun createNewUser(registerUserInfo: RegisterUserInfo){
        viewModelScope.launch {
            _authResponse.value = AuthResponse.Loading
            try {
                //Creating new user in supabase
                val user = supabaseAuth.signUpWith(Email){
                    email = registerUserInfo.email
                    password = registerUserInfo.password
                    data = buildJsonObject {
                        put("name", registerUserInfo.name)
                        put("date_of_birth", registerUserInfo.dob.toString())
                        put("age", registerUserInfo.age.toString())
                    }
                }

                //Checking that if user is created or not.
                if(user!=null){
                    _authResponse.value = AuthResponse.Success("Profile created!")
                }else{
                    _authResponse.value = AuthResponse.Failure("Unable to create new user!")
                }
            }catch (e: RestException){
                _authResponse.value = AuthResponse.Failure(e.message.toString())
            }catch (e: Exception){
                _authResponse.value = AuthResponse.Failure("Cannot create new user!")
            }
        }
    }


    //Login existing user
    fun loginUser(logInRequest: LogInRequest){
        viewModelScope.launch {
            _authResponse.value = AuthResponse.Loading
            try {
                supabaseAuth.signInWith(Email){
                    email = logInRequest.email
                    password = logInRequest.password
                }

                val session = supabaseAuth.currentSessionOrNull()

                if(session != null){
                    val user = mapToUserInfo(session)
                    _userInfo.value = user
                    _authResponse.value = AuthResponse.Success("Login successful!")
                }else{
                    _authResponse.value = AuthResponse.Failure("Login failed!")
                }

            }catch (e: RestException){
                _authResponse.value = AuthResponse.Failure(e.message.toString())
            }catch (e: Exception){
                _authResponse.value = AuthResponse.Failure("Login failed!")
            }
        }
    }

    fun getCurrentUser(){
        val session = supabaseAuth.currentSessionOrNull()

        if(session != null){
            val user = mapToUserInfo(session)
            _userInfo.value = user
        }else{
            Log.i("Current User: ", "Failed to fetch the user")
        }
    }

    fun updateAuthState(){
        _authResponse.value = AuthResponse.Idle
    }

    fun mapToUserInfo(session: UserSession): UserDetails {
        val user = session.user

        return UserDetails(
            id = user?.id ?: "",
            name = user?.userMetadata?.get("name").toString(),
            email = user?.email ?: "",
            dateOfBirth = user?.userMetadata?.get("date_of_birth").toString().toDate(),
            age = user?.userMetadata?.get("age").toString().toInt(),
            isEmailVerified = user?.emailConfirmedAt != null,
            createdAt = user?.createdAt?.toDate(),
            updatedAt = user?.updatedAt?.toDate()
        )
    }

    fun String.toDate(format: String = "yyyy-MM-dd"): Date {
        return SimpleDateFormat(format, Locale.getDefault()).parse(this) ?: Date()
    }

    fun Instant.toDate(): Date {
        return Date(this.toEpochMilliseconds())
    }
}