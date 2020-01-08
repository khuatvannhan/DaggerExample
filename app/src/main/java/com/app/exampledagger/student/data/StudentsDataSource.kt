package com.app.exampledagger.student.data

import com.app.exampledagger.data.Result
import com.app.exampledagger.student.data.Student

interface StudentsDataSource {
    fun getStudents(): Result<List<Student>>

    fun getStudent(studentId: Int): Result<Student>

    fun saveStudent(student: Student)

    fun deleteStudent(studentId: Int)
}
