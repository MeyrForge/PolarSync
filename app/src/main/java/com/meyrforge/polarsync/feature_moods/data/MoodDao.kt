package com.meyrforge.polarsync.feature_moods.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.meyrforge.polarsync.feature_moods.data.entities.MoodEntity

@Dao
interface MoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMood(mood: MoodEntity) : Long?

    @Query("SELECT * FROM mood_table WHERE date = :date")
    suspend fun searchByDate(date: String) : List<MoodEntity>?

    @Query("SELECT * FROM mood_table")
    suspend fun getAllMoods() : List<MoodEntity?>

}