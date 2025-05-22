package com.ezadetoro.noteapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ezadetoro.noteapp.ui.componets.NoteCard
import com.ezadetoro.noteapp.ui.componets.NoteTopAppBar
import com.ezadetoro.noteapp.viewmodel.NoteViewModel



@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    val viewModel: NoteViewModel = hiltViewModel()
    val notesList = viewModel.allNotes

    Column(modifier = modifier.padding(12.dp)) {
        NoteTopAppBar {
            navController.navigate("add_note")
        }

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(200.dp),
                verticalItemSpacing = 4.dp,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.fillMaxSize(),
                content = {
                    items(notesList) { note ->
                        NoteCard(
                            noteTitle = note.title,
                            noteBody = note.noteContent,
                            deleteButtonClicked = {
                                viewModel.deleteNote(note.id)
                            },
                            editButtonClicked = {
                                navController.navigate("edit_note/${note.id}")
                            }
                        )
                    }
                }
            )
    }
}

//@Composable
//fun HomeScreen(navController: NavHostController, modifier: Modifier = Modifier) {
//
//    val viewModel: NoteViewModel = hiltViewModel()
//
////    val query by remember { mutableStateOf("") }
//
//    val notesList by remember { derivedStateOf { viewModel.notes } }
//
//
//    Column(
//        modifier = modifier.padding(12.dp)
//    ) {
//
//        Spacer(modifier = Modifier.height(20.dp))
//        NoteTopAppBar(
//            addNoteNav = {
//                navController.navigate("add_note")
//            }
//        )
//
////        SearchBar(
////            query = query,
////            onQueryChange = {viewModel.onSearch(query)},
////            onSearch = {viewModel.onSearch(query)},
////        )
//
//        LazyVerticalStaggeredGrid(
//            columns = StaggeredGridCells.Adaptive(200.dp),
//            verticalItemSpacing = 4.dp,
//            horizontalArrangement = Arrangement.spacedBy(4.dp),
//            modifier = Modifier.fillMaxSize(),
//            content = {
//                items(notesList) { note ->
//                    NoteCard(
//                        noteTitle = note.title,
//                        noteBody = note.noteContent,
//                        deleteButtonClicked = {
//                            viewModel.deleteNote(note.id)
//                        },
//                        editButtonClicked = {
//                            navController.navigate("edit_note/${note.id}")
//                        }
//                    )
//                }
//            }
//        )
//    }
//
//
//}