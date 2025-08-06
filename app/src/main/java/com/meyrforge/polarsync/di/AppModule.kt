package com.meyrforge.polarsync.di

import android.content.Context
import androidx.room.Room
import com.meyrforge.polarsync.common.data.PolarSyncDatabase
import com.meyrforge.polarsync.feature_moods.data.MoodDao
import com.meyrforge.polarsync.feature_moods.data.MoodSelectionRepositoryImpl
import com.meyrforge.polarsync.feature_moods.domain.MoodSelectionRepository
import com.meyrforge.polarsync.feature_sleep.data.SleepDao
import com.meyrforge.polarsync.feature_sleep.data.SleepTrackerRepositoryImpl
import com.meyrforge.polarsync.feature_sleep.domain.SleepTrackerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DATABASE_NAME = "polar_sync_database"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, PolarSyncDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration(false)
            .build()

    @Provides
    @Singleton
    fun provideMoodDao(database: PolarSyncDatabase) = database.moodDao()

    @Provides
    fun provideMoodSelectionRepository(moodDao: MoodDao): MoodSelectionRepository {
        return MoodSelectionRepositoryImpl(moodDao)
    }

    @Provides
    @Singleton
    fun provideSleepDao(database: PolarSyncDatabase) = database.sleepDao()

    @Provides
    fun provideSleepTrackerRepository(sleepDao: SleepDao): SleepTrackerRepository {
        return SleepTrackerRepositoryImpl(sleepDao)
    }
}