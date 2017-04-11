package com.example.maxim.turaevkotlin.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class RestAPI @Inject constructor(private val api: Api): ArtistsApi {

//    private val api: Api
//
//    init {
//        val retrofit = Retrofit.Builder()
//                .baseUrl("http://194.190.63.108:9123")
//                .addConverterFactory(MoshiConverterFactory.create())
//                .build()
//
//        api = retrofit.create(Api::class.java)
//    }

    override fun getArtists(offset: String, limit: String): Call<List<ArtistsDataResponse>> {
        return api.getAll(offset, limit)
    }
}