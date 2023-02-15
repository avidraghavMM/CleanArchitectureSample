package com.example.data.mapper

import com.example.data.model.ArticlesResponseItemEntity
import com.example.domain.mapper.Mapper
import com.example.domain.model.ArticlesResponseItem
import com.example.domain.model.Event
import com.example.domain.model.Launch

class ArticlesDomainToDataMapper() : Mapper<ArticlesResponseItem, ArticlesResponseItemEntity> {
    override fun map(entity: ArticlesResponseItemEntity): ArticlesResponseItem = with(entity) {
        ArticlesResponseItem(
            events = events?.map {
                Event(id = it?.id, provider = it?.provider)
            },
            featured = featured,
            id = id,
            imageUrl = imageUrl,
            launches = launches?.map {
                Launch(it?.id, it?.provider)
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
