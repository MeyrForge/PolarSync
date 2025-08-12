package com.meyrforge.polarsync.feature_sleep.domain.models

data class Sleep(
    val date: String = "",
    val hoursSlept: Float = 0f,
    val wentToSleepAt: String = "00:00",
    val negativeThoughts: Boolean = false,
    val anxious: Boolean = false,
    val sleepThroughNight: Boolean = false,
    val notes: String = ""
)
