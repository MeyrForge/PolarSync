package com.meyrforge.polarsync.feature_sleep.domain.usecases

import com.meyrforge.polarsync.feature_moods.domain.models.MoodSelection
import com.meyrforge.polarsync.feature_sleep.domain.SleepTrackerRepository
import com.meyrforge.polarsync.feature_sleep.domain.models.Sleep
import java.util.Calendar
import javax.inject.Inject

class GetSleepTrackerByDateUseCase @Inject constructor(private val sleepTrackerRepository: SleepTrackerRepository) {
    suspend operator fun invoke(): Sleep {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        return sleepTrackerRepository.getSleepsByDate("$day/$month/$year") ?: Sleep()
    }
}