package com.rodrigodominguez.rappitest.api

import com.rodrigodominguez.rappitest.filmdetail.data.FilmItemResponse
import com.rodrigodominguez.rappitest.listfilms.data.FilmsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Lego REST API access points
 */
interface FilmsService {

    @GET("discover/movie")
    suspend fun getFilms(
        @Query("year") year: String,
        // TODO se puede enviar desde el front
        @Query("sort_by") sort_by: String = "popularity.desc",
        // TODO se puede agarrar la apiKey desde gradle.debug/release para tener diferentes keys
        @Query("api_key") apiKey: String = "ac0719d1d31b0f444c5a62ddfcfea043"
    ): FilmsResponse

    @GET("movie/{id}}")
    suspend fun getFilm(
        @Path("id") id: String,
        // TODO se puede agarrar la apiKey desde gradle.debug/release para tener diferentes keys
        @Query("api_key") apiKey: String = "ac0719d1d31b0f444c5a62ddfcfea043",
        @Query("append_to_response") append: String = "images"
    ): FilmItemResponse

}
