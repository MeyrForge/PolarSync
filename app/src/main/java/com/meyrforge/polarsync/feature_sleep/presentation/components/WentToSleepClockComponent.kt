package com.meyrforge.polarsync.feature_sleep.presentation.components

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meyrforge.polarsync.feature_sleep.presentation.SleepTrackerViewModel
import com.meyrforge.polarsync.ui.theme.DeepPurple
import com.meyrforge.polarsync.ui.theme.PowderedPink
import com.meyrforge.polarsync.ui.theme.SoftBlueLavander
import java.time.LocalTime
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun WentToSleepClockComponent(viewModel: SleepTrackerViewModel = hiltViewModel()) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    val timeSelected: String by viewModel.timeSelected.observeAsState("")
    val timeState = rememberTimePickerState(is24Hour = false)
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "A qué hora te fuiste a dormir?",
            fontSize = 18.sp,
            color = PowderedPink,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            textAlign = TextAlign.Start
        )
        TimeInput(
            state = timeState,
            colors = TimePickerDefaults.colors(
                timeSelectorSelectedContentColor = DeepPurple,
                timeSelectorSelectedContainerColor = PowderedPink,
                periodSelectorSelectedContainerColor = SoftBlueLavander
            ),
            modifier = Modifier.focusRequester(focusRequester)
        )
        LaunchedEffect(Unit) {
            focusManager.clearFocus(force = true)
        }
        LaunchedEffect(timeState.hour, timeState.minute) {
            viewModel.onTimeSelectedChange(formattedTime(timeState.hour, timeState.minute))
            Log.i("hora", timeSelected)
        }
    }

}

@RequiresApi(Build.VERSION_CODES.O)
fun formattedTime(hour: Int, minute: Int): String {
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    val time = LocalTime.of(hour, minute).format(formatter)
    return time
}