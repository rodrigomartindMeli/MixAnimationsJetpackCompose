package com.rodrigodominguez.rappitest.listfilms.data

import com.rodrigodominguez.rappitest.api.FilmsHelper

class FilmsRepository(private val filmsHelper: FilmsHelper) {

    suspend fun getFilms(year: String) = filmsHelper.getFilms(year)

    suspend fun getFilm(id: String) = filmsHelper.getFilm(id)
}