package com.curso.android.app.practica.comparete

import kotlinx.coroutines.ExperimentalCoroutinesApi
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.comparete.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel:MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispacher = StandardTestDispatcher()
    @Before
    fun setup(){
        Dispatchers.setMain(dispacher)
        viewModel = MainViewModel()
    }
    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }
    @Test
    fun mainview_CheckIntervalue() = runTest {
        val value = viewModel.firsWord.value?.palabra
        val value2 = viewModel.secundWord.value?.palabraT2
        val value3 = viewModel.devolucion.value?.inf
        assertEquals("",value2)
        assertEquals("",value)
        assertEquals("", value3)
    }
    @Test
    fun mainview_testCompareWord() = runTest {
        launch {
            viewModel.firsWord.value = viewModel.firsWord.value?.copy(palabra = viewModel.firsWord.value?.palabra + "angel")
            viewModel.secundWord.value = viewModel.secundWord.value?.copy(palabraT2 = viewModel.secundWord.value?.palabraT2 + "angel")
            viewModel.compareWord()
        }
        advanceUntilIdle()
        val inf = viewModel.devolucion.value?.inf
        assertEquals("Palabras iguales",inf)
    }
    @Test
    fun mainview_testComparedWordFalse() = runTest {
        launch {
            viewModel.firsWord.value = viewModel.firsWord.value?.copy(palabra = viewModel.firsWord.value?.palabra + "angel")
            viewModel.secundWord.value = viewModel.secundWord.value?.copy(palabraT2 = viewModel.secundWord.value?.palabraT2 + "gabriel")
            viewModel.compareWord()
        }
        advanceUntilIdle()
        val inf = viewModel.devolucion.value?.inf
        assertEquals("Palabras no iguales",inf)
    }
    @Test
    fun mainview_testClear() = runTest {
        launch {
            viewModel.compareWord()
            viewModel.clean()
        }
        advanceUntilIdle()
        val inf = viewModel.devolucion.value?.inf
        assertEquals("",inf)


    }
}