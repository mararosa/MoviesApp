package com.mararosa.moviesapp.movies.service

import com.mararosa.moviesapp.movies.data.model.PopularMoviesResponse
import retrofit2.http.GET

interface MoviesService {

    @GET("movie/popular")
    suspend fun fetchPopularMovies(): PopularMoviesResponse
}