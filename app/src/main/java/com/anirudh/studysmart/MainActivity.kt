package com.anirudh.studysmart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.anirudh.studysmart.domain.model.Session
import com.anirudh.studysmart.domain.model.Subject
import com.anirudh.studysmart.domain.model.Task
import com.anirudh.studysmart.presentation.Subject.SubjectScreen
import com.anirudh.studysmart.presentation.dashboard.DashboardScreen
import com.anirudh.studysmart.presentation.theme.StudySmartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudySmartTheme {
                SubjectScreen()
            }
        }
    }
}


val subjects = listOf(
    Subject("Math", 10f, Subject.subjectCardColors[0],0),
    Subject("Science", 10f, Subject.subjectCardColors[1],0),
    Subject("English", 10f, Subject.subjectCardColors[2],0),
    Subject("Computer", 10f, Subject.subjectCardColors[3],0),
    Subject("History", 10f, Subject.subjectCardColors[4],0),
)

val tasks = listOf(
    Task(
        title = "Complete Math Assignment",
        description = "Solve all the problems in chapter 5",
        dueDate = 0L,
        priority = 2,
        relatedToSubject = "",
        isComplete = false,
        taskSubjectId = 0,
        taskId = 0
    ),
    Task(
        title = "Do HomeWork",
        description = "Solve all the problems in chapter 5",
        dueDate = 0L,
        priority = 1,
        relatedToSubject = "",
        isComplete = true,
        taskSubjectId = 0,
        taskId = 0
    ),
    Task(
        title = "Make Project",
        description = "Solve all the problems in chapter 5",
        dueDate = 0L,
        priority = 0,
        relatedToSubject = "",
        isComplete = false,
        taskSubjectId = 0,
        taskId = 0
    ),
    Task(
        title = "Buy Groceries",
        description = "Solve all the problems in chapter 5",
        dueDate = 0L,
        priority = 1,
        relatedToSubject = "",
        isComplete = false,
        taskSubjectId = 0,
        taskId = 0
    ),
    Task(
        title = "Watch Movie",
        description = "Solve all the problems in chapter 5",
        dueDate = 0L,
        priority = 2,
        relatedToSubject = "",
        isComplete = false,
        taskSubjectId = 0,
        taskId = 0
    )
)

val sessions = listOf(
    Session(
        relationToSubject = "English",
        date = 0L,
        duration = 2,
        sessionSubjectId = 0,
        sessionId = 0,
    ),
    Session(
        relationToSubject = "Math",
        date = 0L,
        duration = 1,
        sessionSubjectId = 0,
        sessionId = 0,
    ),
    Session(
        relationToSubject = "Science",
        date = 0L,
        duration = 3,
        sessionSubjectId = 0,
        sessionId = 0,
    ),
    Session(
        relationToSubject = "Computer",
        date = 0L,
        duration = 2,
        sessionSubjectId = 0,
        sessionId = 0,
    ),
)