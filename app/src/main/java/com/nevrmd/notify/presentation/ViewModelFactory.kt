package com.nevrmd.notify.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.nevrmd.notify.data.NoteRepository
import com.nevrmd.notify.presentation.home.HomeViewModel
import com.nevrmd.notify.presentation.note.NoteViewModel

class ViewModelFactory(private val repository: NoteRepository): ViewModelProvider.Factory {

    @Suppress("Unchecked_Cast")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return when {
            modelClass.isAssignableFrom(NoteViewModel::class.java) -> NoteViewModel(repository) as T
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}