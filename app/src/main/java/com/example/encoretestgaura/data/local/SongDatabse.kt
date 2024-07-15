package com.example.encoretestgaura.data.local
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.encoretestgaura.data.network.AppDatabase

object DatabaseProvider {
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "song_database"
        ).build()
    }
}