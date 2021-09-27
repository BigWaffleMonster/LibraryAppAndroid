package com.waffle.libraryapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.waffle.libraryapp.R
import com.waffle.libraryapp.data.model.Book
import com.waffle.libraryapp.ui.viewModel.BookViewModel

class AddBookActivity : AppCompatActivity() {
  private lateinit var mBookViewModel: BookViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_add_book)

    val save_btn = findViewById<Button>(R.id.saveButton)

    mBookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

    save_btn.setOnClickListener {
      saveBook()
    }
  }

  private fun saveBook() {
    val title = findViewById<EditText>(R.id.tileText).text.toString()
    val description = findViewById<EditText>(R.id.descriptionText).text.toString()
    val comment = findViewById<EditText>(R.id.commentText).text.toString()
    val rating = findViewById<EditText>(R.id.ratingText).text.toString()

    val book = Book(0, title, description, comment, Integer.parseInt(rating))

    mBookViewModel.addBook(book)

    Toast.makeText(this, "Book has been added", Toast.LENGTH_LONG).show()
  }
}