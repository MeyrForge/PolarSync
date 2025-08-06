package com.meyrforge.polarsync.feature_sleep.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meyrforge.polarsync.feature_moods.presentation.MoodSelectionViewModel
import com.meyrforge.polarsync.feature_moods.presentation.NotificationSnackbar
import com.meyrforge.polarsync.feature_sleep.presentation.components.HoursSliderComponent
import com.meyrforge.polarsync.feature_sleep.presentation.components.QuestionWithSegmentedButtonComponent
import com.meyrforge.polarsync.feature_sleep.presentation.components.WentToSleepClockComponent
import com.meyrforge.polarsync.ui.shared.ButtonComponent
import com.meyrforge.polarsync.ui.shared.DateComponent
import com.meyrforge.polarsync.ui.shared.PolyTalkItem
import com.meyrforge.polarsync.ui.shared.TopSemicircleItem
import com.meyrforge.polarsync.ui.theme.DeepPurple

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun SleepTrackerScreen(viewModel: SleepTrackerViewModel = hiltViewModel()) {
    val sliderPosition: Float by viewModel.sliderPosition.observeAsState(0f)
    val negativeThoughts: Boolean by viewModel.negativeThoughts.observeAsState(false)
    val anxious: Boolean by viewModel.anxious.observeAsState(false)
    val sleepThroughNight: Boolean by viewModel.sleepThroughNight.observeAsState(false)
    val snackbarHostState = remember { SnackbarHostState() }


    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(DeepPurple)
                .padding(paddingValues)
        ) {
            item {
                TopSemicircleItem("Seguimiento del sueño")
            }
            item {
                PolyTalkItem()
            }
            item { DateComponent() }
            item { HoursSliderComponent(sliderPosition) { viewModel.onSliderChanged(it) } }
            item { WentToSleepClockComponent() }
            item {
                QuestionWithSegmentedButtonComponent(
                    "Tuviste pensamientos negativos?",
                    negativeThoughts,
                    viewModel::onNegativeThoughtsChange
                )
            }
            item {
                QuestionWithSegmentedButtonComponent(
                    "Estuviste ansioso antes de dormir?",
                    anxious,
                    viewModel::onAnxiousChange
                )
            }
            item {
                QuestionWithSegmentedButtonComponent(
                    "Dormiste de corrido?",
                    sleepThroughNight,
                    viewModel::onSleepThroughNightChange
                )
            }
            //item { AddNotesComponent() }
            item {
                Box(
                    modifier = Modifier
                        .padding(15.dp)
                        .padding(bottom = 20.dp)
                ) {
                    ButtonComponent("Guardar", onClick = viewModel::onSaveSleep)
                }
            }

        }
        NotificationSnackbar(viewModel, snackbarHostState)
    }
}

@Composable
fun NotificationSnackbar(viewModel: SleepTrackerViewModel, snackbarHostState: SnackbarHostState) {
    val notificationMessage by viewModel.notificationMessage.observeAsState()

    LaunchedEffect(notificationMessage) {
        notificationMessage?.let {
            snackbarHostState.showSnackbar(it)
            viewModel.clearMessage()
        }
    }
}