package com.rodrigodominguez.rappitest.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.rodrigodominguez.rappitest.api.FilmsHelper
import com.rodrigodominguez.rappitest.api.FilmsService
import com.rodrigodominguez.rappitest.filmdetail.data.FilmItemResponse
import com.rodrigodominguez.rappitest.filmdetail.data.Images
import com.rodrigodominguez.rappitest.listfilms.data.FilmsRepository
import com.rodrigodominguez.rappitest.listfilms.data.FilmsResponse
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.*


@RunWith(JUnit4::class)
class FilmsRepositoryTest {
    private lateinit var repository: FilmsRepository
    private val service = mock(FilmsService::class.java)
    private val filmsHelper = FilmsHelper(service)

    private val idFilm = "550"
    private val yearFilms = "2019"


    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()


    @Before
    fun init() {
        repository = FilmsRepository(filmsHelper)
    }

    @Test
    fun testRepositoryGetFilm() {
        val filmDetail = getFilmItemResponse()

        runBlocking {
            `when`(repository.getFilm(idFilm)).thenReturn(
                filmDetail
            )
            repository.getFilm(idFilm)

            assertEquals(repository.getFilm(idFilm), filmDetail)
        }
    }

    @Test
    fun testRepositoryGetFilms() {
        val filmDetail = getFilmsResponse()

        runBlocking {
            `when`(repository.getFilms(yearFilms)).thenReturn(
                filmDetail
            )
            repository.getFilms(yearFilms)

            assertEquals(repository.getFilms(yearFilms), filmDetail)
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

    private fun getFilmsResponse(): FilmsResponse {
        return FilmsResponse(
            0,
            1000,
            500,
            listOf()
        )
    }

}