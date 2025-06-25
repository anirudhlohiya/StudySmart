package com.anirudh.studysmart.util

import androidx.compose.ui.graphics.Color
import com.anirudh.studysmart.presentation.theme.Green
import com.anirudh.studysmart.presentation.theme.Orange
import com.anirudh.studysmart.presentation.theme.Red

enum class Priority(val title: String, val color:Color,val value: Int){
    HIGH("High", Red, 2),
    MEDIUM("Medium", Orange, 1),
    LOW("Low", Green, 0);

    companion object {
        fun fromInt(value: Int) = values().firstOrNull(){it.value == value} ?: MEDIUM
    }
}