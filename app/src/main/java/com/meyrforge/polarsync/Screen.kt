package com.meyrforge.polarsync

sealed class Screen(val route: String) {
    data object HomeScreen: Screen("home_screen")
    data object LoginScreen: Screen("login_screen")
    data object RegisterScreen: Screen("register_screen")
    data object ActivationEmailScreen: Screen("activation_email_screen")
    data object MoodSelectionScreen: Screen("mood_selection_screen")
    data object SleepTrackerScreen: Screen("sleep_tracker_screen")
    data object MedicationTrackerScreen: Screen("medication_tracker_screen")
}