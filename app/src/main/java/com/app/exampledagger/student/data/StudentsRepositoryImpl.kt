package com.app.exampledagger.student.data

import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import com.app.exampledagger.api.ApiInterface
import com.app.exampledagger.api.NetworkBoundResource
import com.app.exampledagger.data.Resource
import com.app.exampledagger.student.data.module.Student
import retrofit2.Call
import javax.inject.Inject

class StudentsRepositoryImpl @Inject constructor(
    private val apiService: ApiInterface,
    private val studentDao: StudentsDao
) {

    private var networkBoundResource: NetworkBoundResource<Student, Student> = object :
        NetworkBoundResource<Student, Student>() {
        override fun saveCallResult(item: Student) {
            studentDao.insertStudent(item)
        }

        @NonNull
        override fun loadFromDb(): LiveData<Student> {
            return studentDao.getStudents()
        }

        @NonNull
        override fun createCall(): Call<Student> {
            return apiService.getStudent()
        }
    }

     fun getStudents(forceUpdate: Boolean): LiveData<Resource<Student>> {
        return networkBoundResource.asLiveData
    }

     fun getStudent(studentId: Int, forceUpdate: Boolean): LiveData<Resource<Student>> {
        return networkBoundResource.result
    }

     fun saveStudent(student: Student) {
        studentDao.insertStudent(student)
    }

     fun deleteStudent(studentId: Int) {
        studentDao.deleteStudentById(studentId)
    }
}
