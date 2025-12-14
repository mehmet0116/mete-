package com.mete.braingame.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mete.braingame.data.GameData
import com.mete.braingame.ui.theme.AnimalColor
import com.mete.braingame.ui.theme.NumberColor
import com.mete.braingame.ui.theme.ShapeColor
import com.mete.braingame.ui.theme.ColorColor
import com.mete.braingame.ui.theme.LetterColor
import com.mete.braingame.ui.theme.FruitColor
import com.mete.braingame.ui.theme.VegetableColor
import com.mete.braingame.ui.theme.BodyPartColor
import com.mete.braingame.ui.theme.ActionColor
import com.mete.braingame.ui.theme.TimeColor

@Composable
fun CategorySelectionScreen(
    navController: NavController,
    onCategorySelected: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Kategori Seç",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        )
        
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(GameData.categories) { category ->
                CategoryCard(
                    category = category,
                    onClick = {
                        onCategorySelected(category.id)
                        navController.navigate("game/${category.id}")
                    }
                )
            }
        }
    }
}

@Composable
fun CategoryCard(
    category: com.mete.braingame.data.Category,
    onClick: () -> Unit
) {
    val cardColor = when (category.id) {
        1 -> AnimalColor
        2 -> NumberColor
        3 -> ShapeColor
        4 -> ColorColor
        5 -> LetterColor
        6 -> FruitColor
        7 -> VegetableColor
        8 -> BodyPartColor
        9 -> ActionColor
        10 -> TimeColor
        else -> MaterialTheme.colorScheme.primary
    }
    
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(cardColor.value).copy(alpha = 0.1f),
            contentColor = Color(cardColor.value)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = category.icon,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            Text(
                text = category.name,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            
            Text(
                text = category.description,
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}