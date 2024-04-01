package com.mararosa.moviesapp.view.screens.details.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

class DetailsViewModel() : ViewModel() {

    private val _events = MutableLiveData<DetailsViewModelEvent>()
    val events: LiveData<DetailsViewModelEvent> = _events

    fun onSimilarMoviesClicked(id: Int) {
        _events.value = DetailsViewModelEvent.OnClickSimilarMovie(id)
    }
}