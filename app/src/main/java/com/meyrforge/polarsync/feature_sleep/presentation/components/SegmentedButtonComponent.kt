package com.meyrforge.polarsync.feature_sleep.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meyrforge.polarsync.ui.theme.DeepPurple
import com.meyrforge.polarsync.ui.theme.PowderedPink
import com.meyrforge.polarsync.ui.theme.SoftBlueLavander

@Composable
fun SegmentedButtonComponent(
    modifier: Modifier
) {
    var checked by remember { mutableStateOf(false) }
    Switch(
        checked = checked,
        onCheckedChange = { checked = !checked },
        enabled = true,
        thumbContent = if (checked) {
            {
                Text(
                    "SI",
                    fontSize = 10.sp
                )
            }
        } else {
            {
                Text(
                    "NO",
                    fontSize = 10.sp
                )
            }
        },
        colors = SwitchDefaults.colors(
            checkedTrackColor = PowderedPink,
            checkedThumbColor = Color.White,
            checkedIconColor = DeepPurple,
            disabledCheckedTrackColor = Color.Gray,
            disabledUncheckedTrackColor = Color.Gray,
            uncheckedBorderColor = Color.Transparent,
            uncheckedThumbColor = SoftBlueLavander

        ),
        modifier = modifier
    )

}

@Composable
fun QuestionWithSegmentedButtonComponent(text:String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text, fontSize = 16.sp, color = PowderedPink, modifier = Modifier.weight(8f))
        SegmentedButtonComponent(modifier = Modifier.weight(2f))
    }
}