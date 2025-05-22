package com.ezadetoro.noteapp.ui.componets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout

@Composable
fun NoteTopAppBar(
    addNoteNav: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,

    ) {
        Text(text = "Note App",
            style = MaterialTheme.typography.titleLarge
        )
        Button(onClick = addNoteNav ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add Note")
        }
    }


}