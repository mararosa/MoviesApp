package com.mararosa.moviesapp.movies.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mararosa.moviesapp.movies.domain.MovieVO
import com.mararosa.moviesapp.movies.domain.interactor.MoviesInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val interactor: MoviesInteractor
) : ViewModel() {

    private val _movies = MutableLiveData<List<MovieVO>>()
    val movies: LiveData<List<MovieVO>> = _movies

    fun fetchPopularmovies() {
        viewModelScope.launch {
            _movies.value = interactor.fetchPopularMovies()
        }
    }
}