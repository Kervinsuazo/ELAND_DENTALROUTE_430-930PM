package com.example.dentalroute

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.dentistapp.CreateAccount
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailInput = findViewById<TextInputEditText>(R.id.email_input)
        val passwordInput = findViewById<TextInputEditText>(R.id.password_input)
        val loginButton = findViewById<Button>(R.id.btnLoginfake)
        val createAccount = findViewById<TextView>(R.id.text_create_account)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Proceeding to Home...", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, UserMainpage::class.java))
                finish()
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }

        createAccount.setOnClickListener {
            startActivity(Intent(this, CreateAccount::class.java))
        }
    }
}
