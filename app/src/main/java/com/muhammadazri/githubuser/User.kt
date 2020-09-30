package com.muhammadazri.githubuser

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class User (
    var name: String ="",
    var username: String = "",
    var location: String = "",
    var repository: String = "",
    var company : String ="",
    var followers: String = "",
    var following: String = "",
    var photo: Int = 0
) : Parcelable