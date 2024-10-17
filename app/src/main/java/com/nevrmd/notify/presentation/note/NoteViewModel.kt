package com.nevrmd.notify.presentation.note

import androidx.lifecycle.viewModelScope
import com.nevrmd.notify.data.NoteRepository
import com.nevrmd.notify.domain.NoteEntity
import com.nevrmd.notify.presentation.BaseViewModel
import kotlinx.coroutines.launch

class NoteViewModel(private val repository: NoteRepository): BaseViewModel<NoteState>(
    initialState = NoteState()
) {

    fun onSaveButtonClick(title: String, body: String) = viewModelScope.launch {
        val note = NoteEntity(id = state.id, title = title, body = body)
        if (state.isEdited) insert(note) else update(note)
    }

    fun saveArgs(args: NoteFragmentArgs) {
        updateState {
            state.copy(
                id = args.id.takeIf { args.id != -1 } ?: 0,
                title = args.title,
                description = args.body,
                isEdited = args.id == -1
            )
        }
    }

    fun delete(note: NoteEntity) = viewModelScope.launch {
        repository.delete(note)
    }

    private suspend fun insert(note: NoteEntity) {
        repository.insert(note)
    }

    private suspend fun update(note: NoteEntity) {
        repository.update(note)
    }
}