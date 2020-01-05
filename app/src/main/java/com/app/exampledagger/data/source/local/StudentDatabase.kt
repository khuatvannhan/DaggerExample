package com.app.exampledagger.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.exampledagger.data.source.Student

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentsDao
}
