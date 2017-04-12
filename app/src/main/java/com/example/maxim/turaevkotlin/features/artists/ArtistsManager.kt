package com.example.maxim.turaevkotlin.features.artists

import com.example.maxim.turaevkotlin.api.ArtistsApi
import com.example.maxim.turaevkotlin.commons.Artists
import com.example.maxim.turaevkotlin.commons.ArtistsItem
import rx.Observable
import java.nio.charset.Charset
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArtistsManager @Inject constructor(private val api: ArtistsApi) {

    fun getNews(after: String, limit: String = "10"): Observable<Artists> {
        return Observable.create {
            subscriber ->
            val callResponse = api.getArtists(after, limit)
            val response = callResponse.execute()

            if (response.isSuccessful) {

                val dataResponse = response.body().map {
                    ArtistsItem(
                            it.id, String(
                            it.name.toByteArray(Charset.forName("ISO-8859-1")), Charset.forName("UTF-8")),
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