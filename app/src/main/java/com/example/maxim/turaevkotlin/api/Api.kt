package com.example.maxim.turaevkotlin.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("/all")
    fun getAll(@Query("offset") offset: String,
                   @Query("limit") limit : String) : Call<List<ArtistsDataResponse>>
}