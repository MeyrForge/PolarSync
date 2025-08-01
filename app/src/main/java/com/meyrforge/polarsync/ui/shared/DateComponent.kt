package com.meyrforge.polarsync.ui.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meyrforge.polarsync.feature_sleep.presentation.utils.getDayOfWeek
import com.meyrforge.polarsync.feature_sleep.presentation.utils.getMonth
import com.meyrforge.polarsync.ui.theme.PowderedPink
import java.util.Calendar

@Composable
fun DateComponent(){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(currentDay(), fontSize = 24.sp, color = PowderedPink)
        }
        HorizontalDivider(
            thickness = 2.dp,
            color = PowderedPink,
            modifier = Modifier.padding(bottom = 16.dp)
        )
}

private fun currentDay(): String {
    val calendar = Calendar.getInstance()
    return "${getDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK))}," +
            " ${calendar.get(Calendar.DAY_OF_MONTH)} de" +
            " ${getMonth(calendar.get(Calendar.MONTH))}"
}