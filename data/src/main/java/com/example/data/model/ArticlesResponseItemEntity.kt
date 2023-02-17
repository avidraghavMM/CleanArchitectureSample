package com.example.data.model

import androidx.annotation.Keep
import com.example.domain.model.ArticlesResponseItem
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

fun ArticlesResponseItemEntity.toDomain(): ArticlesResponseItem {
    return ArticlesResponseItem(
        id = id,
        imageUrl = imageUrl,
        summary = summary,
        title = title,
        url = url,
        newsSite = newsSite,
        publishedAt = publishedAt
    )
}
