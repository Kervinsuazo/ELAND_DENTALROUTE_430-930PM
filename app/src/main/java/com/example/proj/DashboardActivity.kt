package com.example.dentalroute

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.example.dentalroute.api.RetrofitClient
import com.example.proj.AppointmentResponse
import com.example.proj.BookAppointmentRequest
import com.example.proj.BookAppointmentResponse
import com.example.proj.ProfileResponse
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawerLayout)
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val btnProfile = findViewById<MaterialButton>(R.id.btnProfile)
        val btnAppointment = findViewById<MaterialButton>(R.id.btnAppointment)
        val btnBookAppointment = findViewById<MaterialButton>(R.id.btnBookAppointment)

        btnProfile.setOnClickListener {
            RetrofitClient.instance.getProfile().enqueue(object : Callback<ProfileResponse> {
                override fun onResponse(call: Call<ProfileResponse>, response: Response<ProfileResponse>) {
                    if (response.isSuccessful) {
                        val profile = response.body()
                        Toast.makeText(this@DashboardActivity, "Name: ${profile?.name}, Role: ${profile?.role}", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@DashboardActivity, "Profile error: ${response.code()}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
                    Toast.makeText(this@DashboardActivity, "Failed to load profile", Toast.LENGTH_SHORT).show()
                }
            })
        }

        btnAppointment.setOnClickListener {
            RetrofitClient.instance.getAppointments().enqueue(object : Callback<AppointmentResponse> {
                override fun onResponse(call: Call<AppointmentResponse>, response: Response<AppointmentResponse>) {
                    if (response.isSuccessful) {
                        val appointments = response.body()?.appointments?.joinToString(", ")
                        Toast.makeText(this@DashboardActivity, "Appointments: $appointments", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@DashboardActivity, "Appointment error: ${response.code()}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<AppointmentResponse>, t: Throwable) {
                    Toast.makeText(this@DashboardActivity, "Failed to load appointments", Toast.LENGTH_SHORT).show()
                }
            })
        }

        btnBookAppointment.setOnClickListener {
            val request = BookAppointmentRequest(
                patient_id = 1,
                doctor_id = 2,
                date = "2025-05-10",
                time = "10:30 AM"
            )

            RetrofitClient.instance.bookAppointment(request).enqueue(object : Callback<BookAppointmentResponse> {
                override fun onResponse(call: Call<BookAppointmentResponse>, response: Response<BookAppointmentResponse>) {
                    if (response.isSuccessful) {
                        val msg = response.body()?.message
                        Toast.makeText(this@DashboardActivity, msg ?: "Booked successfully", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@DashboardActivity, "Booking failed: ${response.code()}", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<BookAppointmentResponse>, t: Throwable) {
                    Toast.makeText(this@DashboardActivity, "Network error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }


        val logoImage = findViewById<ImageView>(R.id.logo)
        logoImage.setImageResource(R.drawable.logo)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return toggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item)
    }
}
