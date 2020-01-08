package com.app.exampledagger.student.data

import com.app.exampledagger.data.Result
import com.app.exampledagger.student.data.Student

interface StudentsRepository {
    fun getStudents(forceUpdate: Boolean = false): Result<List<Student>>

    fun getStudent(studentId: Int, forceUpdate: Boolean = false): Result<Student>

    fun saveStudent(student: Student)

    fun deleteStudent(studentId: Int)
}
