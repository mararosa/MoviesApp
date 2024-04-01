package com.mararosa.moviesapp.view.screens.similars.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SimilarMoviesResponse(
    @Json(name = "page") val page: Int? = null,
    @Json(name = "results") val similarMovies: List<SimilarMovieData>? = null,
    @Json(name = "total_pages") val totalPages: Int? = null,
    @Json(name = "total_results") val totalResults: Int? = null
)