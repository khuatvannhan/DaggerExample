package com.app.exampledagger.api

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.app.exampledagger.data.Resource
import com.google.gson.stream.MalformedJsonException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * This class act as the decider to cache the response/ fetch from the service always
 * Author: Lajesh D
 * Email: lajeshds2007@gmail.com
 * Created: 7/24/2018
 * Modified: 7/24/2018
 */
abstract class NetworkBoundResource<ResultType, RequestType> @MainThread protected constructor() {
    val result =
        MediatorLiveData<Resource<ResultType>>()

    init {
        result.setValue(Resource.loading())
        // Always load the data from DB intially so that we have
        val dbSource = loadFromDb()
        // Fetch the data from network and add it to the resource
        fetchFromNetwork(dbSource)
//        result.addSource(dbSource) { data: ResultType ->
//            result.removeSource(dbSource)
//            if (shouldFetch()) {
//                fetchFromNetwork(dbSource)
//            } else {
//                result.addSource(
//                    dbSource
//                ) { newData: ResultType ->
//                    if (null != newData) result.postValue(
//                        Resource.success(
//                            newData
//                        )
//                    )
//                }
//            }
//        }
    }

    /**
     * This method fetches the data from remoted service and save it to local db
     * @param dbSource - Database source
     */
    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        result.addSource(
            dbSource
        ) { newData: ResultType ->
            result.setValue(
                Resource.loading(newData)
            )
        }
        createCall().enqueue(object : Callback<RequestType> {
            override fun onResponse(
                call: Call<RequestType>,
                response: Response<RequestType>
            ) {
                result.removeSource(dbSource)
                response.body()?.let { saveResultAndReInit(it) }
            }

            override fun onFailure(
                call: Call<RequestType>,
                t: Throwable
            ) {
                result.removeSource(dbSource)
                result.addSource(
                    dbSource
                ) { newData: ResultType ->
                    result.setValue(
                        Resource.error(
                            getCustomErrorMessage(t),
                            newData
                        )
                    )
                }
            }
        })
    }

    private fun getCustomErrorMessage(error: Throwable): String {
        return if (error is SocketTimeoutException) {
            " NYTimesApp.getAppContext().getString(R.string.requestTimeOutError)"
        } else if (error is MalformedJsonException) {
            " NYTimesApp.getAppContext().getString(R.string.responseMalformedJson)"
        } else if (error is IOException) {
            " NYTimesApp.getAppContext().getString(R.string.networkError)"
        } else if (error is HttpException) {
            error.response().message()
        } else {
            "NYTimesApp.getAppContext().getString(R.string.unknownError)"
        }
    }

    @SuppressLint("StaticFieldLeak")
    @MainThread
    private fun saveResultAndReInit(response: RequestType) {
        object : AsyncTask<Void?, Void?, Void?>() {
            override fun doInBackground(vararg p0: Void?): Void? {
                saveCallResult(response)
                return null
            }

            override fun onPostExecute(aVoid: Void?) {
                result.addSource(
                    loadFromDb()
                ) { newData: ResultType ->
                    if (null != newData) result.postValue(
                        Resource.success(
                            newData
                        )
                    )
                }
            }
        }.execute()
    }

    @WorkerThread
    protected abstract fun saveCallResult(item: RequestType)

    @MainThread
    private fun shouldFetch(): Boolean {
        return true
    }

    @MainThread
    protected abstract fun loadFromDb(): LiveData<ResultType>

    @MainThread
    protected abstract fun createCall(): Call<RequestType>

    val asLiveData: LiveData<Resource<ResultType>>
        get() = result

}
