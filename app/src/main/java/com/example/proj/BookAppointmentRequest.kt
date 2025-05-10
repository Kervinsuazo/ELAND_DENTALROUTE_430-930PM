package com.example.proj

data class BookAppointmentRequest(
    val patient_id: Int,
    val doctor_id: Int,
    val date: String,
    val time: String
)
