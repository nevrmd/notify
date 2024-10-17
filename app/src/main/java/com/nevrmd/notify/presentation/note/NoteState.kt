package com.nevrmd.notify.presentation.note

data class NoteState(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val isEdited: Boolean = false,
)