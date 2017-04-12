package com.example.maxim.turaevkotlin.api

import retrofit2.Call
import javax.inject.Inject

class RestAPI @Inject constructor(private val api: Api): ArtistsApi {

    override fun getArtists(offset: String, limit: String): Call<List<ArtistsDataResponse>> {
        return api.getAll(offset, limit)
    }
}