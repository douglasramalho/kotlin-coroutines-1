package br.com.douglasmotta.kotlincoroutinesexample.ui.main

import kotlinx.coroutines.*

open class MainRepository {

    fun getMovies(callback: (movies: List<Movie>) -> Unit) {
        Thread().run {
            Thread.sleep(3000)
            callback(
                listOf(
                    Movie(1, "Movie 01"),
                    Movie(2, "Movie 02")
                )
            )
        }
    }

    suspend fun getMoviesCoroutines(): List<Movie> {
        return withContext(Dispatchers.Default) {
            delay(3000)
            listOf<Movie>(Movie(1, "Title"))
        }
    }
}