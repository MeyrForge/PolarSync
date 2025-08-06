package com.meyrforge.polarsync.feature_moods.domain.models

data class MoodSelection(
    val highest: String = "",
    val irritable: String = "",
    val anxious: String = "",
    val depressed: String = "",
    val date: String = "",
    val highestNotes: String = "",
    val irritableNotes: String = "",
    val anxiousNotes: String = "",
    val depressedNotes: String = ""
)
