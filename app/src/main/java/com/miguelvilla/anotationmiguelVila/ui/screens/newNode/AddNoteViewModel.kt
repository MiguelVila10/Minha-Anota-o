package com.miguelvilla.anotationmiguelVila.ui.screens.newNode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miguelvilla.anotationmiguelVila.ui.database.NoteDao
import com.miguelvilla.anotationmiguelVila.ui.database.NoteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate

class AddNoteViewModel(
    private val noteDao: NoteDao
) : ViewModel() {

    fun addNote(title: String, description: String) {
        viewModelScope.launch (Dispatchers.IO){
            noteDao.addNote(
                NoteEntity(
                    title = title,
                    description = description,
                    date = LocalDate.now().toString()
                )
            )
        }
    }

}