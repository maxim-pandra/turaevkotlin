package com.example.maxim.turaevkotlin.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by maxim on 4/9/2017.
 */
interface RedditApi {
    @GET("/all")
    fun getTop(@Query("offset") offset: String,
               @Query("limit") limit : String) : Call<List<ArtistsDataResponse>>
}