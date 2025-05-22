package com.ezadetoro.noteapp.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ezadetoro.noteapp.Data.Note
import com.ezadetoro.noteapp.Data.NoteEntity
import com.ezadetoro.noteapp.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    var notes: List<NoteEntity> by mutableStateOf(emptyList())
        private set

    init {
        viewModelScope.launch {
            repository.getNotes().collectLatest { notesList ->
                notes = notesList
                Log.d("ViewModel", "Received ${notesList.size} notes")
            }
        }
    }

    fun addNote(title: String, content: String) {
        viewModelScope.launch {
            val now = LocalDate.now()
            val note = NoteEntity(
                title = title,
                noteContent = content,
                createAt = now
            )
            repository.addNote(note)
        }
    }

    fun deleteNote(id: Int) {
        viewModelScope.launch {
            repository.deleteNote(id)
        }
    }

    fun updateNote(note: NoteEntity) {
        viewModelScope.launch {
            repository.update(note)
        }
    }

    fun onSearch(query: String) {
        // Make sure this returns a flow and updates `notes` just like loadNotes()
        viewModelScope.launch {
            repository.searchNote(query).collectLatest {
                notes = it
            }
        }
    }
}
