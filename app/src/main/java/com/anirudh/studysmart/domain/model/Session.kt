package com.anirudh.studysmart.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.time.Duration

@Entity
data class Session(
    val sessionSubjectId: Int,
    val relationToSubject: String,
    val date: Long,
    val duration: Long,
    @PrimaryKey(autoGenerate = true)
    val sessionId: Int? = null
)
