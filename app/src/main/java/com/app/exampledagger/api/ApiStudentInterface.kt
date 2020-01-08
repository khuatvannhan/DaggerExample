package com.app.exampledagger.api

import com.app.exampledagger.student.data.Student
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface ApiStudentInterface {
    @GET("todos/1")
    fun getStudent(): Observable<Response<Student>>
}
