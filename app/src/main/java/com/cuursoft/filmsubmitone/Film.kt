package com.cuursoft.filmsubmitone

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    val nama: String?,
    val deskripsi: String?,
    val foto: Int
): Parcelable