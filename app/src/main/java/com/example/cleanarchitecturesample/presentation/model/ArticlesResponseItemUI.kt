package com.example.cleanarchitecturesample.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticlesResponseItemUI(
    val events: List<EventUI?>?,
    val featured: Boolean?,
    val id: Int?,
    val imageUrl: String?,
    val launches: List<LaunchUI?>?,
    val newsSite: String?,
    val publishedAt: String?,
    val summary: String?,
    val title: String?,
    val updatedAt: String?,
    val url: String?
) : Parcelable
