package com.app.exampledagger.student.data.module

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "students")
data class Student @JvmOverloads constructor(
    @PrimaryKey
    @ColumnInfo(name = "studentId") val studentId: Int,
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "userId") val userId: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "completed") val completed: Boolean)
//https://jsonplaceholder.typicode.com/todos/1
