package com.miguelvilla.anotationmiguelVila.ui.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Upsert
    suspend fun addNote(note: NoteEntity)

    @Query("DELETE FROM note WHERE id = :id")
    suspend fun deleteNote(id: Int)

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id: Int): NoteEntity


}