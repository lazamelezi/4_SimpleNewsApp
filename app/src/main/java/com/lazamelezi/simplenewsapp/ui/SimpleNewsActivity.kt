package com.lazamelezi.simplenewsapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.livedata.observeAsState
import com.lazamelezi.simplenewsapp.ui.simplenewsui.NewzzAppUI
import com.lazamelezi.simplenewsapp.ui.style.NewzzTheme
import com.lazamelezi.simplenewsapp.viewmodel.SimpleNewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SimpleNewsActivity : ComponentActivity() {

    private val viewModel: SimpleNewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val darkTheme = viewModel.isDarkTheme.observeAsState(false)
            NewzzTheme(isDarkTheme = darkTheme.value) {
                NewzzAppUI(viewModel = viewModel)
            }
        }
    }
}
