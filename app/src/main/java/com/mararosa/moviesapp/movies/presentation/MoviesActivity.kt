package com.mararosa.moviesapp.movies.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mararosa.moviesapp.R
import com.mararosa.moviesapp.databinding.ActivityMoviesBinding
import com.mararosa.moviesapp.movies.domain.MovieVO
import com.mararosa.moviesapp.movies.presentation.adapter.MoviesAdapter
import com.mararosa.moviesapp.movies.presentation.viewmodel.MoviesViewModel
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

        viewModel.fetchPopularmovies()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.movies.observe(this) { movies ->
            moviesAdapter = MoviesAdapter(movies)
            binding.recyclerViewMovies.adapter = moviesAdapter
        }
    }
}