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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meyrforge.polarsync.ui.theme.SoftBlueLavander
import com.meyrforge.polarsync.ui.theme.orange
import com.meyrforge.polarsync.ui.theme.petroleum
import com.meyrforge.polarsync.ui.theme.pink
import com.meyrforge.polarsync.ui.theme.purple

object Level {
    const val NULO = "Nulo"
    const val LEVE = "Leve"
    const val MODERADO = "Moderado"
    const val ALTO = "Alto"
    const val SEVERO = "Severo"
}


@Preview(showBackground = true, backgroundColor = 0xFF27252C)
@Composable
fun MoodSelectionPreview() {
    Column {
        MoodSelectionComponent(pink, "Ánimo más elevado")
        MoodSelectionComponent(orange, "Ánimo más irritable")
        MoodSelectionComponent(purple, "Ánimo más ansioso")
        MoodSelectionComponent(petroleum, "Ánimo más depresivo")
    }
}

@Composable
fun MoodSelectionComponent(color: Color, title: String) {
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
                    .clickable { selectedBox = Level.NULO }
            ) { MoodItemComponent(0.2f, color, Level.NULO, selectedBox == Level.NULO) }
            Box(
                modifier = Modifier
                    .weight(2f)
                    .padding(5.dp)
                    .clickable { selectedBox = Level.LEVE }
            ) { MoodItemComponent(0.4f, color, Level.LEVE, selectedBox == Level.LEVE) }
            Box(
                modifier = Modifier
                    .weight(2f)
                    .padding(5.dp)
                    .clickable { selectedBox = Level.MODERADO }
            ) { MoodItemComponent(0.6f, color, Level.MODERADO, selectedBox == Level.MODERADO) }
            Box(
                modifier = Modifier
                    .weight(2f)
                    .padding(5.dp)
                    .clickable { selectedBox = Level.ALTO }
            ) { MoodItemComponent(0.8f, color, Level.ALTO, selectedBox == Level.ALTO) }
            Box(
                modifier = Modifier
                    .weight(2f)
                    .padding(5.dp)
                    .clickable { selectedBox = Level.SEVERO }
            ) { MoodItemComponent(1f, color, Level.SEVERO, selectedBox == Level.SEVERO) }
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