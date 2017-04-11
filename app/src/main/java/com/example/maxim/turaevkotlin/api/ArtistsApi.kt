package com.example.maxim.turaevkotlin.api

import retrofit2.Call

interface ArtistsApi {
    fun getArtists(offset: String, limit: String): Call<List<ArtistsDataResponse>>
}