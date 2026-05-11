package com.anucodes.medicinetrackingapp.di

import com.anucodes.medicinetrackingapp.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import jakarta.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    val supabaseClient = createSupabaseClient(
        supabaseUrl = BuildConfig.SUPABASE_URL,
        supabaseKey = BuildConfig.SUPABASE_ANON_KEY
    ){
        install(Auth)
        install(Postgrest)
    }

    @Singleton
    @Provides
    fun providesSupabaseAuth(): Auth = supabaseClient.auth

    @Singleton
    @Provides
    fun providesSupabase(): SupabaseClient = supabaseClient
}