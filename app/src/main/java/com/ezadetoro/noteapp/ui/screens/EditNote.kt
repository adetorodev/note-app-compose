package com.ezadetoro.noteapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ezadetoro.noteapp.viewmodel.NoteViewModel

@Composable
fun EditNoteScreen(navController: NavHostController, noteId: Int) {

    val viewModel: NoteViewModel = hiltViewModel()
    val note = viewModel.notes.find { it.id == noteId }

    var content by rememberSaveable { mutableStateOf(note?.noteContent ?: "") }

    Column(modifier = Modifier.padding(16.dp)) {

        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = content, onValueChange = { content = it }, label = { Text("Edit Note") })

        Button(onClick = {
            note?.copy(noteContent = content)?.let { updatedNote ->
                viewModel.updateNote(updatedNote)
                navController.popBackStack()
            }
        }) {

            Text("Save Changes")
        }
    }
}