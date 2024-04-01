package com.mararosa.moviesapp.view.screens.movies.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.mararosa.moviesapp.R
import com.mararosa.moviesapp.databinding.ActivityMoviesBinding
import com.mararosa.moviesapp.view.screens.details.presentation.DetailsActivity
import com.mararosa.moviesapp.view.screens.movies.domain.MovieVO
import com.mararosa.moviesapp.view.screens.movies.presentation.adapter.MoviesAdapter
import com.mararosa.moviesapp.view.screens.movies.presentation.viewmodel.MoviesViewModel
import com.mararosa.moviesapp.view.screens.movies.presentation.viewmodel.MoviesViewModelEvent
import com.mararosa.moviesapp.view.screens.movies.presentation.viewmodel.MoviesViewModelState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoviesBinding
    private lateinit var moviesAdapter: MoviesAdapter
    private val viewModel: MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding =
            DataBindingUtil.setContentView<ActivityMoviesBinding?>(this, R.layout.activity_movies)
                .apply {
                    lifecycleOwner = this@MoviesActivity
                    vm = viewModel
                }

        setupObservers()
        setupListeners()
    }

    private fun setupObservers() {
        viewModel.state.observe(this, Observer { state ->
            when (state) {
                is MoviesViewModelState.Success -> showMovies(state.movies)
                is MoviesViewModelState.Error -> showError()
                is MoviesViewModelState.Loading -> showLoading()
            }
        })
        viewModel.events.observe(this, Observer { event ->
            when (event) {
                is MoviesViewModelEvent.NavigateToDetails -> openMovieDetails(event.movie)
            }
        })
    }

    private fun openMovieDetails(movie: MovieVO) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("movie", movie)
        startActivity(intent)
    }

    private fun showLoading() {
        with(binding) {
            progressBarMovies.visibility = android.view.View.VISIBLE
            textViewError.visibility = android.view.View.GONE
            buttonErrorRetry.visibility = android.view.View.GONE
            recyclerViewMovies.visibility = android.view.View.GONE
        }
    }

    private fun showError() {
        with(binding) {
            textViewError.visibility = android.view.View.VISIBLE
            buttonErrorRetry.visibility = android.view.View.VISIBLE
            recyclerViewMovies.visibility = android.view.View.GONE
            progressBarMovies.visibility = android.view.View.GONE
        }
    }

    private fun showMovies(movieList: List<MovieVO>) {
        moviesAdapter = MoviesAdapter(movieList) { movieVO ->
            viewModel.onMovieClicked(movieVO)
        }
        with(binding) {
            recyclerViewMovies.adapter = moviesAdapter
            recyclerViewMovies.visibility = android.view.View.VISIBLE
            progressBarMovies.visibility = android.view.View.GONE
            textViewError.visibility = android.view.View.GONE
            buttonErrorRetry.visibility = android.view.View.GONE
        }

    }

    private fun setupListeners() {
        binding.buttonErrorRetry.setOnClickListener {
            viewModel.tryAgain()
        }
    }
}