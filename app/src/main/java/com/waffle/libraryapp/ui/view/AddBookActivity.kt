package com.waffle.libraryapp.ui.view

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.waffle.libraryapp.R
import com.waffle.libraryapp.data.model.Book
import com.waffle.libraryapp.ui.viewModel.BookViewModel

class AddBookActivity : AppCompatActivity() {
  private lateinit var mBookViewModel: BookViewModel
  private lateinit var image_uri: Uri

  @RequiresApi(Build.VERSION_CODES.M)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_add_book)


    val pick_btn = findViewById<Button>(R.id.pickBtn)
    val save_btn = findViewById<Button>(R.id.saveButton)

    mBookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

    pick_btn.setOnClickListener {
      getImg()
    }

    save_btn.setOnClickListener {
      saveBook()
    }


  }

  @RequiresApi(Build.VERSION_CODES.M)
  private fun getImg() {
    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
      val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
      requestPermissions(permissions, PERMISSION_CODE)
    } else {
      pickImgFromGallery()
    }
  }

  private fun pickImgFromGallery() {
    val intent = Intent(Intent.ACTION_PICK)
    intent.type = "image/*"
    startActivityForResult(intent, IMAGE_PICK_CODE)
  }

  private fun saveBook() {
    val title = findViewById<EditText>(R.id.tileText).text.toString()
    val description = findViewById<EditText>(R.id.descriptionText).text.toString()
    val rating = findViewById<EditText>(R.id.ratingText).text.toString()

    val book = Book(0, title, description, Integer.parseInt(rating), image_uri.toString())

    println(book)
    mBookViewModel.addBook(book)

    Toast.makeText(this, "Book has been added", Toast.LENGTH_LONG).show()
  }

  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    when(requestCode){
      PERMISSION_CODE -> {
        if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
          pickImgFromGallery()
        } else {
          Toast.makeText(this, "Permissions denied", Toast.LENGTH_SHORT).show()
        }
      }
    }
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
      val image_view = findViewById<ImageView>(R.id.imageView)
      image_uri = data!!.data!!
      image_view.setImageURI(data?.data)
    }
  }


  companion object {
    private val IMAGE_PICK_CODE = 1000
    private val PERMISSION_CODE = 1001
  }
}