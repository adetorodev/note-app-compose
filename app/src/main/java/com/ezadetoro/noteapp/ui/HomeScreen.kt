package com.ezadetoro.noteapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ezadetoro.noteapp.Data.Note
import com.ezadetoro.noteapp.Data.noteList
import com.ezadetoro.noteapp.ui.componets.NoteCard
import com.ezadetoro.noteapp.ui.componets.NoteTopAppBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    val notesList: List<Note> = noteList
    Column(
        modifier = modifier.padding(12.dp)
    ) {
        NoteTopAppBar()
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(200.dp),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            content = {
                items(notesList) { note ->
                    NoteCard(
                        noteTitle = note.title,
                        noteBody = note.noteContent
                    )
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }


}