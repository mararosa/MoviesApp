package com.mararosa.moviesapp.di

import com.mararosa.moviesapp.view.screens.movies.data.repository.MoviesRepository
import com.mararosa.moviesapp.view.screens.movies.data.repository.MoviesRepositoryImpl
import com.mararosa.moviesapp.view.screens.movies.domain.interactor.MoviesInteractor
import com.mararosa.moviesapp.view.screens.movies.domain.interactor.MoviesInteractorImpl
import com.mararosa.moviesapp.service.MoviesService
import com.mararosa.moviesapp.utils.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoviesRepository(moviesService: MoviesService): MoviesRepository {
        return MoviesRepositoryImpl(moviesService)
    }

    @Provides
    @Singleton
    fun provideMoviesInteractor(repository: MoviesRepository): MoviesInteractor {
        return MoviesInteractorImpl(repository)
    }
}