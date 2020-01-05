package com.app.exampledagger.data.source.remote.api

import com.app.exampledagger.data.source.Student
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.*

interface ApiStudentInterface {
    @GET("todos/1")
    fun getStudent(): Observable<Student>

    companion object Factory {
        fun create(): ApiStudentInterface {
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build()

            return retrofit.create(ApiStudentInterface::class.java)
        }
    }
}
