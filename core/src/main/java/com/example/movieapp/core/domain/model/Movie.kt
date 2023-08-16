package com.example.movieapp.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: String,
    val original_title: String,
    val overview: String,
    val poster: String,
    val vote_average: String,
    val isFavorite: Boolean
) : Parcelable