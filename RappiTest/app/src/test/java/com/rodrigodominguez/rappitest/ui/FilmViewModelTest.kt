package com.rodrigodominguez.rappitest.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.rodrigodominguez.rappitest.api.FilmsHelper
import com.rodrigodominguez.rappitest.api.FilmsService
import com.rodrigodominguez.rappitest.filmdetail.data.FilmItemResponse
import com.rodrigodominguez.rappitest.filmdetail.data.Images
import com.rodrigodominguez.rappitest.filmdetail.ui.FilmViewModel
import com.rodrigodominguez.rappitest.listfilms.data.FilmsRepository
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.*

@RunWith(JUnit4::class)
class FilmViewModelTest {
    private val idFilm = "550"

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var repository: FilmsRepository
    private lateinit var viewModel: FilmViewModel
    private lateinit var filmsService: FilmsService
    private lateinit var filmsHelper: FilmsHelper
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        filmsService = mock(FilmsService::class.java)
        filmsHelper = FilmsHelper(filmsService)
        repository = FilmsRepository(filmsHelper)
        viewModel = FilmViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun testFilmViewModelMethod() {
        val filmDetail = getFilmItemResponse()
        runBlockingTest {
            `when`(filmsService.getFilm(idFilm)).thenReturn(
                filmDetail
            )

            `when`(repository.getFilm(idFilm)).thenReturn(
                filmDetail
            )

            `when`(filmsHelper.getFilm(idFilm)).thenReturn(
                filmDetail
            )
            viewModel.getFilm(idFilm)
            verify(filmsService, times(0)).getFilm(idFilm)

            assertEquals(filmsService.getFilm(idFilm), filmDetail)
            assertEquals(repository.getFilm(idFilm), filmDetail)
            assertEquals(filmsHelper.getFilm(idFilm), filmDetail)
        }
    }

    private fun getFilmItemResponse(): FilmItemResponse {
        return FilmItemResponse(
            false,
            "",
            Any(),
            0,
            listOf(),
            "",
            0,
            Images(
                listOf(),
                listOf()
            ),
            "",
            "",
            "",
            "",
            0.0,
            "",
            listOf(),
            listOf(),
            "",
            0,
            0,
            listOf(),

            "",
            "",
            "",
            false,
            0.0,
            0
        )
    }
}