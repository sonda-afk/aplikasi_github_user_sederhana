package com.sondari.dicoding.fundamentalsatu

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var avatar: Int = 0,
    var username: String = "",
    var name: String = "",
    var location: String = "",
    var repository: String = "",
    var company: String = "",
    var following: String = "",
    var followers: String = ""
): Parcelable
