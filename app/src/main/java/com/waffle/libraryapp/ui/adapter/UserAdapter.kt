package com.waffle.libraryapp.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.waffle.libraryapp.data.model.User

class UserAdapter: RecyclerView.Adapter<UserAdapter.BookViewHolder>() {
  private var userList = emptyList<User>()

  class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
    TODO("Not yet implemented")
  }

  override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
    val currentItem = userList[position]
  }

  override fun getItemCount(): Int {
    return userList.size
  }
}