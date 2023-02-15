package com.example.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Keep
data class ArticlesResponseItemEntity(
    @SerializedName("events")
    val events: List<EventEntity?>?,
    @SerializedName("featured")
    val featured: Boolean?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("imageUrl")
    val imageUrl: String?,
    @SerializedName("launches")
    val launches: List<LaunchEntity?>?,
    @SerializedName("newsSite")
    val newsSite: String?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("summary")
    val summary: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("updatedAt")
    val updatedAt: String?,
    @SerializedName("url")
    val url: String?
) : Serializable
