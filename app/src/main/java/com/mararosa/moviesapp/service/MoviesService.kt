package com.mararosa.moviesapp.service

import com.mararosa.moviesapp.view.screens.movies.data.model.PopularMoviesResponse
import com.mararosa.moviesapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {

    @GET("movie/popular")
    suspend fun fetchPopularMovies(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): PopularMoviesResponse

    @GET("movie/movieId")
    suspend fun fetchMovieDetails(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("language") language: String = "en-US",
        @Path("movieId") movieId: Int
    ): PopularMoviesResponse
}