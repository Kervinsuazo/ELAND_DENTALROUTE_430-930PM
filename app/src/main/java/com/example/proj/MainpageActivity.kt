package com.example.dentalroute

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.example.dentalr.BookAppointment
import com.example.proj.AppointmentHistoryPatientActivity
import com.example.proj.MedicalHistory

class UserMainpage : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainpage)

        // Hamburger: Medical History
        val medicalHistoryMenu = findViewById<LinearLayout>(R.id.menuMedicalHistory)
        medicalHistoryMenu.setOnClickListener {
            val intent = Intent(this, MedicalHistory::class.java)
            startActivity(intent)
        }

        val appointmentHistoryMenu = findViewById<LinearLayout>(R.id.menuAppointmentHistory)

        appointmentHistoryMenu.setOnClickListener {
            val intent = Intent(this, AppointmentHistoryPatientActivity::class.java)
            startActivity(intent)
        }

        // Hamburger: Appointment (same as BookAppointment)
        val appointmentMenu = findViewById<LinearLayout>(R.id.menuAppointment)
        appointmentMenu.setOnClickListener {
            val intent = Intent(this, BookAppointment::class.java)
            startActivity(intent)
        }

        // Button: Book Appointment
        val bookAppointmentBtn = findViewById<Button>(R.id.btnBookAppointment)
        bookAppointmentBtn.setOnClickListener {
            val intent = Intent(this, BookAppointment::class.java)
            startActivity(intent)
        }

        // Toolbar & Drawer
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawerLayout)
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return toggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item)
    }
}
