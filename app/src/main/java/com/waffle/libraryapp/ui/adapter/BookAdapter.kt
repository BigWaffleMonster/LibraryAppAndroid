package com.waffle.libraryapp.ui.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.waffle.libraryapp.R
import com.waffle.libraryapp.data.model.Book
import com.waffle.libraryapp.databinding.BookViewInListBinding
import kotlinx.android.synthetic.main.book_view_in_list.view.*

class BookAdapter: RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
  var bookList = emptyList<Book>()

  class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val binding = BookViewInListBinding.bind(itemView)

    fun bind(book: Book) = with(binding) {
      bookTitleTxt.text = book.book_title
      bookImgInList.setImageURI(Uri.parse(book.book_img_uri))
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.book_view_in_list, parent, false)
    return BookViewHolder(view)
  }

  override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
    holder.bind(bookList[position])
  }

  override fun getItemCount(): Int {
    return bookList.size
  }

  fun addBookToList(book: List<Book>) {
    this.bookList = book
    notifyDataSetChanged()
  }
}