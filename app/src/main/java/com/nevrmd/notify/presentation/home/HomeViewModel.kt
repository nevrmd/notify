package com.nevrmd.notify.presentation.home

import com.nevrmd.notify.data.NoteRepository
import com.nevrmd.notify.presentation.BaseViewModel

class HomeViewModel(private val repository: NoteRepository): BaseViewModel<HomeState>(
    initialState = HomeState()
) {

    fun getNotes() = repository.notes
}