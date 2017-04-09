package com.example.maxim.turaevkotlin.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RestAPI() {

    private val redditApi: RedditApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("http://194.190.63.108:9123")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        redditApi = retrofit.create(RedditApi::class.java)
    }

    fun getArtists(after: String, limit: String): Call<List<ArtistsDataResponse>> {
        return redditApi.getTop(after, limit)
    }
}