package br.com.douglasmotta.kotlincoroutinesexample.di

import androidx.navigation.NavController
import br.com.douglasmotta.kotlincoroutinesexample.ui.main.MainRepository
import br.com.douglasmotta.kotlincoroutinesexample.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory {
        MainRepository()
    }

    viewModel { (navController: NavController) ->
        MainViewModel(
            repository = get(),
            navController = navController
        )
    }
}