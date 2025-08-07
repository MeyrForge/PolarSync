package com.meyrforge.polarsync.feature_sleep.domain.usecases

import com.meyrforge.polarsync.feature_sleep.domain.SleepTrackerRepository
import com.meyrforge.polarsync.feature_sleep.domain.models.Sleep
import java.util.Calendar
import javax.inject.Inject

class SaveSleepTrackerUseCase @Inject constructor(private val sleepTrackerRepository: SleepTrackerRepository) {
    suspend operator fun invoke(
        hoursSlept: Float,
        wentToSleepAt: String,
        negativeThoughts: Boolean,
        anxious: Boolean,
        sleepThroughNight: Boolean,
    ): Long? {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val sleep = Sleep(
            "$day/$month/$year",
            hoursSlept,
            wentToSleepAt,
            negativeThoughts,
            anxious,
            sleepThroughNight,
            ""
        )
        return sleepTrackerRepository.saveSleep(sleep)
    }
}