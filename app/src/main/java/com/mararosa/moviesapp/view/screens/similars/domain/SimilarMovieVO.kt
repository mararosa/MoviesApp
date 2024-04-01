package com.mararosa.moviesapp.view.screens.similars.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SimilarMovieVO(
    val id: Int,
    val poster: String,
    val title: String,
    val overview: String,
    val ratePopularity: String,
    val backdropImage: String,
) : Parcelable
