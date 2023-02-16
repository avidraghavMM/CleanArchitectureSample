package com.example.cleanarchitecturesample.presentation.model

import android.os.Parcelable
import com.example.domain.model.ArticlesResponseItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticlesResponseItemUI(
    val id: Int?,
    val imageUrl: String?,
    val newsSite: String?,
    val publishedAt: String?,
    val summary: String?,
    val title: String?,
    val url: String?
) : Parcelable

fun ArticlesResponseItem.toPresenter(): ArticlesResponseItemUI {
    return ArticlesResponseItemUI(
        id = id,
        imageUrl = imageUrl,
        summary = summary,
        title = title,
        url = url,
        newsSite = newsSite,
        publishedAt = publishedAt
    )
}
