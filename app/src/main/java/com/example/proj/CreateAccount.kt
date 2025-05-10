package com.example.dentistapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

import com.example.dentistapp.model.UserResponse
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.content.Intent
import com.example.dentalroute.MainActivity
import com.example.dentalroute.R
import com.example.dentalroute.api.RetrofitClient

class CreateAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_account)

        val fullname = findViewById<TextInputEditText>(R.id.input_fullname)
        val address = findViewById<TextInputEditText>(R.id.input_address)
        val city = findViewById<TextInputEditText>(R.id.input_city)
        val gender = findViewById<TextInputEditText>(R.id.input_gender)
        val password = findViewById<TextInputEditText>(R.id.input_password)
        val confirmPassword = findViewById<TextInputEditText>(R.id.input_confirm_password)
        val registerBtn = findViewById<Button>(R.id.button_register)
        val email = findViewById<TextInputEditText>(R.id.input_email)

        registerBtn.setOnClickListener {



        }
    }
}
