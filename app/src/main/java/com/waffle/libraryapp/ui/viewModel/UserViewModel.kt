package com.waffle.libraryapp.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.waffle.libraryapp.data.database.LocalDatabase
import com.waffle.libraryapp.data.model.User
import com.waffle.libraryapp.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
  private val repository: UserRepository
  val getUsers: LiveData<List<User>>

  init {
    val userDao = LocalDatabase.getDatabase(application).userDao()
    repository = UserRepository(userDao)
    getUsers = repository.getUsers
  }

  fun addUser(user: User) {
    viewModelScope.launch(Dispatchers.IO) {
      repository.addUser(user)
    }
  }
}