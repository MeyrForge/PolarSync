package com.meyrforge.polarsync.feature_sleep.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meyrforge.polarsync.feature_sleep.presentation.components.AddNotesComponent
import com.meyrforge.polarsync.feature_sleep.presentation.components.HoursSliderComponent
import com.meyrforge.polarsync.feature_sleep.presentation.components.QuestionWithSegmentedButtonComponent
import com.meyrforge.polarsync.feature_sleep.presentation.components.WentToSleepClockComponent
import com.meyrforge.polarsync.ui.shared.ButtonComponent
import com.meyrforge.polarsync.ui.shared.DateComponent
import com.meyrforge.polarsync.ui.shared.PolyTalkItem
import com.meyrforge.polarsync.ui.shared.TopSemicircleItem
import com.meyrforge.polarsync.ui.theme.DeepPurple
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlin.math.absoluteValue

@Preview
@Composable
fun SleepTrackerScreen(viewModel: SleepTrackerViewModel = hiltViewModel()) {
    val sliderPosition: Float by viewModel.sliderPosition.observeAsState(0f)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepPurple)
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
        item { QuestionWithSegmentedButtonComponent("Tuviste pensamientos negativos?") }
        item { QuestionWithSegmentedButtonComponent("Estuviste ansioso antes de dormir?") }
        item { QuestionWithSegmentedButtonComponent("Dormiste de corrido?") }
        item { AddNotesComponent() }
        item {
            Box(modifier = Modifier.padding(15.dp).padding(bottom = 20.dp)) {
                ButtonComponent("Guardar") {

                }
            }
        }

    }
}