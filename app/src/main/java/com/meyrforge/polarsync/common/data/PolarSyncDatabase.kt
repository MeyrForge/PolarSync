package com.meyrforge.polarsync.common.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.meyrforge.polarsync.feature_moods.data.MoodDao
import com.meyrforge.polarsync.feature_moods.data.entities.MoodEntity

@Database(entities = [MoodEntity::class], version = 1)
abstract class PolarSyncDatabase: RoomDatabase() {
    abstract fun moodDao(): MoodDao
}