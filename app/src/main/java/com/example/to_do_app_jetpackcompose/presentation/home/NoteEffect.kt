package com.example.to_do_app_jetpackcompose.presentation.home

sealed class NoteEffect {
    data class OnShowError(val message: String) : NoteEffect()
    data class OnShowSuccess(val message : String) : NoteEffect()
    data class OnShowUndo (val message : String) : NoteEffect()
}