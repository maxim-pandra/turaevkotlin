package com.example.maxim.turaevkotlin.di.artists

import com.example.maxim.turaevkotlin.di.AppModule
import com.example.maxim.turaevkotlin.di.ArtistsListModule
import com.example.maxim.turaevkotlin.di.NetworkModule
import com.example.maxim.turaevkotlin.features.artists.ArtistsFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        ArtistsListModule::class,
        NetworkModule::class
))
interface ArtistsComponent {
    fun inject(artistsFragment: ArtistsFragment)
}