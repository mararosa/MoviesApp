package com.mararosa.moviesapp.view.screens.details.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mararosa.moviesapp.R
import com.mararosa.moviesapp.databinding.ActivityMovieDetailsBinding
import com.mararosa.moviesapp.utils.Constants
import com.mararosa.moviesapp.view.screens.details.presentation.viewmodel.DetailsViewModel
import com.mararosa.moviesapp.view.screens.details.presentation.viewmodel.DetailsViewModelEvent
import com.mararosa.moviesapp.view.screens.movies.domain.MovieVO
import com.mararosa.moviesapp.view.screens.similars.presentation.SimilarsActivity
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding
    private val viewModel: DetailsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)

        val movieVO: MovieVO? = intent.getParcelableExtra("movie")
        if (movieVO != null) {
            binding.vo = movieVO
            setupListeners(movieVO.id)
            showDetails(movieVO)
        } else {
            finish()
        }
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.events.observe(this) { event ->
            when (event) {
                is DetailsViewModelEvent.OnClickSimilarMovie -> {
                    openSimilarMoviesScreen(event.id)
                }
            }
        }
    }

    private fun openSimilarMoviesScreen(id: Int) {
        Intent(this, SimilarsActivity::class.java).apply {
            putExtra("id", id)
            startActivity(this)
        }
    }

    private fun showDetails(movieVO: MovieVO?) {
        Picasso.get()
            .load("${Constants.IMAGE_URL}${movieVO?.backdropImage}")
            .into(binding.imageViewDetailsBackdrop)
    }

    private fun setupListeners(id: Int) {
        binding.buttonDetailsSimilarMovies.setOnClickListener {
            viewModel.onSimilarMoviesClicked(id)
        }
    }
}