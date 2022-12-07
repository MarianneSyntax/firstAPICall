package com.example.firstapicall.data

import com.example.firstapicall.data.model.Song

class Repository {
    fun loadSongs(): List<Song>{
        return listOf(
            Song("Rihanna", "Call me by your name"),
            Song("Rihanna", "SOS"),
            Song("Rihanna", "S&M"),
            Song("Rihanna", "Pon de Replay"),
            Song("Rihanna", "California King Bed"),

        )
    }
}