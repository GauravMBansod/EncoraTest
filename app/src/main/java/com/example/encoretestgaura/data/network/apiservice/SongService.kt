package com.example.rangtechnologygauravassignment.retrofit.apiservice

import com.example.encoretestgaura.data.model.Feed
import retrofit2.http.GET
import retrofit2.http.Path

interface SongService {
    @GET("WebObjects/MZStoreServices.woa/ws/RSS/topsongs/limit={limit}/xml")
    suspend fun getSongsList(@Path("limit") limit: String): Feed?
}

