package com.app.exampledagger.data.source.local

import com.app.exampledagger.data.source.Result
import com.app.exampledagger.data.source.Student
import com.app.exampledagger.data.source.StudentsDataSource

class StudentsLocalDataSource internal constructor(private val studentsDao: StudentsDao):
StudentsDataSource{
    override fun getStudents(): Result<List<Student>> {
        return try {
            Result.Success(studentsDao.getStudents())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override fun getStudent(studentId: Int): Result<Student> {
        return try {
            val student = studentsDao.getStudentById(studentId)
            if (student != null) {
                Result.Success(student)
            } else {
                Result.Error(Exception("Student not found!"))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override fun saveStudent(student: Student) {
        studentsDao.insertStudent(student)
    }

    override fun deleteStudent(studentId: Int) {
        studentsDao.deleteStudentById(studentId)
    }
}
