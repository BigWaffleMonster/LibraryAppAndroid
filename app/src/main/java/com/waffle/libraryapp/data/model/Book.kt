package com.waffle.libraryapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
data class Book(
  @PrimaryKey(autoGenerate = true)
  val book_id: Int,
  val book_title: String,
  val book_description: String,
  val book_comment: String,
  val book_rating: Int,
//  val creator: User TODO: fix this
)