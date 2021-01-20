package com.rodrigodominguez.rappitest.api

class FilmsHelper (private val apiService: FilmsService) {
    suspend fun getFilms(year: String) = apiService.getFilms(year)

    suspend fun getFilm(id: String) = apiService.getFilm(id)
}