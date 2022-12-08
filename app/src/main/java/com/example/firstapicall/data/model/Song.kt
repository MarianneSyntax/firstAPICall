package com.example.firstapicall.data.model
import android.net.Uri
import com.squareup.moshi.Json


data class Song(
   // Variablen eigene Namen geben: @Jason(name = "alterName") über die neue Variablendeklaration
    @Json(name = "artistName")
    val artist: String,

    @Json(name = "trackName")
    val track: String,

    @Json(name = "artworkUrl100")
    val artResource: String,

    @Json(name = "trackId")
    val trackId: Int
)