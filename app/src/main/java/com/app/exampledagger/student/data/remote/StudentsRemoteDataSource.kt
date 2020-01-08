package com.app.exampledagger.student.data.remote

import com.app.exampledagger.data.Result
import com.app.exampledagger.student.data.Student
import com.app.exampledagger.student.data.StudentsDataSource

/**
 * Implementation of the data source that adds latency simulating network
 */
object StudentsRemoteDataSource :
    StudentsDataSource {
    private val STUDENT_SERVICE_DATA = LinkedHashMap<Int, Student>(2)

    override fun getStudents(): Result<List<Student>> {
        val students = STUDENT_SERVICE_DATA.values.toList()
        return Result.success(students)
    }

    override fun getStudent(studentId: Int): Result<Student> {
        STUDENT_SERVICE_DATA[studentId]?.let {
            return Result.success(it)
        }
        return Result.error("Student not found")
    }

    override fun saveStudent(student: Student) {
        STUDENT_SERVICE_DATA[student.id] = student
    }

    override fun deleteStudent(studentId: Int) {
        STUDENT_SERVICE_DATA.remove(studentId)
    }
}
