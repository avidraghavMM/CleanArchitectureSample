package com.example.cleanarchitecturesample.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventUI(
    val id: Int?,
    val provider: String?
) : Parcelable
