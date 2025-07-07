package com.anirudh.studysmart.di

import com.anirudh.studysmart.data.repository.SessionRepositoryImpl
import com.anirudh.studysmart.data.repository.SubjectRepositoryImpl
import com.anirudh.studysmart.data.repository.TaskRepositoryImpl
import com.anirudh.studysmart.domain.repository.SessionRepository
import com.anirudh.studysmart.domain.repository.SubjectRepository
import com.anirudh.studysmart.domain.repository.TaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindTaskRepository(
        impl: SubjectRepositoryImpl
    ): SubjectRepository

    @Singleton
    @Binds
    abstract fun bindTaskRepository(
        impl: TaskRepositoryImpl
    ): TaskRepository

    @Singleton
    @Binds
    abstract fun bindSessionRepository(
        impl: SessionRepositoryImpl
    ): SessionRepository
}