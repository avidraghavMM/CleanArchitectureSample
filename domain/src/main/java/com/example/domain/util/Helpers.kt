package com.example.domain.util

/**
 * A generic class that wraps the state of an action into two
 * exhaustive outcomes Success or Failure.
 * */
sealed class Resource<out T> {
    /**
     * Success represents that action taken has been completed
     * with valid data as result
     */
    class Success<T>(val data: T) : Resource<T>()

    /**
     * Error represents that action taken has not been completed du
     * to some exception or it has completed but the resulting data is
     * not valid
     */
    class Error(val exception: Exception) : Resource<Nothing>()
}

/**
 * Generic Higher Order function which executes the suspend block
 * provided to it and wraps it in Resource Class based on the result of execution
 * @see Resource
 */
suspend fun <T> safeCall(apiCall: suspend () -> T): Resource<T> {
    return try {
        Resource.Success(data = apiCall())
    } catch (e: Exception) {
        Resource.Error(exception = e)
    }
}
