package com.rodrigodominguez.rappitest.filmdetail.data

import java.io.Serializable

data class Poster(
    val aspect_ratio: Double,
    val file_path: String,
    val height: Int,
    val iso_639_1: String,
    val vote_average: Double,
    val vote_count: Int,
    val width: Int
) : Serializable