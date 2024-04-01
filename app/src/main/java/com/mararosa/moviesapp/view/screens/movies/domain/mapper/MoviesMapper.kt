package com.mararosa.moviesapp.view.screens.movies.domain.mapper

import com.mararosa.moviesapp.view.screens.movies.data.model.MovieData
import com.mararosa.moviesapp.view.screens.movies.domain.MovieVO

fun List<MovieData>.toMovieListVO(): List<MovieVO> {
    return map {
        it.toMovieVO()
    }
}

fun MovieData.toMovieVO(): MovieVO {
    return MovieVO(
        id = id,
        poster = posterPath.orEmpty(),
        title = title.orEmpty(),
        overview = overview.orEmpty(),
        ratePopularity = voteAverage.toDecimalPlaces(),
        backdropImage = backdropPath.orEmpty()
    )
}

fun Double?.toDecimalPlaces(): String {
    return this?.let {
        String.format("%.2f", it)
    } ?: "0.0"

}
