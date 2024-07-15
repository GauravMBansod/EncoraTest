package com.example.encoretestgaura.data.local
import android.content.Context
import androidx.room.Room
import com.example.encoretestgaura.data.network.AppDatabase

object DatabaseBuilder {
    @Volatile
    private var INSTANCE: AppDatabase? = null
    fun getInstance(context: Context): AppDatabase {
        if (INSTANCE == null) {
            synchronized(AppDatabase::class) {
                INSTANCE = provideDatabase(context)
            }
        }
        return INSTANCE!!
    }

    private fun provideDatabase(context: Context): AppDatabase =  Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "song_database"
            ).build()
}