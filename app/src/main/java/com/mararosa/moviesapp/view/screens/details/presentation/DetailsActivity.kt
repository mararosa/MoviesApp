package com.mararosa.moviesapp.view.screens.details.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mararosa.moviesapp.R
import com.mararosa.moviesapp.databinding.ActivityMovieDetailsBinding
import com.mararosa.moviesapp.utils.Constants
import com.mararosa.moviesapp.view.screens.movies.domain.MovieVO
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)

        val movieVO: MovieVO? = intent.getParcelableExtra("movie")
        if (movieVO != null) {
            binding.vo = movieVO
        }

        Picasso.get()
            .load("${Constants.IMAGE_URL}${movieVO?.backdropImage}")
            .into(binding.imageViewDetailsBackdrop)

    }
}