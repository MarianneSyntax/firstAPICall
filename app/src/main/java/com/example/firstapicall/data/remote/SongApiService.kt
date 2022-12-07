package com.example.firstapicall.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

// die Website, von der wir alle unsere Daten holen wollen
const val BASE_URL = "https://itunes.apple.com"

// speichert in der Variable moshi einen moshi Builder, der Json (Sprache der Antwort von der Website) in Kotlin konvertiert
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

// speichert in der Variable retrofit einen Converter mit unserem moshi Builder speziell für unsere Base URL
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).build()

// interfaces sind dazu da, um Funktionen zur Verfuügung zu stellen
interface SongApiService {

}

// damit unsere App den SongApiService verwenden kann legen wir eine Instanz des SongApiService namens SearchApi an,
// die in der ganzen App verfügbar ist. Wenn wir also Methoden aus dem Interface nutzen wollen, machen wir das über dieses Objekt.
object SearchApi {
    val retrofitService: SongApiService by lazy {
        retrofit.create(SongApiService::class.java)
    }
}