package com.example.maxim.turaevkotlin.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://194.190.63.108:9123")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }
}