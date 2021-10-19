package com.example.spoonacularapisandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import retrofit2.*
import retrofit2.converter.moshi.MoshiConverterFactory

const val BASE_URL = "https://api.spoonacular.com/"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSearchIngredients();
    }

    private fun getSearchIngredients() {
        // step 1: create retrofit builder object
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(SpoonacularAPiInterface::class.java)

        // step 2: get data from retrofit builder object
        val retrofitData = retrofitBuilder.getSearchIngredients()

        // step 3: perform call backs
        retrofitData.enqueue(object: Callback<List<Ingredient>?> {
            override fun onResponse(call: Call<List<Ingredient>?>, response: Response<List<Ingredient>?>) {
                val responseBody = response.body()!!
                val myStringBuilder = StringBuilder()
                // fetch the data
                for (ingredient in responseBody) {
                    myStringBuilder.append(ingredient.id)
                    myStringBuilder.append(ingredient.image)
                    myStringBuilder.append(ingredient.name)
                    myStringBuilder.append("\n")
                }

                // TODO send the fetched data to text view
            }

            override fun onFailure(call: Call<List<Ingredient>?>, t: Throwable) {}
        })
    }
}