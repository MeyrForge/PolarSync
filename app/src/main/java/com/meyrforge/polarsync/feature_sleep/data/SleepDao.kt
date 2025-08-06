package com.meyrforge.polarsync.feature_sleep.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.meyrforge.polarsync.feature_sleep.data.entities.SleepEntity

@Dao
interface SleepDao {
    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertSleep(sleep: SleepEntity) : Long?

    @Query("SELECT * FROM sleep_table WHERE date = :date")
    suspend fun searchByDate(date: String) : List<SleepEntity>?

    @Query("SELECT * FROM sleep_table")
    suspend fun getAllSleeps() : List<SleepEntity?>
}