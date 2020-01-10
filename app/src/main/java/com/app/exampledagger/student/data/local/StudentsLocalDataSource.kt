//package com.app.exampledagger.student.data.local
//
//import com.app.exampledagger.data.Resource
//import com.app.exampledagger.student.data.module.Student
//import com.app.exampledagger.student.data.StudentsDataSource
//
//class StudentsLocalDataSource internal constructor(private val studentsDao: StudentsDao):
//    StudentsDataSource {
//    override fun getStudents(): Resource<List<Student>> {
//        return try {
//            Resource.success(studentsDao.getStudents())
//        } catch (e: Exception) {
//            Resource.error(e.message ?: "")
//        }
//    }
//
//    override fun getStudent(studentId: Int): Resource<Student> {
//        return try {
//            val student = studentsDao.getStudentById(studentId)
//            if (student != null) {
//                Resource.success(student)
//            } else {
//                Resource.error("Student not found!")
//            }
//        } catch (e: Exception) {
//            Resource.error(e.message ?: "")
//        }
//    }
//
//    override fun saveStudent(student: Student) {
//        studentsDao.insertStudent(student)
//    }
//
//    override fun deleteStudent(studentId: Int) {
//        studentsDao.deleteStudentById(studentId)
//    }
//}
