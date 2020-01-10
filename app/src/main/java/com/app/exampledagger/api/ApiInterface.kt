package com.app.exampledagger.api

import com.app.exampledagger.student.data.module.Student
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("todos/1")
    fun getStudent(): Call<Student>
}
