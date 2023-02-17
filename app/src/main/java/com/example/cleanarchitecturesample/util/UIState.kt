package com.example.cleanarchitecturesample.util

/**
 * Generic class which can be used to describe the state of a screen
 */

sealed class UIState<out T> {

    /**
     * Empty corresponds to the state when the screen is idle and no action has
     * either been taken or in process.
     * see https://proandroiddev.com/kotlins-nothing-type-946de7d464fb to learn about Nothing Datatype
     */
    object Empty : UIState<Nothing>()

    /**
     * Loading corresponds to the state when an action is currently in process and the UI
     * is waiting for it's completion.
     * see https://proandroiddev.com/kotlins-nothing-type-946de7d464fb to learn about Nothing Datatype
     */
    object Loading : UIState<Nothing>()

    /**
     * Success corresponds to the state when the action taken has successfully completed
     * with valid data and the UI could be refreshed with the new data.
     * @param data generic data which was to be returned in response of
     * an action taken from any data source either local or remote
     */
    class Success<T>(val data: T) : UIState<T>()

    /**
     * Error corresponds to the state when the action taken didn't completed as intended. for eg. a network
     * request maybe completed successfully but if the returned data is not valid then state would still be Error
     * @param exception generic data which was to be returned in response of
     * an action taken from any data source either local or remote
     */
    class Error(val exception: Exception) : UIState<Nothing>()
}
