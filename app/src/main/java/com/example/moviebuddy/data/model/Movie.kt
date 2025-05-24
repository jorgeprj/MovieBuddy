package com.example.moviebuddy.data.model

data class MovieResponse(
    val results: List<Movie>
)

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String?,
    val vote_average: Double
) {
    val fullPosterUrl: String
        get() = "https://image.tmdb.org/t/p/w500$poster_path"
}
