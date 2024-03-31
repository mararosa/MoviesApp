package com.mararosa.moviesapp.movies.domain.mapper

import com.mararosa.moviesapp.movies.data.model.MovieData
import com.mararosa.moviesapp.movies.domain.MovieVO

fun List<MovieData>.toMovieListVO(): List<MovieVO> {
    return map {
        it.toMovieVO()
    }
}

fun MovieData.toMovieVO(): MovieVO {
    return MovieVO(
        id = id,
        poster = poster_path.orEmpty(),
        title = original_title.orEmpty()
    )
}
