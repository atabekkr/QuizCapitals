package com.example.startactivity.data

data class Question(
    val id: Int,
    val question: String,
    val answers: List<String>,
    val correctAnswerId: Int
)
