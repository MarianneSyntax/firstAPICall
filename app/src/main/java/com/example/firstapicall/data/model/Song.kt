package com.example.firstapicall.data.model
import com.squareup.moshi.Json


data class Song(
   // Variablen eigene Namen geben: @Jason(name = "alterName") über die neue Variablendeklaration
    @Json(name = "artistName")
    val artist: String,

    @Json(name = "trackName")
    val track: String
)