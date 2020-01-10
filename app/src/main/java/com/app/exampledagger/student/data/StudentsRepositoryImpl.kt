package com.app.exampledagger.student.data

import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.app.exampledagger.api.ApiInterface
import com.app.exampledagger.data.Resource
import com.app.exampledagger.student.data.module.Student
import retrofit2.Call
import javax.inject.Inject

class StudentsRepositoryImpl @Inject constructor(
    private val apiService: ApiInterface,
    private val studentDao: StudentsDao
) : StudentsRepository {

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

    override fun getStudents(forceUpdate: Boolean): LiveData<Resource<Student>> {
        return networkBoundResource.asLiveData
    }

    override fun getStudent(studentId: Int, forceUpdate: Boolean): LiveData<Resource<Student>> {
        return networkBoundResource.result
    }

    override fun saveStudent(student: Student) {
        studentDao.insertStudent(student)
    }

    override fun deleteStudent(studentId: Int) {
        studentDao.deleteStudentById(studentId)
    }
}
