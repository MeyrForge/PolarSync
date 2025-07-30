package com.meyrforge.polarsync.feature_moods.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.meyrforge.polarsync.feature_moods.domain.models.MoodSelection

@Entity(tableName = "mood_table")
data class MoodEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "mood_highest") val moodHighest: String,
    @ColumnInfo(name = "mood_highest_notes") val moodHighestNotes: String,
    @ColumnInfo(name = "mood_irritable") val moodIrritable: String,
    @ColumnInfo(name = "mood_irritable_notes") val moodIrritableNotes: String,
    @ColumnInfo(name = "mood_anxious") val moodAnxious: String,
    @ColumnInfo(name = "mood_anxious_notes") val moodAnxiousNotes: String,
    @ColumnInfo(name = "mood_depressed") val moodDepressed: String,
    @ColumnInfo(name = "mood_depressed_notes") val moodDepressedNotes: String
)

fun MoodEntity.toMoodSelection(): MoodSelection {
    return MoodSelection(
        highest = moodHighest,
        irritable = moodIrritable,
        anxious = moodAnxious,
        depressed = moodDepressed,
        date = date,
        highestNotes = moodHighestNotes,
        irritableNotes = moodIrritableNotes,
        anxiousNotes = moodAnxiousNotes,
        depressedNotes = moodDepressedNotes
    )
}

fun MoodSelection.toMoodEntity(): MoodEntity {
    return MoodEntity(
        moodHighest = highest,
        moodIrritable = irritable,
        moodAnxious = anxious,
        moodDepressed = depressed,
        date = date,
        moodHighestNotes = highestNotes,
        moodIrritableNotes = irritableNotes,
        moodAnxiousNotes = anxiousNotes,
        moodDepressedNotes = depressedNotes
    )
}
