package com.lazamelezi.simplenewsapp.di

import com.lazamelezi.simplenews.data.repository.NewsRepository
import com.lazamelezi.simplenews.data.repository.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindNewsRepo(
        newsRepository: NewsRepositoryImpl
    ): NewsRepository
}
