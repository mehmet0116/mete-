package com.mete.braingame.data.models

data class Category(
    val id: Int,
    val name: String,
    val iconRes: String,
    val color: Long,
    val questions: List<Question>
)

data class Question(
    val id: Int,
    val text: String,
    val imageRes: String,
    val correctAnswer: String,
    val options: List<String>,
    val soundRes: String? = null
)