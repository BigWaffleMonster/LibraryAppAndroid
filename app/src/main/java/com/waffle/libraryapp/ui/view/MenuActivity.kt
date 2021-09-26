package com.waffle.libraryapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.waffle.libraryapp.R

class MenuActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_menu)

    val all_books_btn = findViewById<Button>(R.id.all_books_btn)
    val add_book_menu_btn = findViewById<Button>(R.id.add_book_menu_btn)

    all_books_btn.setOnClickListener {
      val intent = Intent(this, ListOfBooksActivity::class.java)
      startActivity(intent)
    }

    add_book_menu_btn.setOnClickListener {
      val intent = Intent(this, AddBookActivity::class.java)
      startActivity(intent)
    }
  }
}