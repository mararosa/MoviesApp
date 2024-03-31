package com.mararosa.moviesapp.movies.data.model

data class PopularMoviesResponse(
    val page: Int? = null,
    val movies: List<MovieData>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)