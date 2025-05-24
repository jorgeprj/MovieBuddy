package com.example.moviebuddy.ui.screen.search

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviebuddy.data.model.Movie
import com.example.moviebuddy.data.repository.MovieRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class SearchViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MovieRepository(application.applicationContext)

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query

    private val _results = MutableStateFlow<List<Movie>>(emptyList())
    val results: StateFlow<List<Movie>> = _results

    fun onQueryChanged(newQuery: String) {
        _query.value = newQuery
        if (newQuery.length >= 3) {
            viewModelScope.launch {
                _results.value = repository.searchMovies(newQuery)
            }
        } else {
            _results.value = emptyList()
        }
    }
}