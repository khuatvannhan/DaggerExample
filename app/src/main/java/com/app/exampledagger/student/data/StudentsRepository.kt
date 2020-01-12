package com.app.exampledagger.student.data

import androidx.lifecycle.LiveData
import com.app.exampledagger.data.Resource
import com.app.exampledagger.student.data.module.Student
import dagger.Module
import dagger.Provides

interface StudentsRepository {
    fun getStudents(forceUpdate: Boolean = false): LiveData<Resource<Student>>

    fun getStudent(studentId: Int, forceUpdate: Boolean = false): LiveData<Resource<Student>>

    fun saveStudent(student: Student)

    fun deleteStudent(studentId: Int)
}
