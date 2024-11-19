package com.lazamelezi.simplenewsapp.ui.simplenewsui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lazamelezi.simplenewsapp.other.Category

@Composable
fun BottomBar(
    categoryList: List<Category>,
    activeCategory: Category,
    onMenuClicked: (Category) -> Unit
) {
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 10.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(50.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            categoryList.forEach { category ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = category.icon),
                            contentDescription = category.category,
                        )
                    },
                    selected = activeCategory == category,
                    onClick = {
                        onMenuClicked(category)
                    },
                    selectedContentColor = MaterialTheme.colors.primary,
                    unselectedContentColor = MaterialTheme.colors.secondary
                )
            }
        }
    }
}
