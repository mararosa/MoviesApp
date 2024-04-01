package com.mararosa.moviesapp.view.screens.movies.presentation.viewmodel

import com.mararosa.moviesapp.view.screens.movies.domain.MovieVO

sealed class MoviesViewModelEvent {
    data class NavigateToDetails(val movie: MovieVO) : MoviesViewModelEvent()
}
