package com.app.exampledagger.student.data.local

import com.app.exampledagger.data.Result
import com.app.exampledagger.student.data.Student
import com.app.exampledagger.student.data.StudentsDataSource

class StudentsLocalDataSource internal constructor(private val studentsDao: StudentsDao):
    StudentsDataSource {
    override fun getStudents(): Result<List<Student>> {
        return try {
            Result.success(studentsDao.getStudents())
        } catch (e: Exception) {
            Result.error(e.message ?: "")
        }
    }

    override fun getStudent(studentId: Int): Result<Student> {
        return try {
            val student = studentsDao.getStudentById(studentId)
            if (student != null) {
                Result.success(student)
            } else {
                Result.error("Student not found!")
            }
        } catch (e: Exception) {
            Result.error(e.message ?: "")
        }
    }

    override fun saveStudent(student: Student) {
        studentsDao.insertStudent(student)
    }

    override fun deleteStudent(studentId: Int) {
        studentsDao.deleteStudentById(studentId)
    }
}
