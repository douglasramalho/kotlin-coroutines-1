package br.com.douglasmotta.kotlincoroutinesexample.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import br.com.douglasmotta.kotlincoroutinesexample.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val repository: MainRepository,
    private val navController: NavController
) : ViewModel() {

    val moviesEvent = MutableLiveData<List<Movie>>()

    fun getMovies() {
        repository.getMovies { movies ->
            moviesEvent.value = movies
        }
    }

    fun getMoviesCoroutines() {
        CoroutineScope(Dispatchers.Main).launch {
            val movies = withContext(Dispatchers.Default) {
                repository.getMoviesCoroutines()
            }

            moviesEvent.value = movies
        }
    }

    fun navigate() {
        navController.navigate(R.id.action_mainFragment_to_placeholder)
    }
}
