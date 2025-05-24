package com.example.moviebuddy.ui.screen.details

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.moviebuddy.data.local.entity.FavoriteMovie
import com.example.moviebuddy.data.model.Movie
import com.example.moviebuddy.data.repository.MovieRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val context: Context,
    private val movieId: Int
) : ViewModel() {

    private val repository = MovieRepository(context)

    private val _movie = MutableStateFlow<Movie?>(null)
    val movie: StateFlow<Movie?> = _movie

    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> = _isFavorite

    init {
        loadMovie(movieId)
    }

    fun loadMovie(movieId: Int) {
        viewModelScope.launch {
            _movie.value = repository.getMovieDetails(movieId)
            _isFavorite.value = repository.isFavorite(movieId)
        }
    }

    fun toggleFavorite() {
        viewModelScope.launch {
            movie.value?.let {
                val favorite = FavoriteMovie(it.id, it.title, it.fullPosterUrl)
                if (isFavorite.value) {
                    repository.removeFavorite(favorite)
                    _isFavorite.value = false
                } else {
                    repository.addFavorite(favorite)
                    _isFavorite.value = true
                }
            }
        }
    }
}

class DetailsViewModelFactory(
    private val context: Context,
    private val movieId: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailsViewModel(context, movieId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}