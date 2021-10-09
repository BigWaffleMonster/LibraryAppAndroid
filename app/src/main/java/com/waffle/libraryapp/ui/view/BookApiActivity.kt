package com.waffle.libraryapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.waffle.libraryapp.R
import com.waffle.libraryapp.data.utils.bookTypeApi
import com.waffle.libraryapp.ui.viewModel.BookViewModel

class BookApiActivity : AppCompatActivity() {
  private lateinit var mBookViewModel: BookViewModel
  private var data: bookTypeApi = bookTypeApi("", "")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_book_api)

    val title = findViewById<TextView>(R.id.title_api)
    val desc = findViewById<TextView>(R.id.book_desc_api)

    mBookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

    mBookViewModel.getBooksFromApi()
    mBookViewModel.booksFromApi.observe(this, Observer {
        response ->
      if(response.isSuccessful) {
        data.title = response.body()!!.title
        data.description = response.body()!!.description

        title.setText(data.title)
        desc.setText(data.description)
      }
    })
  }
}