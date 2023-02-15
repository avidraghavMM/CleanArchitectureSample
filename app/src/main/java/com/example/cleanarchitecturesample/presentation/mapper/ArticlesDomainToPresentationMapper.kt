package com.example.cleanarchitecturesample.presentation.mapper

import com.example.cleanarchitecturesample.presentation.model.ArticlesResponseItemUI
import com.example.cleanarchitecturesample.presentation.model.EventUI
import com.example.cleanarchitecturesample.presentation.model.LaunchUI
import com.example.domain.mapper.Mapper
import com.example.domain.model.ArticlesResponseItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticlesDomainToPresentationMapper @Inject constructor() : Mapper<ArticlesResponseItemUI, ArticlesResponseItem> {
    override fun map(entity: ArticlesResponseItem): ArticlesResponseItemUI = with(entity) {
        ArticlesResponseItemUI(
            events = events?.map {
                EventUI(id = it?.id, provider = it?.provider)
            },
            featured = featured,
            id = id,
            imageUrl = imageUrl,
            launches = launches?.map {
                LaunchUI(it?.id, it?.provider)
            },
            newsSite = newsSite,
            publishedAt = publishedAt,
            summary = summary,
            title = title,
            updatedAt = updatedAt,
            url = url
        )
    }
}
