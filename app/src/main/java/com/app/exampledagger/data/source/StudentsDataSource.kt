package com.app.exampledagger.data.source

interface StudentsDataSource {
    fun getStudents(): Result<List<Student>>

    fun getStudent(studentId: Int): Result<Student>

    fun saveStudent(student: Student)

    fun deleteStudent(studentId: Int)
}
