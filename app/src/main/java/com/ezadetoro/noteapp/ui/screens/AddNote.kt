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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.ezadetoro.noteapp.viewmodel.NoteViewModel

@Composable
fun AddNoteScreen(navController: NavHostController) {
    val viewModel: NoteViewModel = hiltViewModel()

    var content by rememberSaveable { mutableStateOf("") }
    var title by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = title, onValueChange = { title = it }, label = { Text("Title of Note") })
        TextField(value = content, onValueChange = { content = it }, label = { Text("Content of the Note") })

        Button(onClick = {
                viewModel.addNote(title = title, content = content)
                navController.popBackStack()
        }) {
            Text("Save Note")
        }
    }
}