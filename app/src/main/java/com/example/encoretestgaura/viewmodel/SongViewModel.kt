package com.example.encoretestgaura.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.encoretestgaura.data.local.DatabaseBuilder
import com.example.encoretestgaura.data.local.DatabaseProvider
import com.example.encoretestgaura.data.local.table.Song
import com.example.encoretestgaura.data.repositories.DatabaseRepository
import com.example.rangtechnologygauravassignment.repositories.SongRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.internal.filterList

class SongViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = SongRepository()

    private val database = DatabaseBuilder.getInstance(application)
    var allSongs : LiveData<List<Song>>  = MutableLiveData()
    fun getSongs(limit : Int = 20) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val feed = repository.getSongsList(limit.toString())
                if (feed?.itemList?.isNotEmpty() == true) {
                    val songs = feed.itemList?.map { entry ->
                        Song(
                            id = entry.id?.imId ?: "0",
                            name = entry.name ?: "",
                            artist = entry.artist ?: "",
                            price = entry.price ?: "",
                            imageUrl = entry.imImage?.filterList { this.height == "170" }
                                ?.firstOrNull()?.content,
                            date = entry.imReleaseDate?.label,
                            rights = entry.rights
                        )
                    }

                    if (songs != null) {
                        saveSongs(songs)
                    }
                }
            }catch (e: Exception){
                e.printStackTrace()
            }


        }
    }

    private fun saveSongs(songs : List<Song>) {
        viewModelScope.launch(Dispatchers.IO) {
            database.songDao().saveSongList(songs)
        }
    }

    fun getSongsFromDb() {
        allSongs =   database.songDao().getAllSongs().asLiveData()
    }
}