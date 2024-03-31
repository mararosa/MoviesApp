package com.mararosa.moviesapp.movies.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mararosa.moviesapp.movies.domain.MovieVO
import com.mararosa.moviesapp.movies.domain.interactor.MoviesInteractor
import com.mararosa.moviesapp.util.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val interactor: MoviesInteractor
) : BaseViewModel() {

    private val _movies = MutableLiveData<List<MovieVO>>()
    val movies: LiveData<List<MovieVO>> = _movies

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    init {
        fetchPopularmovies()
    }

    private fun fetchPopularmovies() {
//        viewModelScope.launch {
//            try {
//                val popularMovies = interactor.fetchPopularMovies()
//                _movies.value = popularMovies
//                Log.d("MoviesViewModel", "Response: $popularMovies")
//            } catch (e: Exception) {
//                Log.e("MoviesViewModel", "Error fetching popular movies: ${e.message}")
//                _error.value = e.message
//            }
//        }

        viewModelScope.launch {
            _movies.value = interactor.fetchPopularMovies()
        }
    }
}