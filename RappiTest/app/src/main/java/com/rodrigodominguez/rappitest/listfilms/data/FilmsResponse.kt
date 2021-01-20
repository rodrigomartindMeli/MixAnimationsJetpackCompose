package com.rodrigodominguez.rappitest.listfilms.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FilmsResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("total_result")
    val totalResult: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("results")
    val result: List<FilmItem>
) : Serializable