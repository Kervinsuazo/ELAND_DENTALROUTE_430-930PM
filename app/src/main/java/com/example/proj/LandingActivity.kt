package com.example.dentalroute

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dentalroute.api.RetrofitClient
import com.example.dentalroute.api.TestResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LandingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val loginBtn = findViewById<Button>(R.id.loginButton)
        val signupBtn = findViewById<Button>(R.id.signupButton)

        loginBtn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        signupBtn.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        // API Call on Activity load
        testApiConnection()
    }

    private fun testApiConnection() {
        RetrofitClient.instance.testApi().enqueue(object : Callback<TestResponse> {
            override fun onResponse(call: Call<TestResponse>, response: Response<TestResponse>) {
                if (response.isSuccessful) {
                    val result = response.body()
                    Toast.makeText(this@LandingActivity, result?.message, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@LandingActivity, "API Error: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<TestResponse>, t: Throwable) {
                Toast.makeText(this@LandingActivity, "Connection failed: ${t.message}", Toast.LENGTH_LONG).show()
                Log.e("API_ERROR", t.toString())
            }
        })
    }
}
