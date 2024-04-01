package com.mararosa.moviesapp.di

import com.mararosa.moviesapp.view.screens.movies.data.repository.MoviesRepository
import com.mararosa.moviesapp.view.screens.movies.data.repository.MoviesRepositoryImpl
import com.mararosa.moviesapp.view.screens.movies.domain.interactor.MoviesInteractor
import com.mararosa.moviesapp.view.screens.movies.domain.interactor.MoviesInteractorImpl
import com.mararosa.moviesapp.service.MoviesService
import com.mararosa.moviesapp.view.screens.similars.data.SimilarsRepository
import com.mararosa.moviesapp.view.screens.similars.data.SimilarsRepositoryImpl
import com.mararosa.moviesapp.view.screens.similars.domain.SimilarsInteractor
import com.mararosa.moviesapp.view.screens.similars.domain.SimilarsInteractorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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

    @Provides
    @Singleton
    fun provideSimilarsRepository(moviesService: MoviesService): SimilarsRepository {
        return SimilarsRepositoryImpl(moviesService)
    }

    @Provides
    @Singleton
    fun provideSimilarsInteractor(repository: SimilarsRepository): SimilarsInteractor {
        return SimilarsInteractorImpl(repository)
    }
}