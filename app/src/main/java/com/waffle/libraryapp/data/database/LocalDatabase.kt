package com.waffle.libraryapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.waffle.libraryapp.data.dao.BookDao
import com.waffle.libraryapp.data.dao.UserDao
import com.waffle.libraryapp.data.model.Book
import com.waffle.libraryapp.data.model.User

@Database(entities = [User::class, Book::class], version = 3)
abstract class LocalDatabase: RoomDatabase() {
  abstract fun userDao(): UserDao
  abstract fun bookDao(): BookDao

  companion object {
    @Volatile
    private var INSTANCE: LocalDatabase? = null

    fun getDatabase(context: Context): LocalDatabase {
      val tempInstance = INSTANCE

      if (tempInstance != null) {
        return tempInstance
      }

      synchronized(this) {
        val instance = Room.databaseBuilder(
          context.applicationContext,
          LocalDatabase::class.java,
          "local_database"
        ).fallbackToDestructiveMigration().build()

        INSTANCE = instance

        return instance
      }
    }
  }
}