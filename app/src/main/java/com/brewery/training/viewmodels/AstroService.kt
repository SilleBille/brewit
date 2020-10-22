package com.brewery.training.viewmodels

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import java.net.URL

suspend fun getAstronauts(): AstroResponse = coroutineScope {
    withContext(Dispatchers.IO) {
        Gson().fromJson(
            URL("http://api.open-notify.org/astros.json").readText(),
            AstroResponse::class.java
        )
    }
}

data class Assignment(
    val name: String,
    val craft: String
)

data class AstroResponse(
    val message: String,
    val number: Int,
    val people: List<Assignment>
)