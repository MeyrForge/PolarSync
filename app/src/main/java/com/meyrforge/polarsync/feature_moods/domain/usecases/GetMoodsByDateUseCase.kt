package com.meyrforge.polarsync.feature_moods.domain.usecases

import com.meyrforge.polarsync.feature_moods.domain.MoodSelectionRepository
import com.meyrforge.polarsync.feature_moods.domain.models.MoodSelection
import java.util.Calendar
import javax.inject.Inject

class GetMoodsByDateUseCase @Inject constructor(private val moodSelectionRepository: MoodSelectionRepository) {
    suspend operator fun invoke(): MoodSelection {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        return moodSelectionRepository.getMoodsByDate("$day/$month/$year") ?: MoodSelection(
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "")
    }

}