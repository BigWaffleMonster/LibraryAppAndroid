package com.waffle.libraryapp.data.repository

import androidx.lifecycle.LiveData
import com.waffle.libraryapp.data.dao.UserDao
import com.waffle.libraryapp.data.model.User

class UserRepository(private val userDao: UserDao) {
  val getUsers: LiveData<List<User>> = userDao.getUsers()

  suspend fun addUser(user: User) {
    //add coroutine here instead of adding it in bookViewModel
    userDao.addUser(user)
  }
}