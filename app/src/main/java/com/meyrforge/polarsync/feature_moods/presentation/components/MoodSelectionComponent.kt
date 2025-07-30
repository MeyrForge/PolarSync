package com.meyrforge.polarsync.feature_moods.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.NoteAdd
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meyrforge.polarsync.common.MoodLevel
import com.meyrforge.polarsync.ui.theme.SoftBlueLavander

@Composable
fun MoodSelectionComponent(selectedMood: String, color: Color, title: String, onMoodChosen: (String) -> Unit) {
    var selectedBox by remember { mutableStateOf("") }
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                title,
                color = color,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Icon(
                Icons.AutoMirrored.Outlined.NoteAdd,
                contentDescription = "Add notes",
                tint = color,
                modifier = Modifier.size(30.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .border(2.dp, color = color, shape = RoundedCornerShape(10.dp))
                .padding(5.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(2f)
                    .padding(5.dp)
                    .clickable {
                        selectedBox = MoodLevel.NULO
                        onMoodChosen(MoodLevel.NULO)
                    }
            ) { MoodItemComponent(0.2f, color, MoodLevel.NULO,
                if(selectedMood == "") selectedBox == MoodLevel.NULO else selectedMood == MoodLevel.NULO) }
            Box(
                modifier = Modifier
                    .weight(2f)
                    .padding(5.dp)
                    .clickable {
                        selectedBox = MoodLevel.LEVE
                        onMoodChosen(MoodLevel.LEVE)
                    }
            ) { MoodItemComponent(0.4f, color, MoodLevel.LEVE,
                if(selectedMood == "") selectedBox == MoodLevel.LEVE else selectedMood == MoodLevel.LEVE) }
            Box(
                modifier = Modifier
                    .weight(2f)
                    .padding(5.dp)
                    .clickable {
                        selectedBox = MoodLevel.MODERADO
                        onMoodChosen(MoodLevel.MODERADO)
                    }
            ) { MoodItemComponent(0.6f, color, MoodLevel.MODERADO,
                if(selectedMood == "") selectedBox == MoodLevel.MODERADO else selectedMood == MoodLevel.MODERADO) }
            Box(
                modifier = Modifier
                    .weight(2f)
                    .padding(5.dp)
                    .clickable {
                        selectedBox = MoodLevel.ALTO
                        onMoodChosen(MoodLevel.ALTO)
                    }
            ) { MoodItemComponent(0.8f, color, MoodLevel.ALTO,
                if(selectedMood == "") selectedBox == MoodLevel.ALTO else selectedMood == MoodLevel.ALTO) }
            Box(
                modifier = Modifier
                    .weight(2f)
                    .padding(5.dp)
                    .clickable {
                        selectedBox = MoodLevel.SEVERO
                        onMoodChosen(MoodLevel.SEVERO)
                    }
            ) { MoodItemComponent(1f, color, MoodLevel.SEVERO,
                if(selectedMood == "") selectedBox == MoodLevel.SEVERO else selectedMood == MoodLevel.SEVERO) }
        }
    }
}

@Composable
fun MoodItemComponent(alpha: Float, color: Color, text: String, chosen: Boolean) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.7f)
                .background(color = color.copy(alpha = alpha))
                .border(4.dp, color = if (chosen) SoftBlueLavander else Color.Transparent)
        )
        Text(
            text,
            color = color,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
