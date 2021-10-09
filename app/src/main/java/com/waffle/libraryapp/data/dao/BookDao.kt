package com.waffle.libraryapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.waffle.libraryapp.data.model.Book

@Dao
interface BookDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun addBook(book: Book)

  @Query("SELECT * FROM book_table ORDER BY book_id ASC")
  fun getBooks(): LiveData<List<Book>>
}