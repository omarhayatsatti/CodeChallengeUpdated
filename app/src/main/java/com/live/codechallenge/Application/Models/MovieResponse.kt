package com.live.codechallenge.Application.Models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class MovieResponse {
    @SerializedName("data")
    @Expose
    private var data: List<Datum>? = null

    fun getData(): List<Datum>? {
        return data
    }

    fun setData(data: List<Datum>) {
        this.data = data
    }
}