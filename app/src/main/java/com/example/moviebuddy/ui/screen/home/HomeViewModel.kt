package com.example.moviebuddy.ui.screen.home

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviebuddy.data.model.Movie
import com.example.moviebuddy.data.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import android.util.Log

class HomeViewModel(context: Context) : ViewModel() {

    private val repository = MovieRepository(context)

    private val _randomMovies = MutableStateFlow<List<Movie>>(emptyList())
    val randomMovies: StateFlow<List<Movie>> = _randomMovies

    private val _topMovies = MutableStateFlow<List<Movie>>(emptyList())
    val topMovies: StateFlow<List<Movie>> = _topMovies

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        loadMovies()
    }

    fun loadMovies() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val popular = repository.getPopularMovies()
                val top = repository.getTopRatedMovies()

                _randomMovies.value = popular.shuffled().take(10)
                _topMovies.value = top.take(5)
            } catch (e: Exception) {
                Log.e("HomeViewModel", "Erro ao carregar filmes", e)
            } finally {
                _isLoading.value = false
            }
        }
    }
}
