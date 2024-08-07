package com.example.android3homework8mc5.data.remote.models

import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
)
