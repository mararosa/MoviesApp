package com.mararosa.moviesapp.view.screens.movies.presentation.viewmodel

import com.mararosa.moviesapp.view.screens.movies.domain.MovieVO

sealed class MoviesViewModelState {
    object Loading : MoviesViewModelState()
    data class Success(val movies: List<MovieVO>) : MoviesViewModelState()
    object Error : MoviesViewModelState()
}
