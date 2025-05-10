package com.example.dentalroute.api

import com.example.proj.LoginRequest
import com.example.dentistapp.model.UserResponse
import com.example.proj.AppointmentResponse
import com.example.proj.BookAppointmentRequest
import com.example.proj.BookAppointmentResponse
import com.example.proj.ProfileResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("test")
    fun testApi(): Call<TestResponse>

    @POST("profile")
    fun getProfile(): Call<ProfileResponse>

    @POST("login")
    fun loginUser(
        @Body request: LoginRequest
    ): Call<UserResponse>


    @POST("appointments")
    fun getAppointments(): Call<AppointmentResponse>

    @POST("book-appointment")
    fun bookAppointment(@Body request: BookAppointmentRequest): Call<BookAppointmentResponse>
}
