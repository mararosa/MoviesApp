package com.mararosa.moviesapp.view.screens.details.presentation.viewmodel

sealed class DetailsViewModelEvent {
    data class OnClickSimilarMovie(val id: Int) : DetailsViewModelEvent()

}
