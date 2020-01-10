package com.app.exampledagger.student.data

import com.app.exampledagger.data.Resource
import com.app.exampledagger.student.data.module.Student

interface StudentsDataSource {
    fun getStudents(): Resource<List<Student>>

    fun getStudent(studentId: Int): Resource<Student>

    fun saveStudent(student: Student)

    fun deleteStudent(studentId: Int)
}
