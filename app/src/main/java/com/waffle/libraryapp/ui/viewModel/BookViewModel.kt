package com.waffle.libraryapp.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.waffle.libraryapp.data.database.LocalDatabase
import com.waffle.libraryapp.data.model.Book
import com.waffle.libraryapp.data.repository.BookRepository
import com.waffle.libraryapp.data.utils.bookTypeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class BookViewModel(application: Application): AndroidViewModel(application) {
  val repository: BookRepository
  val getBooks: LiveData<List<Book>>
  val booksFromApi: MutableLiveData<Response<bookTypeApi>> = MutableLiveData()

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

  fun getBooksFromApi() {
    viewModelScope.launch {
      val response = repository.getBooksFromApi()
      booksFromApi.value = response
    }
  }
}