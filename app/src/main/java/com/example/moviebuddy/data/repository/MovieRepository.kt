package com.example.moviebuddy.data.repository

import com.example.moviebuddy.data.model.Movie
import com.example.moviebuddy.data.remote.RetrofitInstance

import android.content.Context
import com.example.moviebuddy.data.local.MovieDatabase
import com.example.moviebuddy.data.local.entity.FavoriteMovie

class MovieRepository(context: Context) {
    private val api = RetrofitInstance.api
    private val apiKey = "f2290f5f295c33140c6daa2e322cce0b"

    private val db = MovieDatabase.getDatabase(context)
    private val dao = db.favoriteMovieDao()

    suspend fun getPopularMovies(): List<Movie> {
        return RetrofitInstance.api.getPopularMovies(apiKey).results
    }

    suspend fun getTopRatedMovies(): List<Movie> {
        return RetrofitInstance.api.getTopRatedMovies(apiKey).results
    }

    suspend fun searchMovies(query: String): List<Movie> {
        return RetrofitInstance.api.searchMovies(apiKey, query).results
    }

    suspend fun getMovieDetails(movieId: Int): Movie {
        return RetrofitInstance.api.getMovieDetails(movieId, apiKey)
    }

    fun getFavorites() = dao.getAll()

    suspend fun addFavorite(movie: FavoriteMovie) = dao.insert(movie)

    suspend fun removeFavorite(movie: FavoriteMovie) = dao.delete(movie)

    suspend fun isFavorite(movieId: Int) = dao.getById(movieId) != null
}
