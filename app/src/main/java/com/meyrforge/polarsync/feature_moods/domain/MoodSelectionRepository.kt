package com.meyrforge.polarsync.feature_moods.domain

import com.meyrforge.polarsync.feature_moods.domain.models.MoodSelection

interface MoodSelectionRepository {
    suspend fun saveMoods(moodSelection: MoodSelection): Long?
    suspend fun getMoodsByDate(date: String): MoodSelection?
}