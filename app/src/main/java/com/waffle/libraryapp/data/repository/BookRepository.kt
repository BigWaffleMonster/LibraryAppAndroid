package com.waffle.libraryapp.data.repository

import androidx.lifecycle.LiveData
import com.waffle.libraryapp.data.dao.BookDao
import com.waffle.libraryapp.data.model.Book

class BookRepository(private val bookDao: BookDao) {
  val getBooks: LiveData<List<Book>> = bookDao.getBooks()

  suspend fun addBook (book: Book) {
    bookDao.addBook(book)
  }
}