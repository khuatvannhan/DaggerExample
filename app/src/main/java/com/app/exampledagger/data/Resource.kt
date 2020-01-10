package com.app.exampledagger.data

import androidx.annotation.NonNull
import androidx.annotation.Nullable

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
</T> */
class Resource<T> private constructor(
    @field:NonNull @param:NonNull val status: Status,
    @field:Nullable @param:Nullable val data: T,
    @field:Nullable @get:Nullable
    @param:Nullable val message: String?
) {

    companion object {
        fun <T> success(@NonNull data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String?, @Nullable data: T): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(@Nullable data: T?): Resource<T> {
            return Resource(Status.LOADING, data!!, null)
        }
    }

}
