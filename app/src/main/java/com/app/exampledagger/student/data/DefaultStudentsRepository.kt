package com.app.exampledagger.student.data

import com.app.exampledagger.di.module.ApplicationModule.StudentsRemoteDataSource
import com.app.exampledagger.di.module.ApplicationModule.StudentsLocalDataSource
import javax.inject.Inject

class DefaultStudentsRepository @Inject constructor(
    @StudentsRemoteDataSource private val studentsRemoteDataSource: StudentsDataSource,
    @StudentsLocalDataSource private val studentsLocalDataSource: StudentsDataSource
)
