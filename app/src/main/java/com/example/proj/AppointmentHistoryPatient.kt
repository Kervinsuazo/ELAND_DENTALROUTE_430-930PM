package com.example.proj

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import com.example.dentalroute.R

class AppointmentHistoryPatientActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.appointment_history_patient)

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // Close activity
        }
    }
}