package com.waffle.libraryapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.waffle.libraryapp.data.model.User

@Dao
interface UserDao {
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  fun addUser(user: User)

  @Query("SELECT * FROM user_table ORDER BY id ASC")
  fun getUsers(): LiveData<List<User>>
}