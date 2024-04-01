package com.mararosa.moviesapp.view.screens.similars.data

import com.mararosa.moviesapp.service.MoviesService
import com.mararosa.moviesapp.view.screens.similars.data.model.SimilarMovieData
import javax.inject.Inject

interface SimilarsRepository {
    suspend fun fetchSimilarMovies(movieId: Int): List<SimilarMovieData>?
}

class SimilarsRepositoryImpl @Inject constructor(
    private val service: MoviesService
) : SimilarsRepository {

    override suspend fun fetchSimilarMovies(movieId: Int): List<SimilarMovieData>? {
        return service.fetchSimilarMovies(movieId = movieId).similarMovies
    }
}