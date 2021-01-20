package com.rodrigodominguez.rappitest.filmdetail.data

import java.io.Serializable

data class Backdrop(
    val aspect_ratio: Double,
    val file_path: String,
    val height: Int,
    val iso_639_1: Any,
    val vote_average: Float,
    val vote_count: Int,
    val width: Int
) : Serializable