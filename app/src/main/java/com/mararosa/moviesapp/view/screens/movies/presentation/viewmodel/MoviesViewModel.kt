package com.mararosa.moviesapp.view.screens.movies.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mararosa.moviesapp.view.screens.movies.domain.interactor.MoviesInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val interactor: MoviesInteractor
) : ViewModel() {

    private val _state = MutableLiveData<MoviesViewModelState>()
    val state: LiveData<MoviesViewModelState> = _state

    init {
        fetchPopularMovies()
    }

    private fun fetchPopularMovies() {
        viewModelScope.launch {
            _state.value = MoviesViewModelState.Loading
            try {
                val popularMovies = interactor.fetchPopularMovies()
                _state.value = MoviesViewModelState.Success(popularMovies)
            } catch (e: Exception) {
                Log.e("MoviesViewModel", "Error fetching popular movies: ${e.message}")
                _state.value = MoviesViewModelState.Error
            }
        }
    }

    fun tryAgain() {
        fetchPopularMovies()
    }
}