package com.mararosa.moviesapp.view.screens.similars.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.mararosa.moviesapp.R
import com.mararosa.moviesapp.databinding.ActivitySimilarsBinding
import com.mararosa.moviesapp.utils.Constants
import com.mararosa.moviesapp.view.screens.similars.domain.SimilarMovieVO
import com.mararosa.moviesapp.view.screens.similars.presentation.viewmodel.SimilarsViewModel
import com.mararosa.moviesapp.view.screens.similars.presentation.viewmodel.SimilarsViewModelState
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SimilarsActivity : AppCompatActivity() {
    lateinit var bindind: ActivitySimilarsBinding
    val viewModel: SimilarsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindind = DataBindingUtil.setContentView(this, R.layout.activity_similars)

        val movieId: Int = intent.getIntExtra("id", -1)

        viewModel.fetchSimilarMovies(movieId)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.state.observe(this, Observer { state ->
            when (state) {
                is SimilarsViewModelState.Success -> {
                    showSimilarMovies(state.movie)
                }

                is SimilarsViewModelState.Error -> {
                    //TODO: Handle error
                }
            }
        })
    }

    private fun showSimilarMovies(movie: SimilarMovieVO) {
        with(bindind) {
            textViewSimilarMovieTitle.text = movie.title
            textViewSimilarMovieOverview.text = movie.overview
            textViewSimilarMovieReleaseDate.text = movie.releaseDate
            Picasso.get()
                .load(Constants.IMAGE_URL + movie.poster)
                .into(imageViewSimilarMovie)
        }

    }


}