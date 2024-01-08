package com.pableras.horoscapp.data.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton // <-- Permite crear un objeto Retrofit una vez en lugar de crearlo constantemente
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://newastro.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideHoroscopeAPIService(retrofit: Retrofit): HoroscopeAPIService {
        return retrofit.create(HoroscopeAPIService::class.java)
    }
}