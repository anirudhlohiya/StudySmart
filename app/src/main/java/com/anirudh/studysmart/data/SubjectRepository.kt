package com.anirudh.studysmart.data

import androidx.compose.ui.graphics.Color
import com.anirudh.studysmart.data.local.SubjectDao
import com.anirudh.studysmart.data.local.SubjectEntity
import com.anirudh.studysmart.domain.model.Subject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import javax.inject.Inject

class SubjectRepository @Inject constructor(
    private val subjectDao: SubjectDao
) {
    private val json = Json { ignoreUnknownKeys = true }

    private fun Subject.toEntity() = SubjectEntity(
        name = name,
        goalHours = goalHours,
        colorsJson = json.encodeToString(colors.map { it.value }),
        subjectId = subjectId
    )

    private fun SubjectEntity.toDomain() = Subject(
        name = name,
        goalHours = goalHours,
        colors = json.decodeFromString<List<Long>>(colorsJson).map { Color(it) },
        subjectId = subjectId
    )

    suspend fun upsertSubject(subject: Subject) {
        subjectDao.upsertSubject(subject.toEntity())
    }

    fun getAllSubjects(): Flow<List<Subject>> {
        return subjectDao.getAllSubjects().map { list -> list.map { it.toDomain() } }
    }

    // Add similar conversion for all other DAO operations
    suspend fun getSubjectById(subjectId: Int): Subject? {
        return subjectDao.getSubjectById(subjectId)?.toDomain()
    }

    suspend fun deleteSubject(subjectId: Int) {
        subjectDao.deleteSubject(subjectId)
    }

    fun getTotalSubjectCount(): Flow<Int> {
        return subjectDao.getTotalSubjectCount()
    }

    fun getTotalGoalHours(): Flow<Float> {
        return subjectDao.getTotalGoalHours()
    }
}