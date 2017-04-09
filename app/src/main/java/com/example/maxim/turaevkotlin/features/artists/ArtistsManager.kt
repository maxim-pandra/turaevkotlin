package com.example.maxim.turaevkotlin.features.artists

import com.example.maxim.turaevkotlin.api.RestAPI
import com.example.maxim.turaevkotlin.commons.Artists
import com.example.maxim.turaevkotlin.commons.ArtistsItem
import rx.Observable

class ArtistsManager(private val api: RestAPI = RestAPI()) {

    fun getNews(after: String, limit: String = "10"): Observable<Artists> {
        return Observable.create {
            subscriber ->
            val callResponse = api.getArtists(after, limit)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                val dataResponse = response.body().map {
                    ArtistsItem(it.id, it.name,
                            it.cover)
                }
                val redditNews = Artists(
                        dataResponse
                )
                subscriber.onNext(redditNews)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}