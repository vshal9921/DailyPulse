package com.example.dailypulse.article

import com.example.dailypulse.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel : BaseViewModel() {

    private val _articlesState : MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))

    val articlesState : StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    private fun getArticles(){
        scope.launch {

            val fetched = fetchArticles()

            delay(500)

            _articlesState.emit(ArticlesState(articles = fetched))
        }
    }

    suspend fun fetchArticles() : List<Article> = sampleArticles

    private val sampleArticles = listOf<Article>(
        Article(
            title = "Three challenges in 2026: Bond yield, currency, and deposit mobilisation",
            description = "If these are the three challenges, there are also three key developments that everyone will watch out for",
            date = "2025-01-01" ,
            imageUrl = "https://bsmedia.business-standard.com/_media/bs/img/article/2025-08/26/full/1756229514-8794.jpg?im=FitAndFill=(826,465)"
        ),
        Article(
            title = "T20 World Cup: Bangladesh refuses India travel citing 'security concerns'",
            description = "The Bangladesh Cricket Board (BCB) on Sunday said it will not send its national team to India for the upcoming T20 World Cup, the Daily Star reported.",
            date = "2025-01-02" ,
            imageUrl = "https://bsmedia.business-standard.com/_media/bs/img/article/2026-01/04/full/1767507878-3145.jpg?im=FeatureCrop,size=(826,465)"
        ),
        Article(
            title = "How US' military operation in Venezuela could impact oil supply chains",
            description = "1xArrow Icon\n" +
                    "The US has captured Venezuelan President Nicolás Maduro in what Washington described as a “large-scale military operation”, marking one of the most dramatic US interventions in Latin America in decades. US President Donald Trump said Maduro and his wife, Cilia Flores, were seized in Caracas and flown out of the country following coordinated military strikes.",
            date = "2025-01-03" ,
            imageUrl = "https://bsmedia.business-standard.com/_media/bs/img/article/2018-06/19/full/1529349625-7324.jpg?im=FeatureCrop,size=(826,465)"
        ),
        Article(
            title = "Airlines move to bar power bank use in flight after DGCA circular",
            description = "Airlines have begun restricting the use of power banks on board flights after a DGCA circular warned of fire risks from lithium batteries and asked operators to strengthen onboard safety measures",
            date = "2025-01-04" ,
            imageUrl = "https://bsmedia.business-standard.com/_media/bs/img/article/2025-02/17/full/1739814359-805.jpg?im=FeatureCrop,size=(826,465)"
        )
    )
}