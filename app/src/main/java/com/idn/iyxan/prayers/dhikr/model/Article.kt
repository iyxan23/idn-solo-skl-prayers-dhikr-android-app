package com.idn.iyxan.prayers.dhikr.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    @DrawableRes
    val imageArtikel: Int,
    val titleArtikel: String,
    val descArtikel: String
) : Parcelable