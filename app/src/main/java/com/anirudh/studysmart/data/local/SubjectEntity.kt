package com.anirudh.studysmart.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subjects")
data class SubjectEntity(
    val name: String,
    val goalHours: Float,
    val colorsJson: String,  // Will store the serialized colors
    @PrimaryKey(autoGenerate = true)
    val subjectId: Int? = null
)