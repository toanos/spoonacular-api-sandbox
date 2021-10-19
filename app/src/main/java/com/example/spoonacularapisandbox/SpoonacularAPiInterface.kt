package com.example.spoonacularapisandbox

import retrofit2.Call
import retrofit2.http.GET

interface SpoonacularAPiInterface {

    // This is a hard coded implementation
    @GET(value = "food/ingredients/search?query=banana&number=5&apiKey=9f7cdafec5da49c3bad4c81f2e08713c")
    fun getSearchIngredients(): Call<SpoonacularSearchIngredients>
}