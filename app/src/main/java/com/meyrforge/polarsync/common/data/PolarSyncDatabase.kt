package com.meyrforge.polarsync.common.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.meyrforge.polarsync.feature_moods.data.MoodDao
import com.meyrforge.polarsync.feature_moods.data.entities.MoodEntity
import com.meyrforge.polarsync.feature_sleep.data.SleepDao
import com.meyrforge.polarsync.feature_sleep.data.entities.SleepEntity

@Database(entities = [MoodEntity::class, SleepEntity::class], version = 2)
abstract class PolarSyncDatabase: RoomDatabase() {
    abstract fun moodDao(): MoodDao
    abstract fun sleepDao(): SleepDao
}