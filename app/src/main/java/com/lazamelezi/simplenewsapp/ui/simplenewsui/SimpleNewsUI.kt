package com.lazamelezi.simplenewsapp.ui.simplenewsui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.lazamelezi.simplenewsapp.other.Category
import com.lazamelezi.simplenewsapp.other.getTitleResource
import com.lazamelezi.simplenewsapp.viewmodel.SimpleNewsViewModel

@Composable
fun NewzzAppUI(viewModel: SimpleNewsViewModel) {
    val categoryList = viewModel.categoryList.observeAsState().value!!
    val activeCategory = viewModel.activeCategory.observeAsState().value!!
    val uiState = viewModel.activeCategoryUiState.observeAsState().value!!

    Scaffold(
        content = {
            BodyContent(
                activeCategory = activeCategory,
                activeCategoryUiState = uiState,
                onThemeSwitch = {
                    viewModel.performAction(SimpleNewsViewModel.Action.SwitchTheme)
                },
                retryFetchingArticles = { category ->
                    viewModel.performAction(SimpleNewsViewModel.Action.FetchArticles(category))
                }
            )
        },
        bottomBar = {
            BottomBar(
                categoryList = categoryList,
                onMenuClicked = { category ->
                    viewModel.performAction(SimpleNewsViewModel.Action.ChangePageTo(category))
                },
                activeCategory = activeCategory
            )
        }
    )
}

@Composable
fun BodyContent(
    activeCategory: Category,
    activeCategoryUiState: ArticleListUiState,
    onThemeSwitch: () -> Unit,
    retryFetchingArticles: (Category) -> Unit
) {
    val stringRes = getTitleResource(activeCategory)
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.primary
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(stringRes, onThemeSwitch = {
                onThemeSwitch()
            })
            NewzzListContainer(
                uiState = activeCategoryUiState,
                retry = {
                    retryFetchingArticles(activeCategory)
                }
            )
        }
    }
}
