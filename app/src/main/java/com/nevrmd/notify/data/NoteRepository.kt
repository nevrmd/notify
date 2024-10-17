package com.nevrmd.notify.data

import com.nevrmd.notify.domain.NoteEntity
import com.nevrmd.notify.data.database.NoteDao

class NoteRepository(private val dao: NoteDao) {
    val notes = dao.getAllNotes()

    suspend fun insert(note: NoteEntity): Long {
        return dao.insertNote(note)
    }

    suspend fun update(note: NoteEntity) {
        return dao.updateNote(note)
    }

    suspend fun delete(note: NoteEntity) {
        return dao.deleteNote(note)
    }
}