package com.app.exampledagger.data.source

import androidx.room.ColumnInfo
import androidx.room.Entity


@Entity(tableName = "Students")
data class Student @JvmOverloads constructor(
    @ColumnInfo(name = "userId") val userId: Int,
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "completed") val completed: Boolean)
//https://jsonplaceholder.typicode.com/todos/1
