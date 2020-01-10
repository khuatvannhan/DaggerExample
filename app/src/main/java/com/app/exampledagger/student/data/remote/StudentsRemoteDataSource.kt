//package com.app.exampledagger.student.data.remote
//
//import com.app.exampledagger.api.ApiInterface
//import com.app.exampledagger.api.BaseDataSource
//import javax.inject.Inject
//
///**
// * Implementation of the data source that adds latency simulating network
// */
//class StudentsRemoteDataSource @Inject constructor(private val service: ApiInterface)  :
//    BaseDataSource() {
//    fun fetchData() = service.getStudent()
//}
