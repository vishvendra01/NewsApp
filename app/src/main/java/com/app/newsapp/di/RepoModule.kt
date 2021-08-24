package com.app.newsapp.di

import com.app.newsapp.data.repo.NewsRepository
import com.app.newsapp.data.repo.NewsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
interface RepoModule {

    @Binds
    fun bindRepo(repository: NewsRepositoryImpl): NewsRepository
}