package com.mararosa.moviesapp.view.screens.similars.presentation.viewmodel

import com.mararosa.moviesapp.view.screens.similars.domain.SimilarMovieVO

sealed class SimilarsViewModelState {
    data class Success(val movie: SimilarMovieVO) : SimilarsViewModelState()
    object Error : SimilarsViewModelState()

}
