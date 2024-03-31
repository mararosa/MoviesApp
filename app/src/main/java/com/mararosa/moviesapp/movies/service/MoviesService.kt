package com.mararosa.moviesapp.movies.service

import com.mararosa.moviesapp.movies.data.model.PopularMoviesResponse
import com.mararosa.moviesapp.util.Constants
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MoviesService {

    @GET("movie/popular")
    suspend fun fetchPopularMovies(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
    ): PopularMoviesResponse
}