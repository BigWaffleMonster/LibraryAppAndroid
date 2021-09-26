package com.waffle.libraryapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.waffle.libraryapp.R
import com.waffle.libraryapp.data.model.User
import com.waffle.libraryapp.ui.viewModel.UserViewModel

class MainActivity : AppCompatActivity() {
  private lateinit var mUserViewModel: UserViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val register_btn = findViewById<Button>(R.id.registrBtn)
    val login_btn = findViewById<Button>(R.id.loginBtn)

    mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

    register_btn.setOnClickListener {
      register()
    }

    login_btn.setOnClickListener {
      login()
    }

  }

  private fun register() {
    val email = findViewById<TextView>(R.id.emailField).text.toString()
    val password = findViewById<TextView>(R.id.passwordField).text.toString()

    val user = User(0, email, password)

    mUserViewModel.addUser(user)

    Toast.makeText(this, "added", Toast.LENGTH_LONG).show()
  }

  private fun login() {
    val email = findViewById<TextView>(R.id.emailField).text.toString()
    val password = findViewById<TextView>(R.id.passwordField).text.toString()

    val users = mUserViewModel.getUsers

    users.observe(this, {user ->
      for (user in user) {
        if (user.email == email && user.password == password) {
          val intent = Intent(this, MenuActivity::class.java)
          startActivity(intent)
          break
        }
      }
    })
  }
}