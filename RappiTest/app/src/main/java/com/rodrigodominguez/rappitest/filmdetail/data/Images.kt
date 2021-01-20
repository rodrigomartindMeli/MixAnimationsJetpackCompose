package com.rodrigodominguez.rappitest.filmdetail.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Images(
    @SerializedName("backdrops")
    val backdrops: List<Backdrop>,
    @SerializedName("posters")
    val posters: List<Poster>
) : Serializable