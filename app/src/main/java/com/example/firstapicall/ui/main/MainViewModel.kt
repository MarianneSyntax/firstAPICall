package com.example.firstapicall.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapicall.data.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = Repository()

    val songs = repository.songs

    fun search(term: String){
        // hier müssen wir eine Coroutine launchen, weil loadSongs (und das darin aufgerufene getResponse) beides suspend-functions sind,
        viewModelScope.launch {
            repository.loadSongs(term)
        }

    }
}