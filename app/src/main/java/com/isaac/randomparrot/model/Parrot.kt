package com.isaac.randomparrot.model

import com.squareup.moshi.Json

data class Parrot(
    @Json(name = "gif")
    val gif: String?,

    @Json(name = "hd")
    val hd: String?,

    @Json(name = "name")
    val name: String,

    @Json(name = "tip")
    val tip: String?
) {
    fun getBestQualityGif(): String? {
        if (hd != null) {
            return hd
        }
        return gif
    }
}

