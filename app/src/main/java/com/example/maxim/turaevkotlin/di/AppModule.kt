package com.example.maxim.turaevkotlin.di

import android.content.Context
import com.example.maxim.turaevkotlin.DaggerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app: DaggerApplication) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return app
    }

    @Provides
    @Singleton
    fun provideApplication(): DaggerApplication {
        return app
    }

}