package com.lazamelezi.simplenewsapp.di

import com.lazamelezi.simplenews.data.apiservice.SimpleNewsApiService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object SImpleNewsActivityModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideNewsApiService(): SimpleNewsApiService = SimpleNewsApiService.invoke()
}
