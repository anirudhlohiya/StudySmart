package com.anirudh.studysmart.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.anirudh.studysmart.domain.model.Subject
import kotlinx.coroutines.flow.Flow

@Dao
interface SubjectDao {

    @Upsert
    suspend fun upsertSubject(subject: SubjectEntity)

    @Query("SELECT COUNT(*) FROM Subject")
    fun getTotalSubjectCount(): Flow<Int>

    @Query("SELECT SUM(goalHours) FROM Subject")
    fun getTotalGoalHours(): Flow<Float>

    @Query("SELECT * FROM SUBJECT WHERE subjectId = :subjectId")
    suspend fun getSubjectById(subjectId: Int): Subject?

    @Query("DELETE FROM SUBJECT WHERE subjectId = :subject")
    suspend fun deleteSubject(subject: Int)

    @Query("SELECT * FROM SUBJECT")
    fun getAllSubjects(): Flow<List<Subject>>

}