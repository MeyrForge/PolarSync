package com.meyrforge.polarsync.feature_sleep.domain

import com.meyrforge.polarsync.feature_sleep.domain.models.Sleep

interface SleepTrackerRepository {
    suspend fun saveSleep(sleep: Sleep): Long?
    suspend fun getSleepsByDate(date: String): Sleep?
}