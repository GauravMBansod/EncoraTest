package com.example.encoretestgaura.data.local.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Song(
    @PrimaryKey
    val id: String ,
    @ColumnInfo(name = "name")
    var name: String? = null,
    @ColumnInfo(name = "artist")
    var artist: String? = null,
    @ColumnInfo(name = "price")
    var price: String? = null,
    @ColumnInfo(name = "releaseDate")
    var date: String? = null,
    @ColumnInfo(name= "image")
    var imageUrl: String? = null,
    @ColumnInfo(name = "rights")
    var rights: String? = null,
)