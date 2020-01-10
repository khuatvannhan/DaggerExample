package com.app.exampledagger.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.exampledagger.student.data.module.Student
import com.app.exampledagger.student.data.StudentsDao

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentsDao
}
