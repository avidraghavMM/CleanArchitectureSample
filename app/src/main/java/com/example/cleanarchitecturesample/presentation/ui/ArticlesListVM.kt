package com.example.cleanarchitecturesample.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturesample.presentation.mapper.ArticlesDomainToPresentationMapper
import com.example.cleanarchitecturesample.presentation.model.ArticlesResponseItemUI
import com.example.domain.usecases.GetArticlesUseCase
import com.example.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@HiltViewModel
class ArticlesListVM @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase,
    private val mapper: ArticlesDomainToPresentationMapper
) : ViewModel() {

    private var _articlesList: MutableStateFlow<Resource<List<ArticlesResponseItemUI>>> =
        MutableStateFlow(Resource.Loading())
    val articlesList: StateFlow<Resource<List<ArticlesResponseItemUI>>> get() = _articlesList

    init {
        getArticles()
    }

    private fun getArticles() {
        viewModelScope.launch {
            getArticlesUseCase()
                // mapping can/should be done on different thread
                .map {
                    it.map { article ->
                        mapper.map(article)
                    }
                }
                .catch {
                    _articlesList.emit(
                        Resource.Error(
                            message = it.localizedMessage ?: "Some error occurred"
                        )
                    )
                }
                .collect {
                    _articlesList.emit(Resource.Success(data = it))
                }
        }
    }
}
