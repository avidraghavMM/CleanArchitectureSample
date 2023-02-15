package com.example.cleanarchitecturesample.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LaunchUI(
    val id: String?,
    val provider: String?
) : Parcelable
