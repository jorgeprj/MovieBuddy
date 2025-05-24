package com.example.moviebuddy.data.local.dao

import androidx.room.*
import com.example.moviebuddy.data.local.entity.FavoriteMovie
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteMovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: FavoriteMovie)

    @Delete
    suspend fun delete(movie: FavoriteMovie)

    @Query("SELECT * FROM favorite_movies")
    fun getAll(): Flow<List<FavoriteMovie>>

    @Query("SELECT * FROM favorite_movies WHERE id = :movieId LIMIT 1")
    suspend fun getById(movieId: Int): FavoriteMovie?
}
