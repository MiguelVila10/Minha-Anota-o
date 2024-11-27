package com.miguelvilla.anotationmiguelVila.ui.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("note")
data class NoteEntity(
    @PrimaryKey(true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val date: String,
)
