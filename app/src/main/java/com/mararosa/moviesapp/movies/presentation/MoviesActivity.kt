package com.mararosa.moviesapp.movies.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.mararosa.moviesapp.R
import com.mararosa.moviesapp.databinding.ActivityMoviesBinding
import com.mararosa.moviesapp.movies.data.model.MovieVO
import com.mararosa.moviesapp.movies.presentation.adapter.MoviesAdapter

class MoviesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoviesBinding
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView<ActivityMoviesBinding?>(this, R.layout.activity_movies).apply {
            lifecycleOwner = this@MoviesActivity
        }

        val movies = listOf(
            MovieVO(R.drawable.movieposter, "Spider Man"),
            MovieVO(R.drawable.movieposter, "Winnie the Pooh"),
            MovieVO(R.drawable.movieposter, "Spider Man"),
            MovieVO(R.drawable.movieposter, "Winnie the Pooh"),
            MovieVO(R.drawable.movieposter, "Spider Man"),
            MovieVO(R.drawable.movieposter, "Winnie the Pooh"),
            MovieVO(R.drawable.movieposter, "Spider Man"),
            MovieVO(R.drawable.movieposter, "Winnie the Pooh"),
            MovieVO(R.drawable.movieposter, "Spider Man"),
            MovieVO(R.drawable.movieposter, "Winnie the Pooh"),
            MovieVO(R.drawable.movieposter, "Spider Man"),
            MovieVO(R.drawable.movieposter, "Winnie the Pooh")
        )
        moviesAdapter = MoviesAdapter(movies)
        binding.recyclerViewMovies.adapter = moviesAdapter
    }
}