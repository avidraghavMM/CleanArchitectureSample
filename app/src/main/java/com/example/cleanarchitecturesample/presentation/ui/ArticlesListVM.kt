package com.example.cleanarchitecturesample.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturesample.presentation.model.ArticlesResponseItemUI
import com.example.cleanarchitecturesample.presentation.model.toPresenter
import com.example.cleanarchitecturesample.util.UIState
import com.example.domain.usecases.GetArticlesUseCase
import com.example.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesListVM @Inject constructor(
    private val getArticlesUseCase: GetArticlesUseCase,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private var _articlesState: MutableStateFlow<UIState<List<ArticlesResponseItemUI>>> =
        MutableStateFlow(UIState.Empty)
    val articlesState = _articlesState.asStateFlow()

    init {
        getArticles()
    }

    fun getArticles() {
        viewModelScope.launch(dispatcher) {
            _articlesState.emit(UIState.Loading)
            when (val response = getArticlesUseCase()) {
                is Resource.Error -> {
                    _articlesState.emit(UIState.Error(exception = response.exception))
                }
                is Resource.Success -> {
                    val mappedResponse = response.data.map {
                        it.toPresenter()
                    }
                    _articlesState.emit(UIState.Success(data = mappedResponse))
                }
            }
        }
    }
}
