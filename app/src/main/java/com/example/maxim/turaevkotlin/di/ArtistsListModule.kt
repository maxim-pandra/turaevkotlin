package com.example.maxim.turaevkotlin.di

import com.example.maxim.turaevkotlin.api.Api
import com.example.maxim.turaevkotlin.api.ArtistsApi
import com.example.maxim.turaevkotlin.api.RestAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ArtistsListModule {

    @Provides
    @Singleton
    fun provideArtistsListApi(rawApi: Api): ArtistsApi {
        return RestAPI(rawApi)
    }


    @Provides
    @Singleton
    fun provideRawApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
}