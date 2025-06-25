package com.anirudh.studysmart.presentation.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun DeleteDialogPreview() {
    DeleteDialog(
        isOpen = true,
        title = "Delete Subject",
        onDismissRequest = {},
        bodyText = "Are you sure you want to delete this subject? This action cannot be undone.",
        onConformButtonClick = {}
    )
}

@Composable
fun DeleteDialog(
    isOpen: Boolean,
    title: String,
    bodyText: String,
    onDismissRequest: () -> Unit,
    onConformButtonClick: () -> Unit
) {
    if (isOpen){
        AlertDialog(
            onDismissRequest = onDismissRequest,
            title = { Text(text = title) },
            text = { Text(text = bodyText) },
            dismissButton = {
                TextButton(onClick = onDismissRequest) {
                    Text(text = "Cancel")
                }
            },
            confirmButton = {
                TextButton(onClick = onConformButtonClick) {
                    Text(text = "Delete")
                }
            }
        )
    }
}