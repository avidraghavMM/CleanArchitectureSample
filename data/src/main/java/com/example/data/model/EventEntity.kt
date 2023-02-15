package com.example.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class EventEntity(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("provider")
    val provider: String?
)
