package com.example.encoretestgaura.data.network

import com.example.encoretestgaura.data.local.table.Song
import com.example.encoretestgaura.data.local.dao.SongDao
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Song::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun songDao(): SongDao
}