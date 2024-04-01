package com.mararosa.moviesapp.view.screens.similars.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mararosa.moviesapp.view.screens.similars.domain.SimilarsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SimilarsViewModel @Inject constructor(
    private val interactor: SimilarsInteractor
) : ViewModel() {

    private val _state = MutableLiveData<SimilarsViewModelState>()
    val state: LiveData<SimilarsViewModelState> = _state

    fun fetchSimilarMovies(id: Int) {
        viewModelScope.launch {
            try {
                val movies = interactor.fetchSimilarMovies(id)
                _state.value = SimilarsViewModelState.Success(movies[0])
            } catch (e: Exception) {
                Log.d("SimilarsViewModel", "Error fetching similar movies", e)
                _state.value = SimilarsViewModelState.Error
            }

        }

    }

}