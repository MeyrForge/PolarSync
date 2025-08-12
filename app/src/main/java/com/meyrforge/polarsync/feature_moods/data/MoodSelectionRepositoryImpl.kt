package com.meyrforge.polarsync.feature_moods.data

import com.meyrforge.polarsync.feature_moods.data.entities.toMoodEntity
import com.meyrforge.polarsync.feature_moods.data.entities.toMoodSelection
import com.meyrforge.polarsync.feature_moods.domain.MoodSelectionRepository
import com.meyrforge.polarsync.feature_moods.domain.models.MoodSelection
import javax.inject.Inject

class MoodSelectionRepositoryImpl @Inject constructor(private val moodDao: MoodDao) :
    MoodSelectionRepository {
    override suspend fun saveMoods(moodSelection: MoodSelection): Long? {
        return moodDao.insertMood(moodSelection.toMoodEntity())
    }

    override suspend fun getMoodsByDate(date: String): MoodSelection {
        val moods = moodDao.searchByDate(date).lastOrNull()
        return moods?.toMoodSelection() ?: MoodSelection()
    }

}