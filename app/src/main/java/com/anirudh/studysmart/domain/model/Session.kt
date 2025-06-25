package com.anirudh.studysmart.domain.model

import kotlin.time.Duration

data class Session(
    val sessionSubjectId: Int,
    val relationToSubject: String,
    val date: Long,
    val duration: Long,
    val sessionId: Int
)
