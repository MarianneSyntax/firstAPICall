package com.example.firstapicall.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.firstapicall.data.model.Response
import com.example.firstapicall.data.model.Song
import com.example.firstapicall.data.remote.SearchApi

class Repository {

    private val _songs = MutableLiveData<List<Song>>()

    val songs: LiveData<List<Song>>
        get() = _songs

    suspend fun loadSongs(term: String){
        // hier werden das Objekt und die getResponse Funktion aus dem Interface aufgerufen
        val response: Response = SearchApi.retrofitService.getResponse(term,"music")
        // Ergebnisse der Response in _songs speichern
        _songs.value = response.results
    }
}