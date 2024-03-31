package com.mararosa.moviesapp.movies.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mararosa.moviesapp.databinding.ViewMoviesItemBinding
import com.mararosa.moviesapp.movies.domain.MovieVO
import com.squareup.picasso.Picasso

class MoviesAdapter(
    private val movies: List<MovieVO>,
) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewMoviesItemBinding.inflate(inflater, parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }


    class MovieViewHolder(
        private val binding: ViewMoviesItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieVO) {
            binding.textViewMovieTitle.text = movie.title
            Picasso.get()
                .load(movie.poster)
                .into(binding.imageViewMoviesItem)
        }

    }
}