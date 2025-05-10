package com.example.proj

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.dentalroute.R

class MedicalHistory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medical_history)

        val etMName = findViewById<EditText>(R.id.etMName)
        val etMContactNom = findViewById<EditText>(R.id.etMContactNom)
        val etMEmail = findViewById<EditText>(R.id.etMEmail)
        val etGender = findViewById<EditText>(R.id.etGender)
        val etMCreateDate = findViewById<EditText>(R.id.etMCreateDate)
        val etMUpdatedDate = findViewById<EditText>(R.id.etMUpdatedDate)
        val etMAction = findViewById<EditText>(R.id.etMAction)

        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            finish()
        }


    }
}
