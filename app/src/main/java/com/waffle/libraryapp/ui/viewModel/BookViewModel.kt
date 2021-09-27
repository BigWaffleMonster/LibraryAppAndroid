package com.waffle.libraryapp.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.waffle.libraryapp.data.database.LocalDatabase
import com.waffle.libraryapp.data.model.Book
import com.waffle.libraryapp.data.repository.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(application: Application): AndroidViewModel(application) {
  val repository: BookRepository
  val getBooks: LiveData<List<Book>>

  init {
    val bookDao = LocalDatabase.getDatabase(application).bookDao()
    repository = BookRepository(bookDao)
    getBooks = repository.getBooks
  }

  fun addBook(book: Book) {
    viewModelScope.launch(Dispatchers.IO) {
      repository.addBook(book)
    }
  }
}