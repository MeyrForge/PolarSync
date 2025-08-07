package com.meyrforge.polarsync.feature_moods.domain.usecases

import android.util.Log
import com.meyrforge.polarsync.feature_moods.domain.MoodSelectionRepository
import com.meyrforge.polarsync.feature_moods.domain.models.MoodSelection
import java.util.Calendar
import javax.inject.Inject

class SaveMoodSelectionUseCase @Inject constructor(private val moodSelectionRepository: MoodSelectionRepository) {
    suspend operator fun invoke(
        highest: String,
        irritable: String,
        anxious: String,
        depressed: String,
    ): Long? {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hour = calendar.get(Calendar.HOUR)
        Log.d("DATE", "$day/$month/$year $hour")
        val moodSelection =
            MoodSelection(
                highest,
                irritable,
                anxious,
                depressed,
                "$day/$month/$year",
                "",
                "",
                "",
                ""
            )
        return moodSelectionRepository.saveMoods(moodSelection)
    }

}