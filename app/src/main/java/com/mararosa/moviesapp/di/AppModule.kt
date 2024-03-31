package com.mararosa.moviesapp.di

import com.mararosa.moviesapp.movies.data.repository.MoviesRepository
import com.mararosa.moviesapp.movies.data.repository.MoviesRepositoryImpl
import com.mararosa.moviesapp.movies.domain.interactor.MoviesInteractor
import com.mararosa.moviesapp.movies.domain.interactor.MoviesInteractorImpl
import com.mararosa.moviesapp.movies.service.MoviesService
import com.mararosa.moviesapp.util.Constants
import com.squareup.moshi.Moshi
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
    fun provideMoshy(): Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideMoviesService(retrofit: Retrofit): MoviesService {
        return retrofit.create(MoviesService::class.java)
    }

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