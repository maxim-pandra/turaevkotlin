package com.example.maxim.turaevkotlin

import android.app.Application
import com.example.maxim.turaevkotlin.di.AppModule
import com.example.maxim.turaevkotlin.di.artists.ArtistsComponent
import com.example.maxim.turaevkotlin.di.artists.DaggerArtistsComponent

/**
 * Created by maxim on 4/11/2017.
 */
class DaggerApplication : Application() {

    companion object {
        lateinit var artistsComponent: ArtistsComponent
    }

    override fun onCreate() {
        super.onCreate()
        artistsComponent = DaggerArtistsComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}