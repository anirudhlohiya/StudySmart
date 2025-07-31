package com.anirudh.studysmart.presentation.dashboard

import androidx.lifecycle.ViewModel
import com.anirudh.studysmart.domain.repository.SubjectRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private  val subjectRepository: SubjectRepository
): ViewModel() {
}