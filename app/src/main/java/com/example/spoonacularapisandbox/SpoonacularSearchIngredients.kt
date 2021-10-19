package com.example.spoonacularapisandbox

data class SpoonacularSearchIngredients(
    val number: Int,
    val offset: Int,
    val results: List<Ingredient>,
    val totalResults: Int
)