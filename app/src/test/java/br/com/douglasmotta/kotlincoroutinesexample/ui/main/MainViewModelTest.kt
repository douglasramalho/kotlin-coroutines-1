package br.com.douglasmotta.kotlincoroutinesexample.ui.main

import androidx.navigation.NavController
import br.com.douglasmotta.kotlincoroutinesexample.R
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @Mock
    private lateinit var navController: NavController

    @Mock
    private lateinit var repository: MainRepository

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel(repository, navController)
    }

    @Test
    fun test() {
        viewModel.navigate()
        verify(navController).navigate(R.id.action_mainFragment_to_placeholder)
    }
}