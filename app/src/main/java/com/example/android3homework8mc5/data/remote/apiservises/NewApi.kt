package com.example.android3homework8mc5.data.remote.apiservises

import com.example.android3homework8mc5.data.remote.models.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val NEWS = "everything"

interface NewApi {

    @GET(NEWS)
    fun getNews(@Query("q") query: String): Call<NewsResponse>
}