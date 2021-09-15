package com.deniskutyavin.android_course

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "avatar") var avatarUrl: String,
    @Json(name = "first_name") var userName: String,
    @Json(name = "email") var groupName: String

)
