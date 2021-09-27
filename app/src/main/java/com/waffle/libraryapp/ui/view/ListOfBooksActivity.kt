package com.waffle.libraryapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.waffle.libraryapp.R
import com.waffle.libraryapp.databinding.ActivityListOfBooksBinding
import com.waffle.libraryapp.databinding.BookViewInListBinding
import com.waffle.libraryapp.ui.adapter.BookAdapter
import com.waffle.libraryapp.ui.viewModel.BookViewModel
import kotlinx.android.synthetic.main.activity_list_of_books.*

class ListOfBooksActivity : AppCompatActivity() {
  private lateinit var mBookViewModel: BookViewModel

  lateinit var binding: ActivityListOfBooksBinding
  private val adapter = BookAdapter()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityListOfBooksBinding.inflate(layoutInflater)
    setContentView(binding.root)
    init()
  }

  private fun init() {
    binding.apply {
      bookRcView.layoutManager = LinearLayoutManager(this@ListOfBooksActivity)
      bookRcView.adapter = adapter
    }

    mBookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)
    mBookViewModel.getBooks.observe(this, Observer {
      book -> adapter.addBookToList(book)
    })
  }
}