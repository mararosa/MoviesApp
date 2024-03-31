package com.mararosa.moviesapp.movies.presentation.viewmodel

import com.mararosa.moviesapp.movies.domain.MovieVO

sealed class MoviesViewModelState {
    object Loading : MoviesViewModelState()
    data class Success(val movies: List<MovieVO>) : MoviesViewModelState()
    object Error : MoviesViewModelState()
}
