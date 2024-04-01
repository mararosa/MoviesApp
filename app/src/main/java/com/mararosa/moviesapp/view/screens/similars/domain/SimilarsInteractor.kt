package com.mararosa.moviesapp.view.screens.similars.domain

import com.mararosa.moviesapp.view.screens.similars.data.SimilarsRepository
import com.mararosa.moviesapp.view.screens.movies.domain.mapper.toDecimalPlaces
import javax.inject.Inject

interface SimilarsInteractor {
    suspend fun fetchSimilarMovies(id: Int): List<SimilarMovieVO>
}

class SimilarsInteractorImpl @Inject constructor(
    private val repository: SimilarsRepository
) : SimilarsInteractor {
    override suspend fun fetchSimilarMovies(id: Int): List<SimilarMovieVO> {
        return repository.fetchSimilarMovies(id)?.map {
            SimilarMovieVO(
                id = it.id ?: -1,
                poster = it.posterPath.orEmpty(),
                title = it.title.orEmpty(),
                overview = it.overview.orEmpty(),
                ratePopularity = it.voteAverage.toDecimalPlaces(),
                backdropImage = it.backdropPath.orEmpty()
            )
        } ?: emptyList()
    }
}
