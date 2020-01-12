package com.app.exampledagger

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.exampledagger.data.Resource
import com.app.exampledagger.student.data.StudentsRepositoryImpl
import com.app.exampledagger.student.data.module.Student
import javax.inject.Inject

/**
 *  List view model
 */
class MainViewModel @Inject constructor(repository: StudentsRepositoryImpl) : ViewModel() {
    @JvmField var student: LiveData<Resource<Student>> = repository.getStudents(false)

    fun getLiveData(): LiveData<Resource<Student>> {
        return student
    }
}
