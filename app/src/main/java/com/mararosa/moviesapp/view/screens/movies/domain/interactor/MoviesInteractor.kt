package com.mararosa.moviesapp.view.screens.movies.domain.interactor

import com.mararosa.moviesapp.view.screens.movies.data.repository.MoviesRepository
import com.mararosa.moviesapp.view.screens.movies.domain.MovieVO
import com.mararosa.moviesapp.view.screens.movies.domain.mapper.toMovieListVO
import com.mararosa.moviesapp.view.screens.movies.domain.mapper.toMovieVO
import javax.inject.Inject

interface MoviesInteractor {
    suspend fun fetchPopularMovies(): List<MovieVO>
}

class MoviesInteractorImpl @Inject constructor(
    private val repository: MoviesRepository
) : MoviesInteractor {

    override suspend fun fetchPopularMovies(): List<MovieVO> {
        return repository.fetchPopularMovies()?.toMovieListVO() ?: emptyList()
    }


}