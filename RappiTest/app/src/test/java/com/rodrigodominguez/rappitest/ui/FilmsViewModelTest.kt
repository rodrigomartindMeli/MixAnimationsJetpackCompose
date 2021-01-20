package com.rodrigodominguez.rappitest.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.rodrigodominguez.rappitest.api.FilmsHelper
import com.rodrigodominguez.rappitest.api.FilmsService
import com.rodrigodominguez.rappitest.listfilms.data.FilmsRepository
import com.rodrigodominguez.rappitest.listfilms.data.FilmsResponse
import com.rodrigodominguez.rappitest.listfilms.ui.FilmsViewModel
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.*

@RunWith(JUnit4::class)
class FilmsViewModelTest {
    private val yearFilms = "2019"

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var repository: FilmsRepository
    private lateinit var viewModel: FilmsViewModel
    private lateinit var filmsService: FilmsService
    private lateinit var filmsHelper: FilmsHelper
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        filmsService = mock(FilmsService::class.java)
        filmsHelper = FilmsHelper(filmsService)
        repository = FilmsRepository(filmsHelper)
        viewModel = FilmsViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testFilmsViewModel() {
        assertThat(viewModel.year, `is`(yearFilms))
        viewModel.year = yearFilms
        runBlockingTest {
            `when`(filmsService.getFilms(yearFilms)).thenReturn(
                getFilmsResponse()
            )

            `when`(repository.getFilms(yearFilms)).thenReturn(
                getFilmsResponse()
            )

            `when`(filmsHelper.getFilms(yearFilms)).thenReturn(
                getFilmsResponse()
            )

            viewModel.getFilms()
            verify(filmsService, times(0)).getFilms(yearFilms)

            assertEquals(filmsService.getFilms(yearFilms), getFilmsResponse())
            assertEquals(repository.getFilms(yearFilms), getFilmsResponse())
            assertEquals(filmsHelper.getFilms(yearFilms), getFilmsResponse())
        }
    }




    private fun getFilmsResponse(): FilmsResponse {
        return FilmsResponse(
            0,
            1000,
            500,
            listOf()
        )
    }
}