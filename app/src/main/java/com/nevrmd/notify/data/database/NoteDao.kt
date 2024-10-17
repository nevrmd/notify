package com.nevrmd.notify.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.nevrmd.notify.domain.NoteEntity

@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(note: NoteEntity): Long

    @Update
    suspend fun updateNote(note: NoteEntity)

    @Delete
    suspend fun deleteNote(note: NoteEntity)

    @Query("SELECT * FROM NoteEntity")
    fun getAllNotes(): LiveData<List<NoteEntity>>
}