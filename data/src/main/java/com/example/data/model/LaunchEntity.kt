package com.example.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class LaunchEntity(
    @SerializedName("id")
    val id: String?,
    @SerializedName("provider")
    val provider: String?
)
