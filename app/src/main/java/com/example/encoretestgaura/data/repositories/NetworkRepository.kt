package com.example.rangtechnologygauravassignment.repositories

import com.example.rangtechnologygauravassignment.retrofit.ApiClient
import com.example.rangtechnologygauravassignment.retrofit.apiservice.SongService

class SongRepository {

    private val songService = ApiClient.retrofit.create(SongService::class.java)

    suspend fun getSongsList(limit: String) = songService.getSongsList(limit)

}