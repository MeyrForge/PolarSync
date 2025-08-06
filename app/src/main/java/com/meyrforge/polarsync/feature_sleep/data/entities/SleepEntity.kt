package com.meyrforge.polarsync.feature_sleep.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.meyrforge.polarsync.feature_sleep.domain.models.Sleep

@Entity(tableName = "sleep_table")
data class SleepEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "hours_slept") val hoursSlept: Float,
    @ColumnInfo(name = "went_to_sleep_at") val wentToSleepAt: String,
    @ColumnInfo(name = "negative_thoughts") val negativeThoughts: Boolean,
    @ColumnInfo(name = "anxious") val anxious: Boolean,
    @ColumnInfo(name = "sleep_through_night") val sleepThroughNight: Boolean,
    @ColumnInfo(name = "notes") val notes: String
)

fun SleepEntity.toSleep(): Sleep {
    return Sleep(
        date = date,
        hoursSlept = hoursSlept,
        wentToSleepAt = wentToSleepAt,
        negativeThoughts = negativeThoughts,
        anxious = anxious,
        sleepThroughNight = sleepThroughNight,
        notes = notes)
}

fun Sleep.toSleepEntity(): SleepEntity{
    return SleepEntity(
        date = date,
        hoursSlept = hoursSlept,
        wentToSleepAt = wentToSleepAt,
        negativeThoughts = negativeThoughts,
        anxious = anxious,
        sleepThroughNight = sleepThroughNight,
        notes = notes)
}
