package com.waffle.libraryapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.waffle.libraryapp.R

class ListOfBooksActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_list_of_books)
  }
}