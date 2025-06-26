package com.anirudh.studysmart.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anirudh.studysmart.R
import com.anirudh.studysmart.domain.model.Session
import com.anirudh.studysmart.domain.model.Subject
import com.anirudh.studysmart.domain.model.Task
import com.anirudh.studysmart.presentation.components.AddSubjectDialog
import com.anirudh.studysmart.presentation.components.CountCard
import com.anirudh.studysmart.presentation.components.DeleteDialog
import com.anirudh.studysmart.presentation.components.SubjectCard
import com.anirudh.studysmart.presentation.components.studySessionsList
import com.anirudh.studysmart.presentation.components.tasksList
import com.anirudh.studysmart.sessions
import com.anirudh.studysmart.subjects
import com.anirudh.studysmart.tasks

@Preview
@Composable
fun DashboardScreen() {

    var isAddSubjectDialogOpen by rememberSaveable { mutableStateOf(false) }
    var isDeleteSessionDialogOpen by rememberSaveable { mutableStateOf(false) }

    var subjectName by remember { mutableStateOf("") }
    var goalHours by remember { mutableStateOf("") }
    var selectedColor by remember { mutableStateOf(Subject.subjectCardColors.random()) }

    AddSubjectDialog(
        isOpen = isAddSubjectDialogOpen,
        selectedColors = selectedColor,
        subjectName = subjectName,
        goalHours = goalHours,
        onColorChange = {selectedColor = it },
        onSubjectNameChange = {subjectName = it},
        onGoalHoursChange = {goalHours = it},
        onDismissRequest = { isAddSubjectDialogOpen = false },
        onConformButtonClick = { isAddSubjectDialogOpen = false }
    )

    DeleteDialog(
        isOpen = isDeleteSessionDialogOpen,
        title = "Delete Session?",
        onDismissRequest = {isDeleteSessionDialogOpen = false},
        bodyText = "Are you sure you want to delete this subject? This will reduce your study " +
                "hours. This action cannot be undone",
        onConformButtonClick = {isDeleteSessionDialogOpen = false}
    )

    Scaffold(
        topBar = { DashboardScreenTopBar() }
    ) { paddingValues ->
        // Content of the Dashboard Screen
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                CountCardsSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    subjectCount = 5,
                    studyHours = "10",
                    goalStudyHours = "20"
                )
            }
            item {
                SubjectCardsSection(
                    modifier = Modifier.fillMaxWidth(),
                    subjectList = subjects,
                    onAddIconClicked = { isAddSubjectDialogOpen = true }
                )
            }
            item {
                Button(
                    onClick = { /* Handle button click */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 48.dp,  vertical = 20.dp)
                ) {
                    Text(text = "Start Study Session")
                }
            }
            tasksList(
                sectionTitle = "Upcoming Tasks",
                emptyListText = "You don't have any upcoming tasks.\n " +
                        "Click the + button to add the new task.",
                tasks = tasks,
                onCheckBoxClick = {},
                onTaskCardClick = {}
            )
            item{
                Spacer(modifier = Modifier.height(20.dp))
            }
            studySessionsList(
                sectionTitle = "Recent Study Sessions",
                emptyListText = "You don't have any recent study sessions.\n " +
                        "Start a study session to begin recording your progress.",
                sessions = sessions,
                onDeleteIconClick = {
                    println("Delete Icon Clicked")
                    isDeleteSessionDialogOpen = true },
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DashboardScreenTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Study Smart",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    )
}

@Composable
private fun CountCardsSection(
    modifier: Modifier,
    subjectCount: Int,
    studyHours: String,
    goalStudyHours: String
){
    Row(modifier = modifier) {
        CountCard(
            modifier = Modifier.weight(1f),
            headingText = "Subject Count",
            count = "$subjectCount"
        )
        Spacer(modifier = Modifier.width(10.dp))
        CountCard(
            modifier = Modifier.weight(1f),
            headingText = "Study Hours",
            count = studyHours
        )
        Spacer(modifier = Modifier.width(10.dp))
        CountCard(
            modifier = Modifier.weight(1f),
            headingText = "Goal Study Hours",
            count = goalStudyHours
        )
    }
}

@Composable
private fun SubjectCardsSection(
    modifier: Modifier,
    subjectList: List<Subject>,
    emptyListText: String = "You don't have any subjects added yet.\n click the + button to add the new subject.",
    onAddIconClicked: () -> Unit
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment =  Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Subjects",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 12.dp)
            )
            IconButton(onClick = onAddIconClicked) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Subject"
                )
            }
        }
        if (subjectList.isEmpty()){
            Image(
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(R.drawable.img_books),
                contentDescription = emptyListText
            )
            Text(
                modifier = modifier.fillMaxWidth(),
                text = emptyListText,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
        ) {
            items(subjectList) { subject ->
                SubjectCard(
                    subjectName = subject.name,
                    gradientColors = subject.colors,
                    onClick = {}
                )
            }
        }
    }
}