package com.app.exampledagger.data.source

interface StudentsRepository {
    fun getStudents(forceUpdate: Boolean = false): Result<List<Student>>

    fun getStudent(studentId: Int, forceUpdate: Boolean = false): Result<Student>

    fun saveStudent(student: Student)

    fun deleteStudent(studentId: Int)
}
