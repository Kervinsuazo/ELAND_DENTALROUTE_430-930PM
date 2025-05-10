package com.example.dentalr



import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.dentalroute.R

class BookAppointment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_appointment)


        val etFees = findViewById<EditText>(R.id.etFees)
        val etDate = findViewById<EditText>(R.id.etDate)
        val etTime = findViewById<EditText>(R.id.etTime)
        val locationText = findViewById<TextView>(R.id.tvLocationName)
        val submitButton = findViewById<Button>(R.id.btnSubmit)



        // Example submission handler
        submitButton.setOnClickListener {

            val fees = etFees.text.toString()
            val date = etDate.text.toString()
            val time = etTime.text.toString()
            val location = locationText.text.toString()

            // Process appointment booking
            Toast.makeText(this, "Appointment Submitted!", Toast.LENGTH_SHORT).show()
        }



    }
}