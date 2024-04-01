package com.mararosa.moviesapp.view.screens.movies.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mararosa.moviesapp.databinding.ViewMoviesItemBinding
import com.mararosa.moviesapp.view.screens.movies.domain.MovieVO
import com.mararosa.moviesapp.utils.Constants
import com.squareup.picasso.Picasso

class MoviesAdapter(
    private val movies: List<MovieVO>,
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewMoviesItemBinding.inflate(inflater, parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            onClick(movie.id)
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }


    class MoviesViewHolder(
        private val binding: ViewMoviesItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieVO) {
            binding.textViewMovieTitle.text = movie.title
            Picasso.get()
                .load("${Constants.IMAGE_URL}${movie.poster}")
                .into(binding.imageViewMoviesItem)
        }
    }
}